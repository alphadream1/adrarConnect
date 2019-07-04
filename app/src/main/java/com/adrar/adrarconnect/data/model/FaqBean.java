package com.adrar.adrarconnect.data.model;

//
// Created by FERRARIS Philippe on 13/06/2019 for adrarConnect.
//

import java.io.Serializable;

public class FaqBean implements Serializable {

    private int id;
    private String question, reponse;

    //------------
    //CONSTRUCTEUR
    //------------

    public FaqBean() {
        super();
    }

    public FaqBean(String question, String reponse) {
        super();
        this.question = question;
        this.reponse = reponse;
    }

    //---------------
    //GETTRE & SETTER
    //---------------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }
}
