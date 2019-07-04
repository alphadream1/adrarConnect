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
    public static final SimpleDateFormat SDF_ALL = new SimpleDateFormat("dd/MM/yyyy à HH:mm", Locale.FRANCE);

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

    // pour l'emulateur utiliser l'adresse 10.0.2.2 et non localhost
    public static final String URL_BASE = "http://192.168.56.1:3000";
    public static final String URL_ACCUEIL = "/ws/accueil";
    public static final String URL_SIGNIN = "/ws/signin";
    public static final String URL_LOGIN = "/ws/login";
    public static final String URL_CANDIDAT = "/ws/candidat";
    public static final String URL_CANDIDAT_UPDATE_DETAILS = URL_CANDIDAT + "/update/details/";
    public static final String URL_CANDIDAT_UPDATE_DOCUMENT = URL_CANDIDAT + "/update/doc/";
    public static final String URL_INFOCOL = "/ws/infos-collectives";
    public static final String URL_INFOCOL_INSCRIPTION = URL_INFOCOL + "/inscription";
    public static final String URL_INFOCOL_MODIFICATION = URL_INFOCOL + "/update/";
    public static final String URL_INFOCOL_ANNULATION = URL_INFOCOL + "/delete/";
    public static final String URL_ERREUR = "/ws/erreur";

}
