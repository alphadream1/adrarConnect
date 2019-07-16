package com.adrar.adrarconnect;

//
// Created by FERRARIS Philippe on 13/06/2019 for adrarConnect.
//

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.adrar.adrarconnect.data.model.UserBean;
import com.adrar.adrarconnect.data.utils.MyApplication;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SinscrireActivity extends AppCompatActivity {


    private EditText etNom;
    private EditText etPrenom;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etConfirMdp;

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

        if (!etNom.getText().toString().equals("")) {
            if (!etPrenom.getText().toString().equals("")) {
                if (MainActivity.isEmailValid(etEmail.getText().toString())) {
                    if (etPassword.getText().toString().trim().length() >= 6) {
                        if (etPassword.getText().toString().equals(etConfirMdp.getText().toString())) {
                            UserBean userBean = new UserBean(etPrenom.getText().toString(), etNom.getText().toString(), etEmail.getText().toString(), etPassword.getText().toString());
                            MyApplication.webServices.postUserSignin(userBean).enqueue(new Callback<UserBean>() {
                                @Override
                                public void onResponse(@NonNull Call<UserBean> call, @NonNull Response<UserBean> response) {
                                    assert response.body() != null;
                                    Log.w("ca marche", response.body().getNom());
                                    MyApplication.setUtilisateur(response.body());
                                }

                                @Override
                                public void onFailure(Call<UserBean> call, Throwable t) {
                                    Log.w("erreur", "" + t);
                                }
                            });
                            if (MyApplication.utilisateur == null) {
                                Toast.makeText(this, "cette email est déjà utilisé.", Toast.LENGTH_LONG).show();
                            } else {
                                startActivity(new Intent(this, EspacePersoActivity.class));
                                finish();
                            }
                        } else {
                            Toast.makeText(this, "le mot de passe et sa confirmation ne sont pas identique.", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(this, "Le mot de passe doit contenir 6 caractères minimum.", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(this, "le format de l'email n'est pas bon.", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this, "Veuillez saisir votre prénom.", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Veuillez saisir votre nom.", Toast.LENGTH_LONG).show();
        }
    }
}
