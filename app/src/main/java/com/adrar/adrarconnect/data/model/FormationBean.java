package com.adrar.adrarconnect.data.model;

//
// Created by FERRARIS Philippe on 13/06/2019 for adrarConnect.
//

import java.io.Serializable;

public class FormationBean implements Serializable {

    private int id;
    private String intitule, urlPhoto, html;

    //--------------
    // CONSTRUCTEUR
    //--------------

    public FormationBean() {
        super();
    }

    public FormationBean(String intitule, String urlPhoto, String html) {
        this.intitule = intitule;
        this.urlPhoto = urlPhoto;
        this.html = html;
    }

    //---------------
    // getter & setter
    //---------------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
