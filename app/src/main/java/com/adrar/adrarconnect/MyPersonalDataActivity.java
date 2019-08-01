package com.adrar.adrarconnect;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.adrar.adrarconnect.data.model.DocumentsBean;
import com.adrar.adrarconnect.data.model.UpdateUserBean;
import com.adrar.adrarconnect.data.model.UserBean;
import com.adrar.adrarconnect.data.staticData.Constants;
import com.adrar.adrarconnect.utils.MyApplication;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPersonalDataActivity extends AppCompatActivity {

    private ImageView ivPhoto;
    private EditText etNom;
    private EditText etPrenom;
    private EditText etTelephone;
    private EditText etNumPE;
    private EditText etNumVoie;
    private EditText etAdresse;
    private EditText etComplementAdresse;
    private EditText etCodePostal;
    private EditText etVille;
    private CheckBox cbDeveloppement;
    private CheckBox cbReseaux;
    private EditText etDateDeNaissance;
    private TextView tvEmail;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_personal_data);

        // les findViewById
        ivPhoto = findViewById(R.id.ivPhoto);
        etNom = findViewById(R.id.etNom);
        etPrenom = findViewById(R.id.etPrenom);
        tvEmail = findViewById(R.id.tvEmail);
        etDateDeNaissance = findViewById(R.id.etDateDeNaissance);
        etTelephone = findViewById(R.id.etTelephone);
        etNumPE = findViewById(R.id.etNumPE);
        etNumVoie = findViewById(R.id.etNumVoie);
        etAdresse = findViewById(R.id.etAdresse);
        etComplementAdresse = findViewById(R.id.etComplementAdresse);
        etCodePostal = findViewById(R.id.etCodePostal);
        etVille = findViewById(R.id.etVille);
        cbDeveloppement = findViewById(R.id.cbDeveloppement);
        cbReseaux = findViewById(R.id.cbReseaux);

        // set des info de base
        etNom.setText(MyApplication.getUtilisateur().getNom());
        etPrenom.setText(MyApplication.getUtilisateur().getPrenom());
        tvEmail.setText(MyApplication.getUtilisateur().getEmail());

        // set des autres info sous conditions
        if (MyApplication.getUtilisateur().getDdn() != null) {
            etDateDeNaissance.setText(Constants.SDF_JJ_MM_AAAA.format(MyApplication.getUtilisateur().getDdn()));
        } else {
            etDateDeNaissance.setHint(R.string.format_ddn);
        }
        //---------------------------------------------------------------------------------------------------------------------------------------------------
        // test du focus

        //---------------------------------------------------------------------------------------------------------------------------------------------------
        if (MyApplication.getUtilisateur().getTelephone() != null) {
            etTelephone.setText(MyApplication.getUtilisateur().getTelephone());
        }
        if (MyApplication.getUtilisateur().getNumeroPe() != null) {
            etNumPE.setText(MyApplication.getUtilisateur().getNumeroPe());
        }
        if (MyApplication.getUtilisateur().getNumeroVoie() != null) {
            etNumVoie.setText(MyApplication.getUtilisateur().getNumeroVoie());
        }
        if (MyApplication.getUtilisateur().getAdresse() != null) {
            etAdresse.setText(MyApplication.getUtilisateur().getAdresse());
        }
        if (MyApplication.getUtilisateur().getComplementAdresse() != null) {
            etComplementAdresse.setText(MyApplication.getUtilisateur().getComplementAdresse());
        }
        if (MyApplication.getUtilisateur().getCp() != null) {
            etCodePostal.setText(MyApplication.getUtilisateur().getCp());
        }
        if (MyApplication.getUtilisateur().getVille() != null) {
            etVille.setText(MyApplication.getUtilisateur().getVille());
        }
        if (MyApplication.getUtilisateur().getDev() == Constants.BOOLEEN_TRUE) {
            cbDeveloppement.setChecked(true);
        }
        if (MyApplication.getUtilisateur().getReseau() == Constants.BOOLEEN_TRUE) {
            cbReseaux.setChecked(true);
        }

        if (userPhotoPresente(MyApplication.getUtilisateur()) != null) {
            ivPhoto.setImageBitmap(BitmapFactory.decodeByteArray(
                    userPhotoPresente(MyApplication.getUtilisateur()), 0, Objects.requireNonNull(userPhotoPresente(MyApplication.getUtilisateur())).length));
        }
    }


    public void onClickValiderInfoPerso(View view) {
        UpdateUserBean user = new UpdateUserBean();
        user.setIdSessionConnexion(MyApplication.getUtilisateur().getIdSessionConnexion());
        user.setID_avancementInscription(MyApplication.getUtilisateur().getID_avancementInscription());
        if (!MyApplication.getUtilisateur().getNom().equals(etNom.getText().toString()) && !etNom.getText().toString().equals("")) {
            user.setNom(etNom.getText().toString());
        }
        if (!MyApplication.getUtilisateur().getPrenom().equals(etPrenom.getText().toString()) && !etPrenom.getText().toString().equals("")) {
            user.setPrenom(etPrenom.getText().toString());
        }

        if (!etDateDeNaissance.getText().toString().equals("")) {
            try {
                Date d = Constants.SDF_JJ_MM_AAAA.parse(etDateDeNaissance.getText().toString());
                user.setDdn(d.getTime());
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }
        }
        if (!etTelephone.getText().toString().equals("")) {
            user.setTelephone(etTelephone.getText().toString());
        }
        if (!etNumPE.getText().toString().equals("")) {
            user.setNumeroPe(etNumPE.getText().toString());
        }
        if (!etNumVoie.getText().toString().equals("")) {
            user.setNumeroVoie(etNumVoie.getText().toString());
        }
        if (!etAdresse.getText().toString().equals("")) {
            user.setAdresse(etAdresse.getText().toString());
        }
        if (!etComplementAdresse.getText().toString().equals("") || !etComplementAdresse.getText().toString().equals(MyApplication.getUtilisateur().getComplementAdresse())) {
            user.setComplementAdresse(etComplementAdresse.getText().toString());
        }
        if (!etCodePostal.getText().toString().equals("")) {
            user.setCp(etCodePostal.getText().toString());
        }
        if (!etVille.getText().toString().equals("")) {
            user.setVille(etVille.getText().toString());
        }
        if (cbDeveloppement.isChecked()) {
            user.setDev(Constants.BOOLEEN_TRUE);
        }
        if (cbReseaux.isChecked()) {
            user.setReseau(Constants.BOOLEEN_TRUE);
        }
        if (!etTelephone.getText().toString().trim().equals("") && !etNumPE.getText().toString().trim().equals("")) {
            MyApplication.webServices.postUserUpdateDetails(user).enqueue(new Callback<UserBean>() {
                @Override
                public void onResponse(Call<UserBean> call, Response<UserBean> response) {
                    if (response.body() != null) {
                        MyApplication.setUtilisateur(response.body());
                        startActivity(new Intent(etNom.getContext(), MySpaceActivity.class));
                        finish();
                    }
                }

                @Override
                public void onFailure(Call<UserBean> call, Throwable t) {
                    Log.w("Err_Update", t + "");
                    Toast.makeText(MyPersonalDataActivity.this, R.string.une_erreur_c_produite, Toast.LENGTH_LONG).show();
                }
            });
        } else {
            Toast.makeText(this, R.string.vous_devez_au_minimum_remplir_etc, Toast.LENGTH_LONG).show();
        }
    }

    public void onClickAnnulerInfoPerso(View view) {
        finish();
    }

    public void onClickAjouterPhoto(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, Constants.DOC_TYPE_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = null;
        if (resultCode == RESULT_OK && requestCode == Constants.DOC_TYPE_PHOTO) {
            Uri targetUri = data.getData();
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                ivPhoto.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            // encoder l'image en base64
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 25, baos);
            byte[] b = baos.toByteArray();
            final String encodedImage = Base64.encodeToString(b, Base64.DEFAULT);
            // nouveau documentbean
            DocumentsBean photo = new DocumentsBean();
            photo.setBase64(encodedImage);
            photo.setEtat(Constants.DOC_ENVOYER);
            photo.setId_typeDocument(Constants.DOC_TYPE_PHOTO);
            photo.setId_users(MyApplication.getUtilisateur().getId());
            // post de la photo
            MyApplication.webServices.postUserDocument(photo).enqueue(new Callback<UserBean>() {
                @Override
                public void onResponse(Call<UserBean> call, Response<UserBean> response) {
                    MyApplication.setUtilisateur(response.body());
                    Log.w("youhou", encodedImage.length() + "");
                }

                @Override
                public void onFailure(Call<UserBean> call, Throwable t) {
                    Log.w("erreur envoie photo", t + "");
                }
            });
        }
    }

    private byte[] userPhotoPresente(UserBean user) {
        if (user.getDocuments() != null) {
            for (DocumentsBean doc : user.getDocuments()
            ) {
                if (doc.getId_typeDocument() == Constants.DOC_TYPE_PHOTO) {
                    return Base64.decode(doc.getBase64().getBytes(), 0);
                }
            }
            return null;
        } else {
            return null;
        }
    }

}
