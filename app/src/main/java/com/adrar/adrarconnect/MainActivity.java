package com.adrar.adrarconnect;

//
// Created by FERRARIS Philippe on 13/06/2019 for adrarConnect.
//

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.adrar.adrarconnect.utils.MyApplication;

public class MainActivity extends AppCompatActivity {

    // -------------
    // data
    // -------------

    // constantes pour le burger menu
    private static final int ITEM_ID_FAQ;
    private static final int ITEM_ID_SE_DECONNECTER;

    static {
        ITEM_ID_FAQ = 1;
        ITEM_ID_SE_DECONNECTER = 4;
    }

    //----------------
    // attributs
    //----------------
    private Button btInscrire;
    private TextView tvSeConnecter;

    // --------------
    // on create
    // --------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // les findViewById necessaires
        btInscrire = findViewById(R.id.btInscrire);
        tvSeConnecter = findViewById(R.id.tvSeConnecter);

        //on test si un utilisateur est logguer, et on set les affichage suivant la réponse
        if (MyApplication.utilisateur != null) {
            btInscrire.setText(getString(R.string.infoco_main));
            tvSeConnecter.setText(getString(R.string.mon_espace_main));
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (MyApplication.utilisateur != null) {
            btInscrire.setText(getString(R.string.infoco_main));
            tvSeConnecter.setText(getString(R.string.mon_espace_main));
        }
    }

    // --------------
    // burgerMenu
    //---------------

    //Création du menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, ITEM_ID_FAQ, 0, "FAQ");
        if (MyApplication.utilisateur != null) {
            menu.add(3, ITEM_ID_SE_DECONNECTER, 1, "Se déconnecter");
        }
        return super.onCreateOptionsMenu(menu);
    }

    // ajout des onClickListener sur les items du menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // si faq est cliquer
        if (item.getItemId() == ITEM_ID_FAQ) {
            //si on a bien les données FAQ
            if (MyApplication.getAccueilData().getFaq() != null) {
                // on lance l'activity FAQ
                startActivity(new Intent(this, FaqActivity.class));
            } else {
                Toast.makeText(this, "Un problème est survenu pendant le chargement des données des FAQ", Toast.LENGTH_LONG).show();
            }
        } else if (item.getItemId() == ITEM_ID_SE_DECONNECTER) {
            MyApplication.setUtilisateur(null);
            recreate();
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

    // methode onclick pour le bouton "s'inscire" le clic lance l'activité pour s'inscrire si on est pas inscrit ou logguer, sinon lance la page infoco
    public void onClickBoutonSinscrire(View view) {
        // si id session connection de l'utilisateur est null on lance l'inscription
        if (MyApplication.getUtilisateur() == null) {
            startActivity(new Intent(this, SigninActivity.class));
            recreate();
        }// sinon on lance les infoco
        else {
            startActivity(new Intent(this, InformationCollectiveActivity.class));
        }
    }

    // methode onclick pour le bouton "formation" le clic lance l'activité pour se renseigner sur les formations
    public void onClickBoutonFormation(View view) {
        if (MyApplication.getAccueilData().getFormations() != null) {
            startActivity(new Intent(this, FormationActivity.class));
        } else {
            Toast.makeText(this, "Un problème est survenu dans le chargement des formations", Toast.LENGTH_LONG).show();
        }
    }

    // methode onclick pour le bouton "processus" le clic lance l'activité pour les modalités sur les formations
    public void onClickBoutonProcessus(View view) {
        if (MyApplication.getAccueilData().getProcessusInscription() != null) {
            startActivity(new Intent(this, ProcessusActivity.class));
        } else {
            Toast.makeText(this, "Une erreur est survenu dans le chargement du processus de recrutement", Toast.LENGTH_LONG).show();
        }
    }

    // methode onclick sur le textview "se connecter" le clic lance l'activité pour se logguer, si déja logguer deviens l'acces a l'espace perso
    public void onClickSeConnecter(View view) {
        // on test si idsessionsConnection est null si oui on lance l'activité login, sinon on lance espace perso
        if (MyApplication.getUtilisateur() == null) {
            startActivity(new Intent(this, LoginActivity.class));
            recreate();
        } else {
            startActivity(new Intent(this, MySpaceActivity.class));
        }
    }

    // methode pour tester les etMail, savoir si le texte rentrer est bien au format email donc avec "@" et .com , .fr , etc.
    public static boolean isEmailValid(CharSequence email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
