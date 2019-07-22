package com.adrar.adrarconnect.data.model;

//
// Created by FERRARIS Philippe on 18/07/2019 for adrarConnect.
//

public class UpdateUserBean {

    private String idSessionConnexion, nom, prenom, telephone, numeroPe, numeroVoie, adresse, complementAdresse, cp, ville;
    private Long ddn;
    private int dev, reseau, admin, ID_avancementInscription;

    public UpdateUserBean() {
        super();
    }

    public UpdateUserBean(String idSessionConnexion, String nom, String prenom, String telephone, String numeroPe, String numeroVoie, String adresse, String complementAdresse, String cp, String ville, Long ddn, int dev, int reseau, int admin, int ID_avancementInscription) {
        this.idSessionConnexion = idSessionConnexion;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.numeroPe = numeroPe;
        this.numeroVoie = numeroVoie;
        this.adresse = adresse;
        this.complementAdresse = complementAdresse;
        this.cp = cp;
        this.ville = ville;
        this.ddn = ddn;
        this.dev = dev;
        this.reseau = reseau;
        this.admin = admin;
        this.ID_avancementInscription = ID_avancementInscription;
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNumeroPe() {
        return numeroPe;
    }

    public void setNumeroPe(String numeroPe) {
        this.numeroPe = numeroPe;
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

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Long getDdn() {
        return ddn;
    }

    public void setDdn(Long ddn) {
        this.ddn = ddn;
    }

    public int getDev() {
        return dev;
    }

    public void setDev(int dev) {
        this.dev = dev;
    }

    public int getReseau() {
        return reseau;
    }

    public void setReseau(int reseau) {
        this.reseau = reseau;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public int getID_avancementInscription() {
        return ID_avancementInscription;
    }

    public void setID_avancementInscription(int ID_avancementInscription) {
        this.ID_avancementInscription = ID_avancementInscription;
    }
}
