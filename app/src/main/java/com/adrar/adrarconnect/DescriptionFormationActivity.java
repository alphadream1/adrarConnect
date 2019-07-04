package com.adrar.adrarconnect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;

import java.util.Objects;

public class DescriptionFormationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_formation);
        WebView myWebView = findViewById(R.id.webViewFormation);
        myWebView.loadData(Objects.requireNonNull(getIntent().getExtras()).getString("description"), "text/html", "UTF-8");
        setTitle(getIntent().getStringExtra("intitule"));
        Log.w("test", getIntent().getStringExtra("intitule"));
    }
}
