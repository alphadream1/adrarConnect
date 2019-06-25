package com.adrar.adrarconnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.adrar.adrarconnect.data.model.InfoCollectiveBean;

import java.util.ArrayList;
import java.util.Comparator;

public class InformationCollectiveActivity extends AppCompatActivity {

    private ArrayList<InfoCollectiveBean> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_collective);

        data = new ArrayList<>();

        data.sort(new Comparator<InfoCollectiveBean>() {
            @Override
            public int compare(InfoCollectiveBean o1, InfoCollectiveBean o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
    }

    public void onClickSinscrireInformationCollective(View view) {
        startActivity(new Intent(this, ChoixInformationCollectiveActivity.class));
    }
}
