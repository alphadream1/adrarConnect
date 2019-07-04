package com.adrar.adrarconnect;

//
// Created by FERRARIS Philippe on 13/06/2019 for adrarConnect.
//

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.adrar.adrarconnect.data.utils.InterfaceWebServices;

public class MainActivity extends AppCompatActivity {

    // -------------
    // data
    // -------------

    // constantes pour le burger menu
    private static final int ITEM_ID_FAQ;
    private static final int ITEM_ID_MY_SPACE;
    private static final int ITEM_ID_INFO_COL;

    static {
        ITEM_ID_FAQ = 1;
        ITEM_ID_MY_SPACE = 2;
        ITEM_ID_INFO_COL = 3;
    }

    // --------------
    public InterfaceWebServices webServices;

    // --------------
    // on create
    // --------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    // --------------
    // burgerMenu
    //---------------

    //Création du menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, ITEM_ID_FAQ, 0, "FAQ");
        menu.add(1, ITEM_ID_MY_SPACE, 1, "Mon espace");
        menu.add(2, ITEM_ID_INFO_COL, 2, "Information Collective");
        return super.onCreateOptionsMenu(menu);
    }

    // ajout des onClickListener sur les items du menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // si faq est cliquer
        if (item.getItemId() == ITEM_ID_FAQ) {
            // on lance l'activity FAQ
            startActivity(new Intent(this, FaqActivity.class));
        }
        // si mon espace est cliquer
        else if (item.getItemId() == ITEM_ID_MY_SPACE) {
            startActivity(new Intent(this, EspacePersoActivity.class));
        }
        // si info collective est cliquer
        else if (item.getItemId() == ITEM_ID_INFO_COL) {
            // on lance l'activité FAQ
            startActivity(new Intent(this, InformationCollectiveActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    // -----------------
    // Action
    // -----------------

    // methode onclick pour le bouton "adrar" le clic lance l'activité "adrar"
    public void onClickBoutonAdrar(View view) {
        // on lance l'activité "adrar"
        startActivity(new Intent(this, AdrarActivity.class));
    }

    // methode onclick pour le bouton "s'inscire" le clic lance l'activité pour s'inscrire
    public void onClickBoutonSinscrire(View view) {
        startActivity(new Intent(this, SinscrireActivity.class));
    }

    // methode onclick pour le bouton "formation" le clic lance l'activité pour se renseigner sur les formations
    public void onClickBoutonFormation(View view) {
        startActivity(new Intent(this, FormationActivity.class));
    }

    // methode onclick pour le bouton "processus" le clic lance l'activité pour les modalités sur les formations
    public void onClickBoutonProcessus(View view) {
        // on lance l'activité processus d 'inscription
        startActivity(new Intent(this, ProcessusActivity.class));
    }

    // methode onclick sur le textview "se connecter" le clic lance l'activité pour se logguer
    public void onClickSeConnecter(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }
}
