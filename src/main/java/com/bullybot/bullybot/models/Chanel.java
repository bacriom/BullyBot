package com.bullybot.bullybot.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Chanel {

    @Id
    private String slackIdChanel;
    private String idVictim;
    private boolean bulled;

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

    public boolean isBulled() {
        return bulled;
    }

    public void setBulled(boolean bulled) {
        this.bulled = bulled;
    }

    @Override
    public String toString() {
        return "Chanel{" +
                "slackIdChanel='" + slackIdChanel + '\'' +
                ", idVictim='" + idVictim + '\'' +
                ", bulled=" + bulled +
                '}';
    }
}
