package com.adrar.adrarconnect;

//
// Created by FERRARIS Philippe on 13/06/2019 for adrarConnect.
//

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.adrar.adrarconnect.data.model.DocumentsBean;
import com.adrar.adrarconnect.data.utils.Constants;
import com.adrar.adrarconnect.data.utils.MyApplication;

public class EspacePersoActivity extends AppCompatActivity {

    private TextView tvPrenomUtilisateur;
    private SeekBar seekBar;
    private TextView tvMySpaceInscription;
    private TextView tvMySpaceInfoPerso;
    private TextView tvMySpaceDocuments;
    private TextView tvMySpaceInscriptionInfoCo;
    private TextView tvMySpaceParticipationInfoCo;
    private TextView tvMesInformations;
    private TextView tvMesDocuments;
    private TextView tvExplication;
    private TextView tvDossierValide;
    private ImageView ivIconCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espace_perso);
        tvPrenomUtilisateur = findViewById(R.id.tvPrenomUtilisateur);
        seekBar = findViewById(R.id.seekBar);
        tvMySpaceInscription = findViewById(R.id.tvMySpaceInscription);
        tvMySpaceInfoPerso = findViewById(R.id.tvMySpaceInfoPerso);
        tvMySpaceDocuments = findViewById(R.id.tvMySpaceDocuments);
        tvMySpaceInscriptionInfoCo = findViewById(R.id.tvMySpaceInscriptionInfoCo);
        tvMySpaceParticipationInfoCo = findViewById(R.id.tvMySpaceParticipationInfoCo);
        tvMesInformations = findViewById(R.id.tvMesInformations);
        tvMesDocuments = findViewById(R.id.tvMesDocuments);
        tvExplication = findViewById(R.id.tvExplication);
        tvDossierValide = findViewById(R.id.tvDossierValide);
        ivIconCheck = findViewById(R.id.ivCheck);

        //----------------
        // set des textView
        //----------------
        tvPrenomUtilisateur.setText(MyApplication.utilisateur.getPrenom());
        majAffichageTvExplicationAndSeekbar(MyApplication.utilisateur.getID_avancementInscription());
        dossierValide();
    }


    public void onClickTvMesInformations(View view) {
        startActivity(new Intent(this, MesInformationsActivity.class));
        finish();
    }

    public void onClickMesDocuments(View view) {
        startActivity(new Intent(this, MesDocumentsActivity.class));
        finish();
    }

    public void majAffichageTvExplicationAndSeekbar(int i) {
        switch (i) {
            case 1:
                tvExplication.setText(Constants.ETAPE_INFOPERSO);
                seekBar.setProgress(1);
                break;
            case 2:
                tvExplication.setText(Constants.ETAPE_DOC);
                seekBar.setProgress(2);
                break;
            case 3:
                tvExplication.setText(Constants.ETAPE_VALIDDOC);
                seekBar.setProgress(3);
                break;
            case 4:
                tvExplication.setText(Constants.ETAPE_INFOCO);
                seekBar.setProgress(4);
                break;
            case 5:
                tvExplication.setText(Constants.ETAPE_RAPPEL_INFOCO);
                seekBar.setProgress(5);
                break;
        }
    }

    public void dossierValide() {
        if (MyApplication.utilisateur.getListDocument() != null) {
            for (DocumentsBean document : MyApplication.utilisateur.getListDocument()) {
                if (document.getId_typeDocument() == Constants.DOC_TYPE_PRESCRIPTION_PE) {
                    if (document.getEtat() == Constants.DOC_VALIDER) {
                        ivIconCheck.setVisibility(View.VISIBLE);
                    } else {
                        ivIconCheck.setVisibility(View.INVISIBLE);
                    }
                }
            }
        } else {
            ivIconCheck.setVisibility(View.INVISIBLE);
        }
    }
}
