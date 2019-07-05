package com.adrar.adrarconnect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.adrar.adrarconnect.data.model.FormationBean;

public class DescriptionFormationActivity extends AppCompatActivity {

    private FormationBean data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_formation);
        //la webview
        WebView myWebView = findViewById(R.id.webViewFormation);
        //récuperation des données
        data = (FormationBean) getIntent().getSerializableExtra("formation");

        // affichage des données
        // html dans la webview
        myWebView.loadData(data.getHtml(), "text/html", "UTF-8");
        // set du title pour afficher le nom de la formation
        setTitle(data.getIntitule());
    }
}
