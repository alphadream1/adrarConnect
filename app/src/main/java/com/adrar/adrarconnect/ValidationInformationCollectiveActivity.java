package com.adrar.adrarconnect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.adrar.adrarconnect.data.model.InfoCollectiveBean;
import com.adrar.adrarconnect.data.utils.Constants;

public class ValidationInformationCollectiveActivity extends AppCompatActivity {

    private TextView tvInscriptionValide;
    private TextView tvInscrit;
    private TextView tvComplet;
    private TextView tvAnnuler;
    private TextView tvValider;
    private TextView tvInscriptionRemplacement;
    private TextView tvInscrit2;
    private TextView tvComplet2;
    private TextView tvDateInfoco;
    private TextView tvVilleInfoco;
    private TextView tvDateInfoCol2;
    private TextView tvVilleInfoCol2;
    private InfoCollectiveBean data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation_information_collective);
        data = (InfoCollectiveBean) getIntent().getSerializableExtra("infoco");


        tvDateInfoco = findViewById(R.id.tvDateInfoCol);
        tvVilleInfoco = findViewById(R.id.tvVilleInfoCol);
        tvDateInfoCol2 = findViewById(R.id.tvDateInfoCol2);
        tvVilleInfoCol2 = findViewById(R.id.tvVilleInfoCol2);
        tvInscrit = findViewById(R.id.tvInscrit);
        tvComplet = findViewById(R.id.tvComplet);
        tvAnnuler = findViewById(R.id.tvAnnuler);
        tvValider = findViewById(R.id.tvValider);
        tvInscriptionRemplacement = findViewById(R.id.tvInscriptionRemplacement);
        tvInscrit2 = findViewById(R.id.tvInscrit2);
        tvComplet2 = findViewById(R.id.tvComplet2);
        tvInscriptionValide = findViewById(R.id.tvInscriptionValide);


        // todo continuer pour mettre en place les condition pour l'affichage de 2 infoco celle de l'user et celle ou il souhaite s'inscrire

        tvVilleInfoCol2.setText(data.getCentreDeFormation().getVille());
        tvDateInfoCol2.setText(Constants.SDF_ALL.format(data.getDate()));


    }

    public void onClickValider(View view) {

    }

    public void onClickAnnuler(View view) {
        finish();
    }
}
