package com.adrar.adrarconnect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.adrar.adrarconnect.data.sample.SampleConstanteHtml;

public class DescriptionFormationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_formation);
        WebView myWebView = findViewById(R.id.webViewFormation);
        myWebView.loadData(SampleConstanteHtml.FORMATION_HTML, "text/html", "UTF-8");
    }
}
