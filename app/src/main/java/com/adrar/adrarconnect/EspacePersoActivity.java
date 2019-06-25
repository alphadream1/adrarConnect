package com.adrar.adrarconnect;

//
// Created by FERRARIS Philippe on 13/06/2019 for adrarConnect.
//

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class EspacePersoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espace_perso);
    }


    public void onClickTvMesInformations(View view) {
        startActivity(new Intent(this, MesInformationsActivity.class));
    }

    public void onClickMesDocuments(View view) {
        startActivity(new Intent(this, MesDocumentsActivity.class));
    }
}
