package com.adrar.adrarconnect.data.model;

//
// Created by FERRARIS Philippe on 13/06/2019 for adrarConnect.
//

import java.util.ArrayList;

public class UserBean {

    private int id;
    private String nom, prenom, email, telephone, numeroPe, mdp, numeroVoie, adresse, complementAdresse, cp, ville, idSessionConnexion;
    private Long ddn;
    private int dev, reseau, admin;
    private int ID_avancementInscription;
    private ArrayList<DocumentsBean> documents;
    private int ID_infoCollective;

    //---------------
    // constructeur
    //---------------


    public UserBean() {
        super();
    }

    public UserBean(int id, String nom, String prenom, String email, String telephone, String numeroPe, String mdp, String numeroVoie, String adresse, String complementAdresse, String cp, String ville, String idSessionConnexion, Long ddn, int dev, int reseau, int admin, int ID_avancementInscription, ArrayList<DocumentsBean> documents, int ID_infoCollective) {
        this.id = id;
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
        this.ID_avancementInscription = ID_avancementInscription;
        this.documents = documents;
        this.ID_infoCollective = ID_infoCollective;
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

    public ArrayList<DocumentsBean> getDocuments() {
        return documents;
    }

    public void setDocuments(ArrayList<DocumentsBean> documents) {
        this.documents = documents;
    }

    public int getID_infoCollective() {
        return ID_infoCollective;
    }

    public void setID_infoCollective(int ID_infoCollective) {
        this.ID_infoCollective = ID_infoCollective;
    }
}
