package com.adrar.adrarconnect.data.model;

//
// Created by FERRARIS Philippe on 13/06/2019 for adrarConnect.
//

import android.text.Editable;

import java.util.Date;

public class UserBean {

    private int id, avancementInscription;
    private String nom, prenom, email, telephone, numeroPe, mdp, numeroVoie, adresse, complementAdresse, cp, ville, idSessionConnexion;
    private Date ddn;
    private boolean dev, reseau, admin;
    private DocumentsBean documents;
    private InfoCollectiveBean infoCollective;

    //---------------
    // constructeur
    //---------------


    public UserBean(Editable text, Editable etPrenomText, Editable etEmailText, Editable etPasswordText) {
        super();
    }

    public UserBean(String nom, String prenom, String email, String mdp) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
    }

    public UserBean(int avancementInscription, String nom, String prenom, String email, String telephone, String numeroPe, String mdp, String numeroVoie, String adresse, String complementAdresse, String cp, String ville, String idSessionConnexion, Date ddn, boolean dev, boolean reseau, boolean admin, DocumentsBean documents, InfoCollectiveBean infoCollective) {
        this.avancementInscription = avancementInscription;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.numeroPe = numeroPe;
        this.mdp = mdp;
        this.numeroVoie = numeroVoie;
        this.adresse = adresse;
        this.complementAdresse = complementAdresse;
        this.cp = cp;
        this.ville = ville;
        this.idSessionConnexion = idSessionConnexion;
        this.ddn = ddn;
        this.dev = dev;
        this.reseau = reseau;
        this.admin = admin;
        this.documents = documents;
        this.infoCollective = infoCollective;
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

    public int getAvancementInscription() {
        return avancementInscription;
    }

    public void setAvancementInscription(int avancementInscription) {
        this.avancementInscription = avancementInscription;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
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

    public String getIdSessionConnexion() {
        return idSessionConnexion;
    }

    public void setIdSessionConnexion(String idSessionConnexion) {
        this.idSessionConnexion = idSessionConnexion;
    }

    public Date getDdn() {
        return ddn;
    }

    public void setDdn(Date ddn) {
        this.ddn = ddn;
    }

    public boolean isDev() {
        return dev;
    }

    public void setDev(boolean dev) {
        this.dev = dev;
    }

    public boolean isReseau() {
        return reseau;
    }

    public void setReseau(boolean reseau) {
        this.reseau = reseau;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public DocumentsBean getDocuments() {
        return documents;
    }

    public void setDocuments(DocumentsBean documents) {
        this.documents = documents;
    }

    public InfoCollectiveBean getInfoCollective() {
        return infoCollective;
    }

    public void setInfoCollective(InfoCollectiveBean infoCollective) {
        this.infoCollective = infoCollective;
    }
}
