package com.adrar.adrarconnect.data.model;

import java.io.Serializable;

public class InfoCollectiveBean implements Serializable {

    private int ID_InfoCollective;
    private long date;
    private CentreFormationBean centreDeFormation;
    private int nombrePlacesMax;
    private int complet;
    private String idSessionConnexion;


    //---------------
    // constructeur
    //---------------

    public InfoCollectiveBean() {
        super();
    }

    public InfoCollectiveBean(int date, int nombrePlacesMax) {
        this.date = date;
        this.nombrePlacesMax = nombrePlacesMax;
    }

    public InfoCollectiveBean(String idSessionConnexion, int ID_InfoCollective) {
        this.idSessionConnexion = idSessionConnexion;
        this.ID_InfoCollective = ID_InfoCollective;
    }

    public InfoCollectiveBean(int date, CentreFormationBean centreDeFormation, int nombrePlacesMax, int complet) {
        this.date = date;
        this.centreDeFormation = centreDeFormation;
        this.nombrePlacesMax = nombrePlacesMax;
        this.complet = complet;
    }

    //---------------
    // getter & setter
    //---------------


    public int getID_InfoCollective() {
        return ID_InfoCollective;
    }

    public void setID_InfoCollective(int ID_InfoCollective) {
        this.ID_InfoCollective = ID_InfoCollective;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getNombrePlacesMax() {
        return nombrePlacesMax;
    }

    public void setNombrePlacesMax(int nombrePlacesMax) {
        this.nombrePlacesMax = nombrePlacesMax;
    }

    public CentreFormationBean getCentreDeFormation() {
        return centreDeFormation;
    }

    public void setCentreDeFormation(CentreFormationBean centreDeFormation) {
        this.centreDeFormation = centreDeFormation;
    }

    public int getComplet() {
        return complet;
    }

    public String getIdSessionConnexion() {
        return idSessionConnexion;
    }

    public void setIdSessionConnexion(String idSessionConnexion) {
        this.idSessionConnexion = idSessionConnexion;
    }
}
