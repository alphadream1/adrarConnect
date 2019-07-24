package com.adrar.adrarconnect;

//
// Created by FERRARIS Philippe on 13/06/2019 for adrarConnect.
//

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.adrar.adrarconnect.data.model.FaqBean;
import com.adrar.adrarconnect.utils.MyApplication;
import com.adrar.adrarconnect.ui.adapter.FaqAdapter;

import java.util.ArrayList;

import static com.adrar.adrarconnect.R.id;
import static com.adrar.adrarconnect.R.layout;

public class FaqActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_faq);

        // création de la lliste
        // Données
        ArrayList<FaqBean> data = new ArrayList<>();
        // remplissage de la liste
        data = MyApplication.getAccueilData().getFaq();
        // instanciation FaqAdapter
        // outils
        FaqAdapter adapter = new FaqAdapter(data);
        // composant graphique
        RecyclerView rvFaq = findViewById(id.rvFaq);
        // l'adapter que l'on souhaite afficher
        rvFaq.setAdapter(adapter);
        // réglage de l'affichage
        rvFaq.setLayoutManager(new LinearLayoutManager(this));

    }


}
