package com.adrar.adrarconnect.data.model;

//
// Created by FERRARIS Philippe on 19/06/2019 for adrarConnect.
//

import java.io.Serializable;

public class ProcessusInscriptionBean implements Serializable {

    //---------------
    // attributs
    //---------------
    private String demandeurEmploi_html, salarie_html, telephone, email;

    //---------------
    // constructeur
    //---------------

    public ProcessusInscriptionBean() {
        super();
    }

    public ProcessusInscriptionBean(ProcessusInscriptionBean data) {
        this.demandeurEmploi_html = data.getDemandeurEmploi_html();
        this.salarie_html = data.getSalarie_html();
        this.email = data.getEmail();
        this.telephone = data.getTelephone();
    }

    public ProcessusInscriptionBean(String salarie_html, String demandeurEmploi_html, String telephone, String email) {
        this.salarie_html = salarie_html;
        this.demandeurEmploi_html = demandeurEmploi_html;
        this.telephone = telephone;
        this.email = email;
    }

    //---------------
    // getter & setter
    //---------------

    public String getSalarie_html() {
        return salarie_html;
    }

    public void setSalarie_html(String salarie_html) {
        this.salarie_html = salarie_html;
    }

    public String getDemandeurEmploi_html() {
        return demandeurEmploi_html;
    }

    public void setDemandeurEmploi_html(String demandeurEmploi_html) {
        this.demandeurEmploi_html = demandeurEmploi_html;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
