package com.adrar.adrarconnect.data.staticData;

//
// Created by FERRARIS Philippe on 18/06/2019 for adrarConnect.
//

import com.google.gson.Gson;

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
    // GSON
    //---------------
    public static final Gson GSON = new Gson();

    //---------------
    // pour les types de document
    //---------------

    public static final int DOC_TYPE_PHOTO = 1;
    public static final int DOC_TYPE_CV = 2;
    public static final int DOC_TYPE_LETTRE_MOTIVATION = 3;
    public static final int DOC_TYPE_PRESCRIPTION_PE = 4;

    //---------------
    // pour les URL
    //---------------

    public static final String URL_BASE = "http://192.168.56.1:3000"; // url de test local
    //public static final String URL_BASE = "http://vps623648.ovh.net:3000"; // url du serveur distant

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

    //----------------
    //  pour les textes de "mon espace"
    //----------------

    public static final String ETAPE_INFOPERSO = "Suite à votre inscription vous pouvez maintenant suivre notre processus de recrutement. Veuillez ajouter vos informations personnelles.";
    public static final String ETAPE_DOC = "Vous avez bien rempli vos informations personnelles. Veuillez ajouter vos documents.";
    public static final String ETAPE_VALIDDOC = "Vous avez bien ajouté vos documents, merci. En attente de validation par notre équipe";
    public static final String ETAPE_INFOCO = "Votre dossier a bien été validé. Vous pouvez vous inscrire à une information collective";
    public static final String ETAPE_RAPPEL_INFOCO = "Votre inscription a bien été prise en compte. Vous êtes inscrit à la session de :"; // + infoCoDate
    public static final String ETAPE_FINAL = "Merci d'avoir utilisé Adrar Connect";

    //----------------
    // pour les booleens des users etc
    //----------------

    public static final int BOOLEEN_TRUE = 1;
    public static final int BOOLEEN_FALSE = 0;

    //----------------
    //  pour les id_avancement inscription
    //----------------

    public static final int AVANCEMENT_INSCRIPTION_DOC = 2;
    public static final int AVANCEMENT_INSCRIPTION_VALIDDOC = 3;
    public static final int AVANCEMENT_INSCRIPTION_INFOCO = 4;
    public static final int AVANCEMENT_INSCRIPTION_RAPPEL_INFOCO = 5;

    //----------------
    // pour les etats des docs
    //----------------

    public static final int DOC_NULL = 0;
    public static final int DOC_ENVOYER = 1;
    public static final int DOC_VALIDER = 2;

    //----------------
    // pour les sharedPreferences
    //----------------

    public static final String PREFS = "PREFS";
    public static final String PREFS_ACCUEIL = "PREFS_ACCUEIL";
}
