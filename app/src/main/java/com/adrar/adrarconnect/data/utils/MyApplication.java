package com.adrar.adrarconnect.data.utils;

//
// Created by FERRARIS Philippe on 01/07/2019 for adrarConnect.
//

import android.app.Application;
import android.util.Log;

import com.adrar.adrarconnect.data.model.AccueilBean;
import com.adrar.adrarconnect.data.model.UserBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApplication extends Application {

    public static AccueilBean accueilData;
    public static InterfaceWebServices webServices;
    public static UserBean utilisateur;

    @Override
    public void onCreate() {
        super.onCreate();
        accueilData = new AccueilBean();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        webServices = retrofit.create(InterfaceWebServices.class);
        webServices.getAccueilData().enqueue(new Callback<AccueilBean>() {
            @Override
            public void onResponse(Call<AccueilBean> call, Response<AccueilBean> response) {
                Log.w("retrofit", "Download ok");
                MyApplication.setAccueilData(response.body());
            }

            @Override
            public void onFailure(Call<AccueilBean> call, Throwable t) {
                Log.w("retrofit", "" + t);
            }
        });
    }

    //----------------
    // Getter & Setter
    //----------------
    public static AccueilBean getAccueilData() {
        return accueilData;
    }

    public static void setAccueilData(AccueilBean accueilData) {
        MyApplication.accueilData = accueilData;
    }

    public static UserBean getUtilisateur() {
        return utilisateur;
    }

    public static void setUtilisateur(UserBean utilisateur) {
        MyApplication.utilisateur = utilisateur;
    }
}
