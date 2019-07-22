package com.adrar.adrarconnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.adrar.adrarconnect.data.model.DocumentsBean;
import com.adrar.adrarconnect.data.utils.Constants;
import com.adrar.adrarconnect.data.utils.MyApplication;

import java.util.ArrayList;

public class InformationCollectiveActivity extends AppCompatActivity {


    //----------------
    // méthode
    //----------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_collective);

        // instanciation des composants
        //----------------
        // composant de la vue
        //----------------
        WebView wvInfoco = findViewById(R.id.wvInfoco);
        TextView tvMsgErreur = findViewById(R.id.tvMsgErreur);
        Button btSinscrireInfoCo = findViewById(R.id.btSinscrireInfoCo);


        //----------------
        // affichage des données
        //----------------
        wvInfoco.loadData(MyApplication.getAccueilData().getInfosCollectives_html(), "text/html", "utf-8");


    }

    public void onClickSinscrireInformationCollective(View view) {
//        // on prepare la nouvelle activité
//        Intent choixInfocoIntent = new Intent(this, ChoixInfoCoActivity.class);
//        // on lance l'Activité
//        startActivity(choixInfocoIntent);
        // condition d'accés aux infoco
        if (MyApplication.getUtilisateur().getDocuments() == null || retourneLeBonDocument(MyApplication.getUtilisateur().getDocuments(), Constants.DOC_TYPE_CV) == null && retourneLeBonDocument(MyApplication.getUtilisateur().getDocuments(), Constants.DOC_TYPE_PRESCRIPTION_PE) == null) {
            Toast.makeText(this, "Vous devez enregistrer vos documents dans votre espace personnel pour accéder a cette section", Toast.LENGTH_LONG).show();
        } else {
            if (retourneLeBonDocument(MyApplication.getUtilisateur().getDocuments(), Constants.DOC_TYPE_CV).getEtat() == Constants.DOC_VALIDER && retourneLeBonDocument(MyApplication.getUtilisateur().getDocuments(), Constants.DOC_TYPE_PRESCRIPTION_PE).getEtat() == Constants.DOC_VALIDER) {
                // on prepare la nouvelle activité
                Intent choixInfocoIntent = new Intent(this, ChoixInfoCoActivity.class);
                // on lance l'Activité
                startActivity(choixInfocoIntent);
            } else {
                Toast.makeText(this, "Vous n'avez pas accés a cette section tant que votre dossier n'est pas validé.", Toast.LENGTH_LONG).show();
            }
        }
    }

    public DocumentsBean retourneLeBonDocument(ArrayList<DocumentsBean> list, int typeDeDocument) {
        for (DocumentsBean doc : list
        ) {
            if (doc.getId_typeDocument() == typeDeDocument) {
                return doc;
            }
        }
        return null;
    }
}
