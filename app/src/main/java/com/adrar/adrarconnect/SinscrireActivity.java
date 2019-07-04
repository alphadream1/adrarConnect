package com.adrar.adrarconnect;

//
// Created by FERRARIS Philippe on 13/06/2019 for adrarConnect.
//

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.adrar.adrarconnect.data.utils.InterfaceWebServices;
import com.adrar.adrarconnect.data.model.UserBean;
import com.adrar.adrarconnect.data.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SinscrireActivity extends AppCompatActivity {


    private EditText etNom;
    private EditText etPrenom;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etConfirMdp;
    private UserBean userBean;
    private InterfaceWebServices webServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinscrire);

        etNom = findViewById(R.id.etNom);
        etPrenom = findViewById(R.id.etPrenom);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirMdp = findViewById(R.id.etConfirMdp);
    }

    public void onClickAnnulerSinscrire(View view) {
        etNom.setText("");
        etPrenom.setText("");
        etEmail.setText("");
        etPassword.setText("");
        etConfirMdp.setText("");
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void onClickValiderSinscrire(View view) {
        userBean = new UserBean(etNom.getText(), etPrenom.getText(), etEmail.getText(), etPassword.getText());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webServices = retrofit.create(InterfaceWebServices.class);
        webServices.postUserSignin(userBean);
    }
}
