package com.adrar.adrarconnect.data.model;

//
// Created by FERRARIS Philippe on 19/06/2019 for adrarConnect.
//

class ProcessusInscriptionBean {

    //---------------
    // attributs
    //---------------
    private String salarie_html, demandeur_emploi_html, telephone, email;

    //---------------
    // constructeur
    //---------------

    public ProcessusInscriptionBean() {
        super();
    }

    public ProcessusInscriptionBean(ProcessusInscriptionBean data) {
        this.salarie_html = data.salarie_html;
        this.demandeur_emploi_html = data.getDemandeur_emploi_html();
        this.email = data.getEmail();
        this.telephone = data.getTelephone();
    }

    public ProcessusInscriptionBean(String salarie_html, String demandeur_emploi_html, String telephone, String email) {
        this.salarie_html = salarie_html;
        this.demandeur_emploi_html = demandeur_emploi_html;
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

    public String getDemandeur_emploi_html() {
        return demandeur_emploi_html;
    }

    public void setDemandeur_emploi_html(String demandeur_emploi_html) {
        this.demandeur_emploi_html = demandeur_emploi_html;
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
