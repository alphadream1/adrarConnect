package com.adrar.adrarconnect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.adrar.adrarconnect.data.model.InfoCollectiveBean;
import com.adrar.adrarconnect.data.utils.MyApplication;
import com.adrar.adrarconnect.ui.adapter.InformationCollectiveAdapter;

import java.util.ArrayList;

public class ChoixInfoCoActivity extends AppCompatActivity {

    //Données
    private ArrayList<InfoCollectiveBean> data;
    private Bundle extraInfoco;
    // composant graphique
    private RecyclerView rv;

    //outils
    private InformationCollectiveAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_info_co);

        //----------------
        // instanciation
        //----------------
        data = new ArrayList<>();
        extraInfoco = getIntent().getExtras();
        adapter = new InformationCollectiveAdapter(data);
        rv = findViewById(R.id.rvChoixInformationCollective);
        // L’adapter que l’on souhaite afficher
        rv.setAdapter(adapter);
        //Réglage : affichage ligne par ligne
        rv.setLayoutManager(new LinearLayoutManager(this));

        data.addAll(MyApplication.getAccueilData().getListeInfosCollectives());
    }
}
