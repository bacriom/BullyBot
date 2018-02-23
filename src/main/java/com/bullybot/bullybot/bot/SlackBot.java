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

    @Controller(events = {EventType.DIRECT_MENTION, EventType.DIRECT_MESSAGE}, pattern = "setup", next = "confirmBulled")
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
            reply(session, event, new Message("Habemus Victim"));
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
        if(!chanels.isEmpty()){
            if (event.getText() != null && event.getText().matches(chanels.get(0).getIdVictim()+".+\\?") && chanels.get(0).getIdVictim() != null) {
                saveQuestion(event);
            }else if(StringUtils.isEmpty(chanels.get(0).getIdVictim()) && event.getText().matches("<@+\\w+>.+\\?")){
                reply(session, event, new Message("sorry there is no bullied yet, you can configure the bullied using " + slackService.getCurrentUser().getName() + " `setup`"));
            } else if(event.getThreadTs() != null) {
                saveAnswer(event);
            }
        }
        else{
            reply(session, event, new Message("Something is wrong :(, there isn't a channel"));
        }

    }

    @Controller(events = EventType.REACTION_ADDED)
    public void onRecivedRA(WebSocketSession session, Event event){
            if (event.getReaction().equals("+1")) {
                reply(session, event, new Message("reaccion"));
                correctAnswer(event,true);
            } else {
                reply(session, event, new Message("Nop"));
            }
        }

    @Controller(events = EventType.REACTION_REMOVED)
    public void onRecivedRmReaction(WebSocketSession session, Event event){
        if (event.getReaction().equals("+1")){
            correctAnswer(event,false);
        }
    }

    public void saveAnswer(Event event){
        List<Question> questions = null;
        Answer answer = new Answer(event.getText(),event.getThreadTs(),event.getTs(),false);
        answerRepository.save(answer);
    }

    public void saveQuestion(Event event){
        Question question = new Question(event.getText(), null, event.getChannelId(), event.getUserId(), event.getTs());
        questionRepository.save(question);
        }

    public void correctAnswer(Event event, Boolean flag){
        List<Answer> answers = null;
        answers = answerRepository.findByTimestamp(event.getItem().getTs());
        answers.get(0).setCorrectAnswer(flag);
        answerRepository.save(answers.get(0));
        if(flag){
            setAnswer(answers.get(0), answers.get(0).getText());
        } else {
            setAnswer(answers.get(0),"");
        }
    }

    public void setAnswer(Answer answer, String text){
        List<Question> questions = null;
        questions = questionRepository.findByTimeStamp(answer.getIdThreadTs());
        questions.get(0).setAnswerText(text);
        questionRepository.save(questions.get(0));
    }


}
