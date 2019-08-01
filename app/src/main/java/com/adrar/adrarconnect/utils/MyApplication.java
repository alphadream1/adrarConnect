package com.adrar.adrarconnect.utils;

//
// Created by FERRARIS Philippe on 01/07/2019 for adrarConnect.
//

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.adrar.adrarconnect.data.model.AccueilBean;
import com.adrar.adrarconnect.data.model.LoginBean;
import com.adrar.adrarconnect.data.model.UserBean;
import com.adrar.adrarconnect.data.staticData.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApplication extends Application {

    private static AccueilBean accueilData;
    public static InterfaceWebServices webServices;
    public static UserBean utilisateur;
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
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
                assert response.body() != null;
                SharedPreferenceUtilsKt.saveAcceuil(response.body());
                MyApplication.setAccueilData(response.body());
            }

            @Override
            public void onFailure(Call<AccueilBean> call, Throwable t) {
                Log.w("retrofit", "Download fail : " + t);
                MyApplication.setAccueilData(SharedPreferenceUtilsKt.getAccueil());
            }
        });
    }

    //----------------
    // Getter & Setter
    //----------------
    public static AccueilBean getAccueilData() {
        return accueilData;
    }

    private static void setAccueilData(AccueilBean accueilData) {
        MyApplication.accueilData = accueilData;
    }

    public static UserBean getUtilisateur() {
        return utilisateur;
    }

    public static void setUtilisateur(UserBean utilisateur) {
        MyApplication.utilisateur = utilisateur;
    }

    public static InterfaceWebServices getWebServices() {
        return webServices;
    }

    public static void setWebServices(InterfaceWebServices webServices) {
        MyApplication.webServices = webServices;
    }
}
