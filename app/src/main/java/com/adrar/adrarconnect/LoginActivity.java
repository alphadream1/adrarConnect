package com.adrar.adrarconnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.adrar.adrarconnect.data.model.UserBean;
import com.adrar.adrarconnect.data.utils.MyApplication;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText etIdentifiant;
    private EditText etPassword;
    private ProgressBar progressBar;
    private Button btSeConnecter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etIdentifiant = findViewById(R.id.etIdentifiant);
        etPassword = findViewById(R.id.etPassword);
        progressBar = findViewById(R.id.progressBar);
        btSeConnecter = findViewById(R.id.btSeConnecter);


    }

    public void onClickConnection(final View view) {
        if (MainActivity.isEmailValid(etIdentifiant.getText().toString())) {
            if (etPassword.getText().toString().trim().length() >= 6) {
                UserBean userBean = new UserBean(etIdentifiant.getText().toString(), etPassword.getText().toString());
                progressBar.setVisibility(View.VISIBLE);
                MyApplication.webServices.postUserLogin(userBean).enqueue(new Callback<UserBean>() {
                    @Override
                    public void onResponse(Call<UserBean> call, Response<UserBean> response) {
                        Log.w("LOGIN_OK", response.body().getIdSessionConnexion());
                        MyApplication.utilisateur = response.body();
                        startActivity(new Intent(view.getContext(), EspacePersoActivity.class));
                        finish();
                    }

                    @Override
                    public void onFailure(Call<UserBean> call, Throwable t) {
                        Log.w("erreur", t + "");
                        Toast.makeText(LoginActivity.this, "Une erreur dans votre identifiant ou mot de passe, merci de recommencer", Toast.LENGTH_LONG).show();
                    }
                });
            } else {
                Toast.makeText(this, "Le mot de passe ne contient pas les 6 caractères minimum", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "le format de l'identifiant n'est pas conforme, l'identifiant est votre email", Toast.LENGTH_LONG).show();
        }
    }
}
