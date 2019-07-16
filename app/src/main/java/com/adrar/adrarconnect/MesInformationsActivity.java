package com.adrar.adrarconnect;

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

import com.adrar.adrarconnect.data.model.DocumentsBean;
import com.adrar.adrarconnect.data.model.UserBean;
import com.adrar.adrarconnect.data.utils.Constants;
import com.adrar.adrarconnect.data.utils.MyApplication;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MesInformationsActivity extends AppCompatActivity {

    private ImageView ivPhoto;
    private EditText etNom;
    private EditText etPrenom;
    private TextView tvEmail;
    private EditText etDateDeNaissance;
    private EditText etTelephone;
    private EditText etNumPE;
    private EditText etNumVoie;
    private EditText etAdresse;
    private EditText etComplementAdresse;
    private EditText etCodePostal;
    private EditText etVille;
    private CheckBox cbDeveloppement;
    private CheckBox cbReseaux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes_informations);

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
        etNom.setText(MyApplication.utilisateur.getNom());
        etPrenom.setText(MyApplication.utilisateur.getPrenom());
        tvEmail.setText(MyApplication.utilisateur.getEmail());

        // set des autres info sous conditions
        if (MyApplication.utilisateur.getDdn() != null) {
            etDateDeNaissance.setText(MyApplication.utilisateur.getDdn().toString());
        }
        if (MyApplication.utilisateur.getTelephone() != null) {
            etTelephone.setText(MyApplication.utilisateur.getTelephone());
        }
        if (MyApplication.utilisateur.getNumeroPe() != null) {
            etNumPE.setText(MyApplication.utilisateur.getNumeroPe());
        }
        if (MyApplication.utilisateur.getNumeroVoie() != null) {
            etNumVoie.setText(MyApplication.utilisateur.getNumeroVoie());
        }
        if (MyApplication.utilisateur.getAdresse() != null) {
            etAdresse.setText(MyApplication.utilisateur.getAdresse());
        }
        if (MyApplication.utilisateur.getComplementAdresse() != null) {
            etComplementAdresse.setText(MyApplication.utilisateur.getComplementAdresse());
        }
        if (MyApplication.utilisateur.getCp() != null) {
            etCodePostal.setText(MyApplication.utilisateur.getCp());
        }
        if (MyApplication.utilisateur.getVille() != null) {
            etVille.setText(MyApplication.utilisateur.getVille());
        }
        if (MyApplication.utilisateur.getDev() == Constants.BOOLEEN_TRUE) {
            cbDeveloppement.setChecked(true);
        }
        if (MyApplication.utilisateur.getReseau() == Constants.BOOLEEN_TRUE) {
            cbReseaux.setChecked(true);
        }

        //userPhotoPresente();
        //----------------
        // test decode base64
        //----------------
//        byte[] imageAsBytes = Base64.decode(Constants.BASE64.getBytes(), 0);
//        ivPhoto.setImageBitmap(BitmapFactory.decodeByteArray(
//                imageAsBytes, 0, imageAsBytes.length));

    }

    public void onClickValiderInfoPerso(View view) {
        UserBean user = new UserBean();
        user.setIdSessionConnexion(MyApplication.getUtilisateur().getIdSessionConnexion());
        user.setId(MyApplication.getUtilisateur().getId());
        if (!MyApplication.getUtilisateur().getNom().equals(etNom.getText().toString()) && !etNom.getText().toString().equals("")) {
            user.setNom(etNom.getText().toString());
        }
        if (!MyApplication.getUtilisateur().getPrenom().equals(etPrenom.getText().toString()) && !etPrenom.getText().toString().equals("")) {
            user.setPrenom(etPrenom.getText().toString());
        }
        //todo finir ce if
        if (!etDateDeNaissance.getText().toString().equals("") || etDateDeNaissance.getText().toString().equals(Constants.SDF_JJ_MM_AAAA)) {

            //user.setDdn(Constants.SDF_JJ_MM_AAAA.format());
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
        if (!user.getNumeroPe().equals("") && !user.getTelephone().equals("")) {
            user.setID_avancementInscription(Constants.AVANCEMENT_INSCRIPTION_DOC);
        }
        MyApplication.webServices.postUserUpdateDetails(user).enqueue(new Callback<UserBean>() {
            @Override
            public void onResponse(Call<UserBean> call, Response<UserBean> response) {
                MyApplication.setUtilisateur(response.body());
            }

            @Override
            public void onFailure(Call<UserBean> call, Throwable t) {
                Log.w("Err_Update", t + "");
            }
        });
        startActivity(new Intent(this, EspacePersoActivity.class));
        finish();
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
            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, baos);
            byte[] b = baos.toByteArray();
            final String encodedImage = Base64.encodeToString(b, Base64.DEFAULT);
            // nouveau documentbean
            DocumentsBean photo = new DocumentsBean();
            photo.setBase64(encodedImage);
            photo.setIdSessionConnexion(MyApplication.getUtilisateur().getIdSessionConnexion());
            photo.setEtat(Constants.DOC_ENVOYER);
            photo.setId_typeDocument(Constants.DOC_TYPE_PHOTO);
            photo.setId_users(MyApplication.getUtilisateur().getId());
            // todo faire le post doc(photo) ici
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

    public void userPhotoPresente() {
        if (MyApplication.utilisateur.getListDocument() != null) {
            for (DocumentsBean doc : MyApplication.utilisateur.getListDocument()
            ) {
                if (doc.getId_typeDocument() == Constants.DOC_TYPE_PHOTO) {
                    byte[] imageAsBytes = Base64.decode(doc.getBase64().getBytes(), 0);
                    ivPhoto.setImageBitmap(BitmapFactory.decodeByteArray(
                            imageAsBytes, 0, imageAsBytes.length));

                }
            }
        }
    }
}
