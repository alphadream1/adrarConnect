package com.adrar.adrarconnect.data.model;

//
// Created by FERRARIS Philippe on 13/06/2019 for adrarConnect.
//

import java.util.ArrayList;
import java.util.Date;

public class UserBean {

    private int id;
    private int ID_avancementInscription;
    private String prenom, nom, email, telephone, numeroPe, mdp, numeroVoie, adresse, complementAdresse, cp, ville, idSessionConnexion;
    private Date ddn;
    private int dev, reseau, admin;
    private ArrayList<DocumentsBean> listDocument;
    private InfoCollectiveBean infoCollectiveBean;

    //---------------
    // constructeur
    //---------------


    public UserBean() {
        super();
    }

    public UserBean(String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
    }

    public UserBean(String prenom, String nom, String email, String mdp) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
    }

    public UserBean(int id, int ID_avancementInscription, String prenom, String nom, String email, String telephone, String numeroPe, String mdp, String numeroVoie, String adresse, String complementAdresse, String cp, String ville, String idSessionConnexion, Date ddn, int dev, int reseau, int admin, ArrayList<DocumentsBean> listDocument, InfoCollectiveBean infoCollectiveBean) {
        this.id = id;
        this.ID_avancementInscription = ID_avancementInscription;
        this.prenom = prenom;
        this.nom = nom;
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
        this.listDocument = listDocument;
        this.infoCollectiveBean = infoCollectiveBean;
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

    public int getID_avancementInscription() {
        return ID_avancementInscription;
    }

    public void setID_avancementInscription(int ID_avancementInscription) {
        this.ID_avancementInscription = ID_avancementInscription;
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

    public ArrayList<DocumentsBean> getListDocument() {
        return listDocument;
    }

    public void setListDocument(ArrayList<DocumentsBean> listDocument) {
        this.listDocument = listDocument;
    }

    public InfoCollectiveBean getInfoCollectiveBean() {
        return infoCollectiveBean;
    }

    public void setInfoCollectiveBean(InfoCollectiveBean infoCollectiveBean) {
        this.infoCollectiveBean = infoCollectiveBean;
    }
}
