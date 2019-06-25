package com.adrar.adrarconnect.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adrar.adrarconnect.R;
import com.adrar.adrarconnect.data.model.FaqBean;

import java.util.ArrayList;

//
// Created by FERRARIS Philippe on 13/06/2019 for adrarConnect.
//

public class FaqAdapter extends RecyclerView.Adapter<FaqAdapter.ViewHolder> {

    private ArrayList<FaqBean> data;

    public FaqAdapter(ArrayList<FaqBean> data) {
        this.data = data;
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvQuestion, tvReponse;

        public ViewHolder(View itemView) {
            super(itemView);
            tvQuestion = itemView.findViewById(R.id.tvQuestion);
            tvReponse = itemView.findViewById(R.id.tvReponse);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.plugin_faq, viewGroup, false);
        return new FaqAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        FaqBean datum = data.get(i);
        viewHolder.tvQuestion.setText(datum.getQuestion());
        viewHolder.tvReponse.setText(datum.getReponse());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
