package com.adrar.adrarconnect;

//
// Created by FERRARIS Philippe on 13/06/2019 for adrarConnect.
//

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.adrar.adrarconnect.data.model.DocumentsBean;
import com.adrar.adrarconnect.data.utils.Constants;
import com.adrar.adrarconnect.data.utils.MyApplication;

public class MySpaceActivity extends AppCompatActivity {

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
    private TextView tvInscritInfocoMySpace;
    private TextView tvDateInfocoMySpace;
    private TextView tvLieuInfocoMySpace;
    private CardView cvMySpace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_space);
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
        tvInscritInfocoMySpace = findViewById(R.id.tvInscritInfocoMySpace);
        tvDateInfocoMySpace = findViewById(R.id.tvDateInfocoMySpace);
        tvLieuInfocoMySpace = findViewById(R.id.tvLieuInfocoMySpace);
        cvMySpace = findViewById(R.id.cvMySpace);

        //----------------
        // set des textView
        //----------------
        tvPrenomUtilisateur.setText(MyApplication.utilisateur.getPrenom());
        majAffichageTvExplicationAndSeekbar(MyApplication.utilisateur.getID_avancementInscription());
        if (dossierValide()) {
            ivIconCheck.setVisibility(View.VISIBLE);
        }
        if (MyApplication.getUtilisateur().getID_infoCollective() > 0) {
            tvInscritInfocoMySpace.setVisibility(View.VISIBLE);
            cvMySpace.setVisibility(View.VISIBLE);
            tvDateInfocoMySpace.setText(Constants.SDF_ALL.format(MyApplication.getAccueilData().getListeInfosCollectives().get(MyApplication.getUtilisateur().getID_infoCollective() - 1).getDate()));
            tvLieuInfocoMySpace.setText(MyApplication.getAccueilData().getListeInfosCollectives().get(MyApplication.getUtilisateur().getID_infoCollective() - 1).getCentreDeFormation().getVille());
        }
    }


    public void onClickTvMesInformations(View view) {
        startActivity(new Intent(this, MyPersonalDataActivity.class));
    }

    public void onClickMesDocuments(View view) {
        startActivity(new Intent(this, MyDocActivity.class));
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
                tvExplication.setText(Constants.ETAPE_INFOCO);
                seekBar.setProgress(3);
                break;
            case 4:
                tvExplication.setText(Constants.ETAPE_RAPPEL_INFOCO);
                seekBar.setProgress(4);
                break;
            case 5:
                tvExplication.setText(Constants.ETAPE_FINAL);
                seekBar.setProgress(5);
                break;
        }
    }

    public boolean dossierValide() {
        Boolean ppeValide = false;
        Boolean cvValide = false;
        if (MyApplication.getUtilisateur().getDocuments() != null) {
            for (DocumentsBean document : MyApplication.getUtilisateur().getDocuments()) {
                if (document.getId_typeDocument() == Constants.DOC_TYPE_PRESCRIPTION_PE) {
                    if (document.getEtat() == Constants.DOC_VALIDER) {
                        ppeValide = true;
                    }
                }
                if (document.getId_typeDocument() == Constants.DOC_TYPE_CV) {
                    if (document.getEtat() == Constants.DOC_VALIDER) {
                        cvValide = true;
                    }
                }
            }
        }
        if (ppeValide && cvValide) {
            return true;
        } else {
            return false;
        }

    }

    public void onClickProcessusMySpace(View view) {
        startActivity(new Intent(this, ProcessusActivity.class));
        finish();
    }
}
