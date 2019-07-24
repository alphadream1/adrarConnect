package com.adrar.adrarconnect.data.model;

//
// Created by FERRARIS Philippe on 19/06/2019 for adrarConnect.
//

import java.util.ArrayList;

public class AccueilBean {

    //---------------
    // attribut
    //---------------

    private ProcessusInscriptionBean processusInscription;
    private ArrayList<InfoCollectiveBean> listeInfosCollectives;
    private ArrayList<FormationBean> formations;
    private ArrayList<FaqBean> faq;
    private String infosCollectives_html;
    private String adrar_html;

    //---------------
    // constructeur
    //---------------

    public AccueilBean() {
        super();
    }

    public AccueilBean(AccueilBean data) {
        processusInscription = new ProcessusInscriptionBean(data.getProcessusInscription());

        formations = new ArrayList<>();
        formations.addAll(data.getFormations());

        this.adrar_html = data.getAdrar_html();

        this.infosCollectives_html = data.getInfosCollectives_html();

        listeInfosCollectives = new ArrayList<>();
        listeInfosCollectives.addAll(data.getListeInfosCollectives());

        faq = new ArrayList<>();
        faq.addAll(data.getFaq());
    }

    //---------------
    // getter & setter
    //---------------

    public ArrayList<FormationBean> getFormations() {
        return formations;
    }

    public void setFormations(ArrayList<FormationBean> formations) {
        this.formations = formations;
    }

    public String getAdrar_html() {
        return adrar_html;
    }

    public ProcessusInscriptionBean getProcessusInscription() {
        return processusInscription;
    }

    public void setProcessusInscription(ProcessusInscriptionBean processusInscription) {
        this.processusInscription = processusInscription;
    }

    public String getInfosCollectives_html() {
        return infosCollectives_html;
    }

    public void setInfosCollectives_html(String infosCollectives_html) {
        this.infosCollectives_html = infosCollectives_html;
    }

    public ArrayList<InfoCollectiveBean> getListeInfosCollectives() {
        return listeInfosCollectives;
    }

    public void setListeInfosCollectives(ArrayList<InfoCollectiveBean> listeInfosCollectives) {
        this.listeInfosCollectives = listeInfosCollectives;
    }

    public ArrayList<FaqBean> getFaq() {
        return faq;
    }

    public void setFaq(ArrayList<FaqBean> faq) {
        this.faq = faq;
    }
}
