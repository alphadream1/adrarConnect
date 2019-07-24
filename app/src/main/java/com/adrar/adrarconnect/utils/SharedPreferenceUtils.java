package com.adrar.adrarconnect.utils;

//
// Created by FERRARIS Philippe on 23/07/2019 for adrarConnect.
//

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import com.adrar.adrarconnect.data.model.AccueilBean;
import com.adrar.adrarconnect.data.staticData.Constants;

public class SharedPreferenceUtils extends AppCompatActivity {

    SharedPreferences sharedPreferences = getBaseContext().getSharedPreferences(Constants.PREFS, MODE_PRIVATE);

    public void saveAccueil(AccueilBean a) {
        sharedPreferences
                .edit()
                .putString(Constants.PREFS_ACCUEIL, a + "")
                .apply();
    }
}
