package com.adrar.adrarconnect;

//
// Created by FERRARIS Philippe on 13/06/2019 for adrarConnect.
//

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.adrar.adrarconnect.data.model.FormationBean;
import com.adrar.adrarconnect.data.utils.MyApplication;
import com.adrar.adrarconnect.ui.AutoFitGridLayoutManager;
import com.adrar.adrarconnect.ui.adapter.FormationAdapter;

import java.util.ArrayList;

public class FormationActivity extends AppCompatActivity {

    // données
    private ArrayList<FormationBean> data;
    // composant graphique
    private RecyclerView rv;
    // outil
    private FormationAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formation);

        int pixelSize = getResources().getDimensionPixelSize(R.dimen.formationRowSize);

        // création de la liste
        data = new ArrayList<>();
        // Instanciation d'un FormationAdapter
        adapter = new FormationAdapter(data);
        rv = findViewById(R.id.rvFormation);
        //l'adapter que l'on souhaite afficher
        rv.setAdapter(adapter);
        //reglage de l'affichage
        rv.setLayoutManager(new AutoFitGridLayoutManager(this, pixelSize));

        data.addAll(MyApplication.getAccueilData().getFormations());

//        //--------------------------
//        // données pour jeux de test
//        //--------------------------
//        FormationBean formationBean = new FormationBean(getString(R.string.nom_de_la_formation), getString(R.string.lorem),getString(R.string.ramonville));
//        for (int num = 0; num < 7; num++) {
//            data.add(num, formationBean);
//        }
    }

}
