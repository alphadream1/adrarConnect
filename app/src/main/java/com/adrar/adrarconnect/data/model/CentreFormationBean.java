package com.adrar.adrarconnect.data.model;

//
// Created by FERRARIS Philippe on 13/06/2019 for adrarConnect.
//

class CentreFormationBean {

    private int id;
    private String numeroVoie, adresse, complementAdresse, cp, ville, telephone, coordonneeX, coordonneeY;


    //---------------
    // construteur
    //---------------

    public CentreFormationBean() {
        super();
    }

    public CentreFormationBean(String numeroVoie, String adresse, String complementAdresse, String ville, String telephone, String coordonneeX, String coordonneeY, String cp) {
        this.numeroVoie = numeroVoie;
        this.adresse = adresse;
        this.complementAdresse = complementAdresse;
        this.ville = ville;
        this.telephone = telephone;
        this.coordonneeX = coordonneeX;
        this.coordonneeY = coordonneeY;
        this.cp = cp;
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

    public String getNumeroVoie() {
        return numeroVoie;
    }

    public void setNumeroVoie(String numeroVoie) {
        this.numeroVoie = numeroVoie;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getComplementAdresse() {
        return complementAdresse;
    }

    public void setComplementAdresse(String complementAdresse) {
        this.complementAdresse = complementAdresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCoordonneeX() {
        return coordonneeX;
    }

    public void setCoordonneeX(String coordonneeX) {
        this.coordonneeX = coordonneeX;
    }

    public String getCoordonneeY() {
        return coordonneeY;
    }

    public void setCoordonneeY(String coordonneeY) {
        this.coordonneeY = coordonneeY;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }
}
