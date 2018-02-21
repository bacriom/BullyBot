package com.bullybot.bullybot.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Answer {

    @Id
    @GeneratedValue
    private Long id;
    private String text;
    private String idThreadTs;
    private String timestamp;
    private boolean correctAnswer;

    public Answer() {
    }

    public Answer(String text, String idThreadTs, String timestamp, boolean correctAnswer) {
        this.text = text;
        this.idThreadTs = idThreadTs;
        this.timestamp = timestamp;
        this.correctAnswer = correctAnswer;
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

    public String getIdThreadTs() {
        return idThreadTs;
    }

    public void setIdThreadTs(String idThreadTs) {
        this.idThreadTs = idThreadTs;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
