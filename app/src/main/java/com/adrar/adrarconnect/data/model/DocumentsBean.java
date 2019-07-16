package com.adrar.adrarconnect.data.model;

//
// Created by FERRARIS Philippe on 13/06/2019 for adrarConnect.
//

public class DocumentsBean {

    private int id, id_typeDocument, id_users, etat;
    private String base64, idSessionConnexion;


    //---------------
    // constructeur
    //---------------

    public DocumentsBean() {
        super();
    }

    public DocumentsBean(int typeDocument, String base64, int etat, int id_users, String idSessionConnexion) {
        super();
        this.id_users = id_users;
        this.idSessionConnexion = idSessionConnexion;
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

    public String getIdSessionConnexion() {
        return idSessionConnexion;
    }

    public void setIdSessionConnexion(String idSessionConnexion) {
        this.idSessionConnexion = idSessionConnexion;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
}
