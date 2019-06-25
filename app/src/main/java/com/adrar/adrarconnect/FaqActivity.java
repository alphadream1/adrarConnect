package com.adrar.adrarconnect;

//
// Created by FERRARIS Philippe on 13/06/2019 for adrarConnect.
//

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.adrar.adrarconnect.ui.adapter.FaqAdapter;
import com.adrar.adrarconnect.data.model.FaqBean;

import java.util.ArrayList;

import static com.adrar.adrarconnect.R.id;
import static com.adrar.adrarconnect.R.layout;
import static com.adrar.adrarconnect.R.string;

public class FaqActivity extends AppCompatActivity {

    // Données
    private ArrayList<FaqBean> data;
    // composant graphique
    private RecyclerView rvFaq;
    // outils
    private FaqAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_faq);

        // création de la lliste
        data = new ArrayList<>();
        // instanciation FaqAdapter
        adapter = new FaqAdapter(data);
        rvFaq = findViewById(id.rvFaq);
        // l'adapter que l'on souhaite afficher
        rvFaq.setAdapter(adapter);
        // réglage de l'affichage
        rvFaq.setLayoutManager(new LinearLayoutManager(this));

        // ---------------
        // jeux de test de données
        // ---------------
        FaqBean faqBean = new FaqBean(getString(string.loremQuestion), getString(string.loremReponse));
        for (int num = 0; num < 10; num++) {
            data.add(num, faqBean);
        }

    }


}
