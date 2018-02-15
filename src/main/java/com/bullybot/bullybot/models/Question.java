package com.bullybot.bullybot.models;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;


@Entity
public class Question {

    @Id
    @GeneratedValue
    private Long id;
    private String text;
    private String idAnswer;
    private String idChanel;
    private String idQuestioner;
    private String timeStamp;

    public Question() {
    }

    public Question(String text, String idAnswer, String idChanel, String idQuestioner,String timeStamp) {
        this.text = text;
        this.idAnswer = idAnswer;
        this.idChanel = idChanel;
        this.idQuestioner = idQuestioner;
        this.timeStamp = timeStamp;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(String idAnswer) {
        this.idAnswer = idAnswer;
    }

    public String getIdChanel() {
        return idChanel;
    }

    public void setIdChanel(String idChanel) {
        this.idChanel = idChanel;
    }

    public String getIdQuestioner() {
        return idQuestioner;
    }

    public void setIdQuestioner(String idQuestioner) {
        this.idQuestioner = idQuestioner;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", idAnswer='" + idAnswer + '\'' +
                ", idChanel='" + idChanel + '\'' +
                ", idQuestioner='" + idQuestioner + '\'' +
                '}';
    }
}
