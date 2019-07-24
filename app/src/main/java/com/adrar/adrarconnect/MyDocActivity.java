package com.adrar.adrarconnect;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.adrar.adrarconnect.data.model.DocumentsBean;
import com.adrar.adrarconnect.data.model.UserBean;
import com.adrar.adrarconnect.data.staticData.Constants;
import com.adrar.adrarconnect.utils.MyApplication;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyDocActivity extends AppCompatActivity {


    private ImageView ivChechCV;
    private ImageView ivCheckLM;
    private ImageView ivChechPPE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_doc);

        ivChechCV = findViewById(R.id.ivChechCV);
        ivCheckLM = findViewById(R.id.ivCheckLM);
        ivChechPPE = findViewById(R.id.ivChechPPE);

        if (MyApplication.getUtilisateur().getDocuments() != null) {
            if (userHaveCV(MyApplication.getUtilisateur())) {
                ivChechCV.setVisibility(View.VISIBLE);
            }
            if (userHavePPE(MyApplication.getUtilisateur())) {
                ivChechPPE.setVisibility(View.VISIBLE);
            }
            if (userHaveLM(MyApplication.getUtilisateur())) {
                ivCheckLM.setVisibility(View.VISIBLE);
            }
        }
    }

    public void onClickAjouterCV(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, Constants.DOC_TYPE_CV);
    }

    public void onClickAjouterLM(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, Constants.DOC_TYPE_LETTRE_MOTIVATION);
    }

    public void onClickAjouterPPE(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, Constants.DOC_TYPE_PRESCRIPTION_PE);
    }

    public void onClickValiderAnnulerDoc(View view) {
        startActivity(new Intent(this, MySpaceActivity.class));
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = null;
        if (resultCode == RESULT_OK) {
            Uri targetUri = data.getData();
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            // encoder l'image en base64
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, baos);
            byte[] b = baos.toByteArray();
            final String encodedImage = Base64.encodeToString(b, Base64.DEFAULT);
            // nouveau documentbean
            DocumentsBean doc = new DocumentsBean();
            // set des attributs du document
            doc.setBase64(encodedImage);
            doc.setEtat(Constants.DOC_ENVOYER);
            doc.setId_users(MyApplication.getUtilisateur().getId());
            //set du type de doc suivant le bouton clicker et affichage du doc_check si ok
            switch (requestCode) {
                case Constants.DOC_TYPE_PRESCRIPTION_PE:
                    doc.setId_typeDocument(Constants.DOC_TYPE_PRESCRIPTION_PE);
                    ivChechPPE.setVisibility(View.VISIBLE);
                    break;
                case Constants.DOC_TYPE_CV:
                    doc.setId_typeDocument(Constants.DOC_TYPE_CV);
                    ivChechCV.setVisibility(View.VISIBLE);
                    break;
                case Constants.DOC_TYPE_LETTRE_MOTIVATION:
                    doc.setId_typeDocument(Constants.DOC_TYPE_LETTRE_MOTIVATION);
                    ivCheckLM.setVisibility(View.VISIBLE);
                    break;
            }

            // post du document
            MyApplication.webServices.postUserDocument(doc).enqueue(new Callback<UserBean>() {
                @Override
                public void onResponse(Call<UserBean> call, Response<UserBean> response) {
                    // code a mettre quand le serveur seras ok
                    MyApplication.setUtilisateur(response.body());
                    Log.w("youhou doc envoyer", encodedImage.length() + "");
                }

                @Override
                public void onFailure(Call<UserBean> call, Throwable t) {
                    Log.w("erreur envoie photo", t + "");
                }
            });
        }
    }

    public Boolean userHaveCV(UserBean user) {
        for (DocumentsBean doc : user.getDocuments()
        ) {
            if (doc.getId_typeDocument() == Constants.DOC_TYPE_CV) {
                return true;
            }
        }
        return false;
    }

    public Boolean userHavePPE(UserBean user) {
        for (DocumentsBean doc : user.getDocuments()
        ) {
            if (doc.getId_typeDocument() == Constants.DOC_TYPE_PRESCRIPTION_PE) {
                return true;
            }
        }
        return false;
    }

    public Boolean userHaveLM(UserBean user) {
        for (DocumentsBean doc : user.getDocuments()
        ) {
            if (doc.getId_typeDocument() == Constants.DOC_TYPE_LETTRE_MOTIVATION) {
                return true;
            }
        }
        return false;
    }
}
