package com.adrar.adrarconnect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.adrar.adrarconnect.data.model.InfoCollectiveBean;
import com.adrar.adrarconnect.ui.adapter.InformationCollectiveAdapter;

import java.util.ArrayList;

public class ChoixInformationCollectiveActivity extends AppCompatActivity {

    //Données
    private ArrayList<InfoCollectiveBean> data;

    // composant graphique
    private RecyclerView rv;

    //outils
    private InformationCollectiveAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_information_collective);

        //Création de la liste
        data = new ArrayList<>();
//Instanciation d’un EleveAdapter
        adapter = new InformationCollectiveAdapter(data);
        rv = findViewById(R.id.rvChoixInformationCollective);
// L’adapter que l’on souhaite afficher
        rv.setAdapter(adapter);
//Réglage : Est ce qu'on affiche ligne par ligne ou
        rv.setLayoutManager(new LinearLayoutManager(this));


        // ---------------
        // jeux de test de données
        // ---------------
        InfoCollectiveBean infoColBean = new InfoCollectiveBean(getString(R.string._date), 15);
        for (int num = 0; num < 10; num++) {
            data.add(num, infoColBean);
        }
    }
}
