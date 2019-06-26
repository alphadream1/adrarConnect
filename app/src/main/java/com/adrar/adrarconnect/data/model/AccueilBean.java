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
    private ArrayList<FormationBean> dataFormation;
    private String adrar_html;
    private String informationCollective_html;
    private ArrayList<InfoCollectiveBean> dataInfoCo;
    private ArrayList<FaqBean> dataFaq;

    //---------------
    // constructeur
    //---------------

    public AccueilBean() {
        super();
    }

    public AccueilBean(AccueilBean data) {
        processusInscription = new ProcessusInscriptionBean(data.getProcessusInscription());

        dataFormation = new ArrayList<>();
        dataFormation.addAll(data.getDataFormation());

        this.adrar_html = data.getAdrar_html();

        this.informationCollective_html = data.getInformationCollective_html();

        dataInfoCo = new ArrayList<>();
        dataInfoCo.addAll(data.getDataInfoCo());

        dataFaq = new ArrayList<>();
        dataFaq.addAll(data.getDataFaq());
    }

    //---------------
    // getter & setter
    //---------------

    public ArrayList<FormationBean> getDataFormation() {
        return dataFormation;
    }

    public void setDataFormation(ArrayList<FormationBean> dataFormation) {
        this.dataFormation = dataFormation;
    }

    public String getAdrar_html() {
        return adrar_html;
    }

    public void setAdrar_html(String adrar_html) {
        this.adrar_html = adrar_html;
    }

    public ProcessusInscriptionBean getProcessusInscription() {
        return processusInscription;
    }

    public void setProcessusInscription(ProcessusInscriptionBean processusInscription) {
        this.processusInscription = processusInscription;
    }

    public String getInformationCollective_html() {
        return informationCollective_html;
    }

    public void setInformationCollective_html(String informationCollective_html) {
        this.informationCollective_html = informationCollective_html;
    }

    public ArrayList<InfoCollectiveBean> getDataInfoCo() {
        return dataInfoCo;
    }

    public void setDataInfoCo(ArrayList<InfoCollectiveBean> dataInfoCo) {
        this.dataInfoCo = dataInfoCo;
    }

    public ArrayList<FaqBean> getDataFaq() {
        return dataFaq;
    }

    public void setDataFaq(ArrayList<FaqBean> dataFaq) {
        this.dataFaq = dataFaq;
    }
}
