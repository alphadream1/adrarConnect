package com.adrar.adrarconnect.data.model;

//
// Created by FERRARIS Philippe on 20/06/2019 for adrarConnect.
//

public class ErreurBean {

    //---------------
    // attribut
    //---------------

    private int code;
    private String description;

    //---------------
    // constructeur
    //---------------

    public ErreurBean() {
        super();
    }

    public ErreurBean(int code, String description) {
        this.code = code;
        this.description = description;
    }

    //----------------
    // getter & setter
    //----------------

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
