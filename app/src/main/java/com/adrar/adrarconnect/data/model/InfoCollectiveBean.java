package com.adrar.adrarconnect.data.model;

public class InfoCollectiveBean {

    private int id;
    // todo changer le format date de string vers long. le string c'etait juste pour tester
    private String date;
    // private long date;
    private CentreFormationBean centreDeFormation;
    private int nombrePlacesMax;
    private boolean complet;


    //---------------
    // constructeur
    //---------------

    public InfoCollectiveBean() {
        super();
    }

    public InfoCollectiveBean(String date, int nombrePlacesMax) {
        this.date = date;
        this.nombrePlacesMax = nombrePlacesMax;
    }

    public InfoCollectiveBean(String date, CentreFormationBean centreDeFormation, int nombrePlacesMax, boolean complet) {
        this.date = date;
        this.centreDeFormation = centreDeFormation;
        this.nombrePlacesMax = nombrePlacesMax;
        this.complet = complet;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public boolean isComplet() {
        return complet;
    }

    public void setComplet(boolean complet) {
        this.complet = complet;
    }
}
