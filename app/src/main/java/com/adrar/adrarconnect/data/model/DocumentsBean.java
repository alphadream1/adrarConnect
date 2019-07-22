package com.adrar.adrarconnect.data.model;

//
// Created by FERRARIS Philippe on 13/06/2019 for adrarConnect.
//

public class DocumentsBean {

    private int id, id_typeDocument, id_users, etat;
    private String base64;


    //---------------
    // constructeur
    //---------------

    public DocumentsBean() {
        super();
    }

    public DocumentsBean(int id, int typeDocument, String base64, int etat, int id_users) {
        super();
        this.id = id;
        this.id_users = id_users;
        this.id_typeDocument = typeDocument;
        this.base64 = base64;
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

    public int getId_typeDocument() {
        return id_typeDocument;
    }

    public void setId_typeDocument(int id_typeDocument) {
        this.id_typeDocument = id_typeDocument;
    }

    public int getId_users() {
        return id_users;
    }

    public void setId_users(int id_users) {
        this.id_users = id_users;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
}
