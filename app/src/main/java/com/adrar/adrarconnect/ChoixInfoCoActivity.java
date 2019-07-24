package com.adrar.adrarconnect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.adrar.adrarconnect.data.model.InfoCollectiveBean;
import com.adrar.adrarconnect.ui.adapter.InformationCollectiveAdapter;
import com.adrar.adrarconnect.utils.MyApplication;

import java.util.ArrayList;

public class ChoixInfoCoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_info_co);

        //----------------
        // instanciation
        //----------------
        //Données
        ArrayList<InfoCollectiveBean> data = new ArrayList<>();
        Bundle extraInfoco = getIntent().getExtras();
        //outils
        InformationCollectiveAdapter adapter = new InformationCollectiveAdapter(data);
        // composant graphique
        RecyclerView rv = findViewById(R.id.rvChoixInformationCollective);
        // L’adapter que l’on souhaite afficher
        rv.setAdapter(adapter);
        //Réglage : affichage ligne par ligne
        rv.setLayoutManager(new LinearLayoutManager(this));
        if (MyApplication.getAccueilData().getListeInfosCollectives() != null) {
            data.addAll(MyApplication.getAccueilData().getListeInfosCollectives());
        }
    }
}
