package com.adrar.adrarconnect.ui.fragment;

//
// Created by FERRARIS Philippe on 13/06/2019 for adrarConnect.
//

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.adrar.adrarconnect.R;
import com.adrar.adrarconnect.utils.MyApplication;


public class SalaryFragment extends Fragment {

    private final String SALARY_HTML = "<!DOCTYPE html>\n" +
            "<html lang=\"fr\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
            "    <title>SalarieBean</title>\n" +
            "    <style>\n" +
            "        body{\n" +
            "            font-family: Verdana, Geneva, Tahoma, sans-serif;\n" +
            "            padding: 0.4rem;\n" +
            "        }\n" +
            "        p {\n" +
            "            text-align: justify;\n" +
            "        }\n" +
            "    </style>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit.\n" +
            "    Quos dolorum illo voluptates dignissimos eos quod perferendis ipsam minus!\n" +
            "    Fugiat corrupti eius architecto magnam officiis aut quam obcaecati unde illo dolorum!</p>\n" +
            "    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit.\n" +
            "    Quos dolorum illo voluptates dignissimos eos quod perferendis ipsam minus!\n" +
            "    Fugiat corrupti eius architecto magnam officiis aut quam obcaecati unde illo dolorum!</p>\n" +
            "    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit.\n" +
            "    Quos dolorum illo voluptates dignissimos eos quod perferendis ipsam minus!\n" +
            "    Fugiat corrupti eius architecto magnam officiis aut quam obcaecati unde illo dolorum!</p>\n" +
            "    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit.\n" +
            "    Quos dolorum illo voluptates dignissimos eos quod perferendis ipsam minus!\n" +
            "    Fugiat corrupti eius architecto magnam officiis aut quam obcaecati unde illo dolorum!</p>\n" +
            "    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit.\n" +
            "    Quos dolorum illo voluptates dignissimos eos quod perferendis ipsam minus!\n" +
            "    Fugiat corrupti eius architecto magnam officiis aut quam obcaecati unde illo dolorum!</p>\n" +
            "    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit.\n" +
            "    Quos dolorum illo voluptates dignissimos eos quod perferendis ipsam minus!\n" +
            "    Fugiat corrupti eius architecto magnam officiis aut quam obcaecati unde illo dolorum!</p>\n" +
            "    \n" +
            "</body>\n" +
            "</html>";

    public SalaryFragment() {
        // Required empty public constructor
    }

    public static SalaryFragment newInstance() {
        return new SalaryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_salary, container, false);

        //----------------
        // attributs
        //----------------
        WebView webViewSalary = v.findViewById(R.id.webViewSalary);
        // reglage de la webview
        webViewSalary.setWebViewClient(new WebViewClient());
        webViewSalary.getSettings().setJavaScriptEnabled(true);

        webViewSalary.loadData(MyApplication.getAccueilData().getProcessusInscription().getSalarie_html(), "text/html", "UTF-8");
        Log.w("test", MyApplication.getAccueilData().getProcessusInscription().getSalarie_html());

        TextView tvTelephone = v.findViewById(R.id.tvTelephone);
        tvTelephone.setText(MyApplication.getAccueilData().getProcessusInscription().getTelephone());
        Log.w("testTelephone", MyApplication.getAccueilData().getProcessusInscription().getTelephone());

        TextView tvMail = v.findViewById(R.id.tvMail);
        tvMail.setText(MyApplication.getAccueilData().getProcessusInscription().getEmail());
        Log.w("testMail", MyApplication.getAccueilData().getProcessusInscription().getEmail());

        return v;
    }


}
