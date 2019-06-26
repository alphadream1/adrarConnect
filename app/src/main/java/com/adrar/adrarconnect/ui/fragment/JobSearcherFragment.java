package com.adrar.adrarconnect.ui.fragment;

//
// Created by FERRARIS Philippe on 13/06/2019 for adrarConnect.
//

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.adrar.adrarconnect.R;
import com.adrar.adrarconnect.data.sample.SampleConstanteHtml;


public class JobSearcherFragment extends Fragment {

    private TextView tvDescription;
    private Button btSinscrireProcessus;

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

        WebView webView = v.findViewById(R.id.webViewDemandeurEmploi);
        webView.loadData(SampleConstanteHtml.DEMANDEUR_EMPLOI_HTML, "text/html", "UTF-8");
//        btSinscrireProcessus = v.findViewById(R.id.btSinscrier);
//        btSinscrireProcessus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getActivity(), SinscrireActivity.class));
//            }
//        });

        return v;
    }


}
