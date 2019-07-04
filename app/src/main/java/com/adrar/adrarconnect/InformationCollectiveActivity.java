package com.adrar.adrarconnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.adrar.adrarconnect.data.utils.MyApplication;

public class InformationCollectiveActivity extends AppCompatActivity {


    //----------------
    // méthode
    //----------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_collective);

        // instanciation des composants
        //----------------
        // composant de la vue
        //----------------
        WebView wvInfoco = findViewById(R.id.wvInfoco);
        TextView tvMsgErreur = findViewById(R.id.tvMsgErreur);
        Button btSinscrireInfoCo = findViewById(R.id.btSinscrireInfoCo);


        //----------------
        // affichage des données
        //----------------
        wvInfoco.loadData(MyApplication.getAccueilData().getInfosCollectives_html(), "text/html", "utf-8");


    }

    public void onClickSinscrireInformationCollective(View view) {
        // on prepare la nouvelle activité
        Intent choixInfocoIntent = new Intent(this, ChoixInfoCoActivity.class);
        // on lance l'Activité
        startActivity(choixInfocoIntent);
    }
}
