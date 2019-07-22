package com.adrar.adrarconnect.data.model;

//
// Created by FERRARIS Philippe on 22/07/2019 for adrarConnect.
//

public class InfocoUserBean {

    private String idSessionConnexion;
    private int ID_infoCollective;

    public InfocoUserBean() {
        super();
    }

    public InfocoUserBean(String idSessionConnexion, int ID_infoCollective) {
        this.idSessionConnexion = idSessionConnexion;
        this.ID_infoCollective = ID_infoCollective;
    }

    //----------------
    // getter & setter
    //----------------

    public String getIdSessionConnexion() {
        return idSessionConnexion;
    }

    public void setIdSessionConnexion(String idSessionConnexion) {
        this.idSessionConnexion = idSessionConnexion;
    }

    public int getID_infoCollective() {
        return ID_infoCollective;
    }

    public void setID_infoCollective(int ID_infoCollective) {
        this.ID_infoCollective = ID_infoCollective;
    }
}
