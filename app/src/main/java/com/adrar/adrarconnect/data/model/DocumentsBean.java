package com.adrar.adrarconnect.data.model;

//
// Created by FERRARIS Philippe on 13/06/2019 for adrarConnect.
//

public class DocumentsBean {

    private int id, typeDocument;
    private String chemin;
    private boolean etat;

    //---------------
    // constructeur
    //---------------

    public DocumentsBean() {
        super();
    }

    public DocumentsBean(int typeDocument, String chemin, boolean etat) {
        super();
        this.typeDocument = typeDocument;
        this.chemin = chemin;
        this.etat = etat;
    }

    //----------------
    // getter & setter
    //----------------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(int typeDocument) {
        this.typeDocument = typeDocument;
    }

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }
}
