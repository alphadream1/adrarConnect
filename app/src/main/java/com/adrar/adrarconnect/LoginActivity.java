package com.adrar.adrarconnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.adrar.adrarconnect.data.model.LoginBean;
import com.adrar.adrarconnect.data.model.UserBean;
import com.adrar.adrarconnect.utils.MyApplication;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText etIdentifiant;
    private EditText etPassword;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etIdentifiant = findViewById(R.id.etIdentifiant);
        etPassword = findViewById(R.id.etPassword);
        progressBar = findViewById(R.id.progressBar);

        etIdentifiant.setHint(R.string.mail);
        etPassword.setHint(R.string.mdp);
    }

    public void onClickConnection(final View view) {
        if (MainActivity.isEmailValid(etIdentifiant.getText().toString())) {
            if (etPassword.getText().toString().trim().length() >= 6) {
                LoginBean loginBean = new LoginBean(etIdentifiant.getText().toString(), etPassword.getText().toString());
                progressBar.setVisibility(View.VISIBLE);
                MyApplication.webServices.postUserLogin(loginBean).enqueue(new Callback<UserBean>() {
                    @Override
                    public void onResponse(Call<UserBean> call, Response<UserBean> response) {
                        if (response.body() != null) {
                            Log.w("LOGIN_OK", response.body().getIdSessionConnexion());
                            MyApplication.setUtilisateur(response.body());
                            startActivity(new Intent(view.getContext(), MySpaceActivity.class));
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<UserBean> call, Throwable t) {
                        Log.w("erreurLogin", t + "");
                        Toast.makeText(LoginActivity.this, R.string.une_erreur_mail_ou_mdp, Toast.LENGTH_LONG).show();
                    }
                });
            } else {
                Toast.makeText(this, R.string.mdp_6caracteres_minimum, Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, R.string.format_identifiant_non_conforme, Toast.LENGTH_LONG).show();
        }
    }
}
