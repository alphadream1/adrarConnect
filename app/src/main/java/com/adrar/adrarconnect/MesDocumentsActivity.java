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
import com.adrar.adrarconnect.data.utils.Constants;
import com.adrar.adrarconnect.data.utils.MyApplication;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MesDocumentsActivity extends AppCompatActivity {


    private ImageView ivChechCV;
    private ImageView ivCheckLM;
    private ImageView ivChechPPE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes_documents);

        ivChechCV = findViewById(R.id.ivChechCV);
        ivCheckLM = findViewById(R.id.ivCheckLM);
        ivChechPPE = findViewById(R.id.ivChechPPE);
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
        startActivity(new Intent(this, EspacePersoActivity.class));
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
            doc.setBase64(encodedImage);
            doc.setIdSessionConnexion(MyApplication.getUtilisateur().getIdSessionConnexion());
            doc.setEtat(Constants.DOC_ENVOYER);

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

            doc.setId_users(MyApplication.getUtilisateur().getId());
            // post du document
            MyApplication.webServices.postUserDocument(doc).enqueue(new Callback<UserBean>() {
                @Override
                public void onResponse(Call<UserBean> call, Response<UserBean> response) {
                    // code a mettre quand le serveur seras ok
                    //MyApplication.setUtilisateur(response.body());
                    Log.w("youhou", encodedImage.length() + "");
                }

                @Override
                public void onFailure(Call<UserBean> call, Throwable t) {
                    Log.w("erreur envoie photo", t + "");
                }
            });
        }
    }
}
