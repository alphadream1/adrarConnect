package com.adrar.adrarconnect;

//
// Created by FERRARIS Philippe on 13/06/2019 for adrarConnect.
//

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.adrar.adrarconnect.data.model.FormationBean;
import com.adrar.adrarconnect.ui.AutoFitGridLayoutManager;
import com.adrar.adrarconnect.ui.adapter.FormationAdapter;
import com.adrar.adrarconnect.utils.MyApplication;

import java.util.ArrayList;

public class FormationActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formation);

        int pixelSize = getResources().getDimensionPixelSize(R.dimen.formationRowSize);

        // création de la liste
        // données
        ArrayList<FormationBean> data = new ArrayList<>();
        // Instanciation d'un FormationAdapter
        // outil
        FormationAdapter adapter = new FormationAdapter(data);
        // composant graphique
        RecyclerView rv = findViewById(R.id.rvFormation);
        //l'adapter que l'on souhaite afficher
        rv.setAdapter(adapter);
        //reglage de l'affichage
        rv.setLayoutManager(new AutoFitGridLayoutManager(this, pixelSize));

        data.addAll(MyApplication.getAccueilData().getFormations());

    }

}
