package com.adrar.adrarconnect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.adrar.adrarconnect.data.model.InfoCollectiveBean;
import com.adrar.adrarconnect.data.utils.Constants;

public class ValidationInformationCollectiveActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation_information_collective);
        InfoCollectiveBean data = (InfoCollectiveBean) getIntent().getSerializableExtra("infoco");


        TextView tvDateInfoco = findViewById(R.id.tvDateInfoCol);
        TextView tvVilleInfoco = findViewById(R.id.tvVilleInfoCol);
        TextView tvDateInfoCol2 = findViewById(R.id.tvDateInfoCol2);
        TextView tvVilleInfoCol2 = findViewById(R.id.tvVilleInfoCol2);
        TextView tvInscrit = findViewById(R.id.tvInscrit);
        TextView tvComplet = findViewById(R.id.tvComplet);
        TextView tvAnnuler = findViewById(R.id.tvAnnulerDoc);
        TextView tvValider = findViewById(R.id.tvValiderDoc);
        TextView tvInscriptionRemplacement = findViewById(R.id.tvInscriptionRemplacement);
        TextView tvInscrit2 = findViewById(R.id.tvInscrit2);
        TextView tvComplet2 = findViewById(R.id.tvComplet2);
        TextView tvInscriptionValide = findViewById(R.id.tvInscriptionValide);


        // todo continuer pour mettre en place les condition pour l'affichage de 2 infoco celle de l'user et celle ou il souhaite s'inscrire
        tvInscriptionRemplacement.setText(R.string.vous_tes_inscrit_a_cette_information_collective);
        tvVilleInfoCol2.setText(data.getCentreDeFormation().getVille());
        tvDateInfoCol2.setText(Constants.SDF_ALL.format(data.getDate()));


    }

    public void onClickValider(View view) {

    }

    public void onClickAnnuler(View view) {
        finish();
    }
}
