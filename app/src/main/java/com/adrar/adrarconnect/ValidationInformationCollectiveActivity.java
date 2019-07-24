package com.adrar.adrarconnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.adrar.adrarconnect.data.model.InfoCollectiveBean;
import com.adrar.adrarconnect.data.model.InfocoUserBean;
import com.adrar.adrarconnect.data.model.UserBean;
import com.adrar.adrarconnect.data.staticData.Constants;
import com.adrar.adrarconnect.utils.MyApplication;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ValidationInformationCollectiveActivity extends AppCompatActivity {

    private static InfoCollectiveBean data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation_information_collective);
        data = (InfoCollectiveBean) getIntent().getSerializableExtra("infoco");


        TextView tvDateInfoco = findViewById(R.id.tvDateInfoCol);
        TextView tvVilleInfoco = findViewById(R.id.tvVilleInfoCol);
        TextView tvDateInfoCol2 = findViewById(R.id.tvDateInfoCol2);
        TextView tvVilleInfoCol2 = findViewById(R.id.tvVilleInfoCol2);
        TextView tvInscrit = findViewById(R.id.tvInscrit);
        TextView tvComplet = findViewById(R.id.tvComplet);
        TextView tvAnnuler = findViewById(R.id.tvAnnulerDoc);
        TextView tvValider = findViewById(R.id.tvValiderDoc);
        TextView tvInscriptionRemplacement = findViewById(R.id.tvInscriptionRemplacement);
        TextView tvInscrit2 = findViewById(R.id.tvInscrit2);
        TextView tvComplet2 = findViewById(R.id.tvComplet2);
        TextView tvInscriptionValide = findViewById(R.id.tvInscriptionValide);
        CardView cardView = findViewById(R.id.cardView);

        if (data.getId() == MyApplication.getUtilisateur().getID_infoCollective()) {
            tvInscriptionRemplacement.setText("vous souhaitez vous désinscrire de cette information collective : ");
            tvDateInfoCol2.setText(Constants.SDF_ALL.format(data.getDate()));
            tvVilleInfoCol2.setText(data.getCentreDeFormation().getVille());
        } else {
            if (MyApplication.getUtilisateur().getID_infoCollective() > 0) {
                tvInscriptionValide.setVisibility(View.VISIBLE);
                tvInscriptionValide.setText(R.string.vous_tes_inscrit_a_cette_information_collective);
                cardView.setVisibility(View.VISIBLE);
                tvInscrit.setVisibility(View.VISIBLE);
                tvDateInfoco.setText(Constants.SDF_ALL.format(MyApplication.getAccueilData().getListeInfosCollectives().get(MyApplication.getUtilisateur().getID_infoCollective() - 1).getDate()));
                tvVilleInfoco.setText(MyApplication.getAccueilData().getListeInfosCollectives().get(MyApplication.getUtilisateur().getID_infoCollective() - 1).getCentreDeFormation().getVille());
                tvInscriptionRemplacement.setText("la remplacer par celle-ci?");
                tvVilleInfoCol2.setText(data.getCentreDeFormation().getVille());
                tvDateInfoCol2.setText(Constants.SDF_ALL.format(data.getDate()));
            } else {
                tvVilleInfoCol2.setText(data.getCentreDeFormation().getVille());
                tvDateInfoCol2.setText(Constants.SDF_ALL.format(data.getDate()));
            }
        }
    }

    public void onClickValiderInfoCo(final View view) {
        InfocoUserBean user = new InfocoUserBean();
        user.setIdSessionConnexion(MyApplication.getUtilisateur().getIdSessionConnexion());
        user.setID_infoCollective(data.getId());

        if (data.getId() == MyApplication.getUtilisateur().getID_infoCollective()) {
            MyApplication.webServices.postUserDeleteInfoco(user).enqueue(new Callback<UserBean>() {
                @Override
                public void onResponse(Call<UserBean> call, Response<UserBean> response) {
                    Log.w("SupInfoco", "infocoSupprimer");
                    MyApplication.setUtilisateur(response.body());
                    startActivity(new Intent(view.getContext(), MainActivity.class));
                    Toast.makeText(ValidationInformationCollectiveActivity.this, "Vous venez de vous désinscrire d'une information collective", Toast.LENGTH_LONG).show();
                    finish();
                }

                @Override
                public void onFailure(Call<UserBean> call, Throwable t) {
                    Log.w("SupInfoco", "infoco non supprimé" + t);
                }
            });
        } else {
            MyApplication.webServices.postUserInfoco(user).enqueue(new Callback<UserBean>() {
                @Override
                public void onResponse(Call<UserBean> call, Response<UserBean> response) {
                    Log.w("YesInfoco", "infocoEnvoyer");
                    MyApplication.setUtilisateur(response.body());
                    startActivity(new Intent(view.getContext(), MySpaceActivity.class));
                    finish();
                }

                @Override
                public void onFailure(Call<UserBean> call, Throwable t) {
                    Log.w("NonInfoco", "infoco non inscrite" + t);
                }
            });

            startActivity(new Intent(this, MySpaceActivity.class));
            Toast.makeText(this, "Vous venez de vous inscrire a une information collective", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    public void onClickAnnulerInfoCo(View view) {
        finish();
    }


}
