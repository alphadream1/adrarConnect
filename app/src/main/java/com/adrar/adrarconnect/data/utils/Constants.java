package com.adrar.adrarconnect.data.utils;

//
// Created by FERRARIS Philippe on 18/06/2019 for adrarConnect.
//

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Constants {

    //---------------
    // pour les dates
    //---------------

    public static final SimpleDateFormat SDF_JJ_MM_AAAA = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
    public static final SimpleDateFormat SDF_HH_MM = new SimpleDateFormat("HH:mm", Locale.FRANCE);
    public static final SimpleDateFormat SDF_ALL = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.FRANCE);

    //---------------
    // pour les types de document
    //---------------

    public static final int DOC_TYPE_PHOTO = 0;
    public static final int DOC_TYPE_CV = 1;
    public static final int DOC_TYPE_LETTRE_MOTIVATION = 2;
    public static final int DOC_TYPE_PRESCRIPTION_PE = 3;

    //---------------
    // pour les URL
    //---------------

    public static final String URL_BASE = "localhost:3000/ws";
    public static final String URL_ACCUEIL = URL_BASE + "/accueil";
    public static final String URL_SIGNIN = URL_BASE + "/signin";
    public static final String URL_LOGIN = URL_BASE + "/login";
    public static final String URL_CANDIDAT = URL_BASE + "/candidat";
    public static final String URL_CANDIDAT_UPDATE_DETAILS = URL_CANDIDAT + "/update/details/";
    public static final String URL_CANDIDAT_UPDATE_DOCUMENT = URL_CANDIDAT + "/update/doc/";
    public static final String URL_INFOCOL = URL_BASE + "/infos-collectives";
    public static final String URL_INFOCOL_INSCRIPTION = URL_INFOCOL + "/inscription";
    public static final String URL_INFOCOL_MODIFICATION = URL_INFOCOL + "/update/";
    public static final String URL_INFOCOL_ANNULATION = URL_INFOCOL + "/delete/";
    public static final String URL_ERREUR = URL_BASE + "/erreur";

}
