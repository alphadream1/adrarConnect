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
import android.widget.TextView;

import com.adrar.adrarconnect.R;
import com.adrar.adrarconnect.data.sample.SampleConstanteHtml;


public class SalaryFragment extends Fragment {

    private TextView tvDescription;

    public SalaryFragment() {
        // Required empty public constructor
    }

    public static SalaryFragment newInstance() {
        SalaryFragment fragment = new SalaryFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_salary, container, false);

        WebView webView = v.findViewById(R.id.webViewSalary);
        webView.loadData(SampleConstanteHtml.SALARY_HTML, "text/html", "UTF-8");


        return v;
    }


}
