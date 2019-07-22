package com.adrar.adrarconnect.data.model;

//
// Created by FERRARIS Philippe on 18/07/2019 for adrarConnect.
//

public class SigninBean {

    private String nom;
    private String prenom;
    private String email;
    private String mdp;

    //----------------
    // construteur
    //----------------

    public SigninBean() {
        super();
    }

    public SigninBean(String nom, String prenom, String email, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
    }

    //----------------
    // getter & setter
    //----------------

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

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
