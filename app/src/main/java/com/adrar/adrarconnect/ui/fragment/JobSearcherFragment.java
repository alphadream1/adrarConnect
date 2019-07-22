package com.adrar.adrarconnect.ui.fragment;

//
// Created by FERRARIS Philippe on 13/06/2019 for adrarConnect.
//

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.adrar.adrarconnect.R;
import com.adrar.adrarconnect.SigninActivity;
import com.adrar.adrarconnect.data.utils.MyApplication;


public class JobSearcherFragment extends Fragment {

    public JobSearcherFragment() {
        // Required empty public constructor
    }

    public static JobSearcherFragment newInstance() {
        JobSearcherFragment fragment = new JobSearcherFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_jobsearcher, container, false);

        // les findViewById :
        WebView webViewDemandeurEmploi = v.findViewById(R.id.webViewDemandeurEmploi);
        Button btSinscrireProcessus = v.findViewById(R.id.btSinscrireProcessus);

        // reglage de la webview
        webViewDemandeurEmploi.setWebViewClient(new WebViewClient());
        webViewDemandeurEmploi.getSettings().setJavaScriptEnabled(true);

        // on met l'html dans la webview
        webViewDemandeurEmploi.loadData(MyApplication.getAccueilData().getProcessusInscription().getDemandeurEmploi_html(), "text/html", "UTF-8");
        Log.w("testHtml", MyApplication.getAccueilData().getProcessusInscription().getDemandeurEmploi_html());

        if (MyApplication.utilisateur != null) {
            btSinscrireProcessus.setVisibility(View.GONE);
        }

        // on créer le listener pour le bouton.
        btSinscrireProcessus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SigninActivity.class));
            }
        });

        return v;
    }


}
