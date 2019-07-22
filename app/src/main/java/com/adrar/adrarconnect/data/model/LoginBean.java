package com.adrar.adrarconnect.data.model;

//
// Created by FERRARIS Philippe on 18/07/2019 for adrarConnect.
//

public class LoginBean {

    private String email;
    private String mdp;

    public LoginBean() {
    }

    public LoginBean(String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
    }

    //----------------
    // getter & setter
    //----------------

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
