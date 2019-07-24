package com.adrar.adrarconnect;

//
// Created by FERRARIS Philippe on 13/06/2019 for adrarConnect.
//

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.adrar.adrarconnect.utils.MyApplication;

public class AdrarActivity extends AppCompatActivity {

    // private String adrar_html;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adrar);
        WebView myWebView = findViewById(R.id.webViewAdrar);

        myWebView.loadData(MyApplication.getAccueilData().getAdrar_html(), "text/html", "utf-8");
    }
}
