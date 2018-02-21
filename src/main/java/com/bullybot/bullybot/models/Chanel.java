package com.bullybot.bullybot.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chanel {

    @Id
    String slackIdChanel;
    String idVictim;

    public Chanel() {
    }

    public Chanel(String slackIdChanel) {
        this.slackIdChanel = slackIdChanel;
    }

    public String getSlackIdChanel() {
        return slackIdChanel;
    }

    public void setSlackIdChanel(String slackIdChanel) {
        this.slackIdChanel = slackIdChanel;
    }

    public String getIdVictim() {
        return idVictim;
    }

    public void setIdVictim(String idVictim) {
        this.idVictim = idVictim;
    }

    @Override
    public String toString() {
        return "Chanel{" +
                "slackIdChanel='" + slackIdChanel + '\'' +
                ", idVictim='" + idVictim + '\'' +
                ", bulled=" +
                '}';
    }
}
