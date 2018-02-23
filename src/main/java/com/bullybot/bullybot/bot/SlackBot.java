package com.bullybot.bullybot.bot;

import com.bullybot.bullybot.models.Answer;
import com.bullybot.bullybot.models.Chanel;
import com.bullybot.bullybot.models.Question;
import com.bullybot.bullybot.repository.AnswerRepository;
import com.bullybot.bullybot.repository.ChanelRepository;
import com.bullybot.bullybot.repository.QuestionRepository;
import me.ramswaroop.jbot.core.slack.Bot;
import me.ramswaroop.jbot.core.slack.Controller;
import me.ramswaroop.jbot.core.slack.EventType;
import me.ramswaroop.jbot.core.slack.models.Event;
import me.ramswaroop.jbot.core.slack.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.WebSocketSession;

import java.util.List;

@Component
public class SlackBot extends Bot {

    //private static final Logger logger = LoggerFactory.getLogger(SlackBot.class);

    @Autowired
    ChanelRepository chanelRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Value("${slackBotToken}")
    private String slackToken;

    public String getSlackToken() {
        return slackToken;
    }

    public Bot getSlackBot() {
        return this;
    }


    @Controller(events = {EventType.DIRECT_MENTION})
    public void onReceiveDM(WebSocketSession session, Event event) {
        Chanel chanel = new Chanel(event.getChannelId());
        chanelRepository.save(chanel);
        reply(session, event, new Message("Hi, I am" + slackService.getCurrentUser().getName()));
        reply(session, event, new Message("Type '@" + slackService.getCurrentUser().getName() + " help' to know the commands"));
    }

    @Controller(events = {EventType.DIRECT_MENTION, EventType.DIRECT_MESSAGE}, pattern = "help")
    public void showCommands(WebSocketSession session, Event event) {
        reply(session, event, new Message("Type '@" + slackService.getCurrentUser().getName() + " setup' to configurate a bulled"));
    }

    @Controller(events = {EventType.DIRECT_MENTION, EventType.DIRECT_MESSAGE}, pattern = "configurate", next = "confirmBulled")
    public void setBulled(WebSocketSession session, Event event) {
        startConversation(event, "confirmBulled");
        reply(session, event, new Message("Cool, who will be the bulled?"));
    }

    @Controller
    public void confirmBulled(WebSocketSession session, Event event) {
        if (event.getText() != null && event.getText().matches("<+@+\\w+>")) {
            Chanel chanel = chanelRepository.findOne(event.getChannelId());
            chanel.setIdVictim(event.getText());
            chanelRepository.save(chanel);
            reply(session, event, new Message("Bulled is: " + event.getText()));
            stopConversation(event);
        } else if (!StringUtils.isEmpty(event.getText()) && "cancel".equalsIgnoreCase(event.getText())) {
            reply(session, event, new Message("Ok, you can setup the victim later."));
            stopConversation(event);
        } else {
            reply(session, event, new Message("It isn't a valid user. Type `cancel` if you want to cancel the setup."));
        }

    }

    @Controller(events = EventType.MESSAGE)
    public void onReceiveMessage(WebSocketSession session, Event event) {
        List<Chanel> chanels = chanelRepository.findBySlackIdChanel(event.getChannelId());
        if (event.getText() != null && event.getText().matches(chanels.get(0).getIdVictim()+".+\\?")) {
            reply(session, event, new Message("is a question"));
            saveQuestion(event);
        } else if(event.getThreadTs() != null) {
            saveAnswer(event);
        }
    }

    @Controller(events = EventType.REACTION_ADDED)
    public void onRecivedRA(WebSocketSession session, Event event){
            if (event.getReaction().equals("+1")) {
                reply(session, event, new Message("reaccion"));
                correctAnswer(event);
            } else {
                reply(session, event, new Message("Nop"));
            }
        }

    public void saveAnswer(Event event){
        List<Question> questions = null;
        String [] parts = event.getThreadTs().split("\\.");
        Answer answer = new Answer(event.getText(),parts[0],event.getTs(),false);
        answerRepository.save(answer);
    }

    public void saveQuestion(Event event){
        String [] parts = event.getTs().split("\\.");
        Question question = new Question(event.getText(), null, event.getChannelId(), event.getUserId(), parts[0]);
        questionRepository.save(question);
        }

    public void correctAnswer(Event event){
        List<Answer> answers = null;
        answers = answerRepository.findByTimestamp(event.getItem().getTs());
        answers.get(0).setCorrectAnswer(true);
        answerRepository.save(answers.get(0));
        setAnswer(answers.get(0));
    }

    public void setAnswer(Answer answer){
        List<Question> questions = null;
        questions = questionRepository.findByTimeStamp(answer.getIdThreadTs());
        questions.get(0).setAnswerText(answer.getText());
        questionRepository.save(questions.get(0));
    }


}
