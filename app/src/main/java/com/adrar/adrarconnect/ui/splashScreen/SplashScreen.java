package com.adrar.adrarconnect.ui.splashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.adrar.adrarconnect.MainActivity;
import com.adrar.adrarconnect.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // rediriger vers page principale "MainActivity" après 3 secondes.
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        };

        // handler post delayed
        new Handler().postDelayed(runnable, 2000);
    }
}
