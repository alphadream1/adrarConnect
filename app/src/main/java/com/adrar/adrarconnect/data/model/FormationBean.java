package com.adrar.adrarconnect.data.model;

//
// Created by FERRARIS Philippe on 13/06/2019 for adrarConnect.
//

public class FormationBean {

    private int id;
    private String intitule, url_photo, html;

    //--------------
    // CONSTRUCTEUR
    //--------------

    public FormationBean() {
        super();
    }

    public FormationBean(String intitule, String url_photo, String html) {
        this.intitule = intitule;
        this.url_photo = url_photo;
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

    public String getUrl_photo() {
        return url_photo;
    }

    public void setUrl_photo(String url_photo) {
        this.url_photo = url_photo;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
