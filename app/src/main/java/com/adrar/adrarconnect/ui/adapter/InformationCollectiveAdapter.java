package com.adrar.adrarconnect.ui.adapter;

//
// Created by FERRARIS Philippe on 17/06/2019 for adrarConnect.
//

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.adrar.adrarconnect.R;
import com.adrar.adrarconnect.ValidationInformationCollectiveActivity;
import com.adrar.adrarconnect.data.model.InfoCollectiveBean;
import com.adrar.adrarconnect.data.utils.Constants;

import java.util.ArrayList;

public class InformationCollectiveAdapter extends RecyclerView.Adapter<InformationCollectiveAdapter.ViewHolder> {

    private ArrayList<InfoCollectiveBean> data;

    //---------------
    // Constructeur
    //---------------

    public InformationCollectiveAdapter(ArrayList<InfoCollectiveBean> data) {
        this.data = data;
    }

    // classe qui stock les données d'1 ligne
    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvVille, tvDate, tvInscrit, tvComplet;
        View root;

        ViewHolder(View itemView) {
            super(itemView);
            tvVille = itemView.findViewById(R.id.tvVilleInfoCol);
            tvDate = itemView.findViewById(R.id.tvDateInfoCol);
            root = itemView.findViewById(R.id.root);
            tvInscrit = itemView.findViewById(R.id.tvInscrit);
            tvComplet = itemView.findViewById(R.id.tvComplet);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.plugin_information_collective, viewGroup, false);
        return new InformationCollectiveAdapter.ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final InfoCollectiveBean datum = data.get(i);

        viewHolder.tvVille.setText(datum.getCentreDeFormation().getVille());
        viewHolder.tvDate.setText(Constants.SDF_ALL.format(datum.getDate()));

        // condition si l'infoco est complete
        if (datum.isComplet() == 1) {
            viewHolder.tvComplet.setVisibility(View.VISIBLE);
        }

        // todo finir le if juste en dessous pour afficher ou pas " vous etes inscrit a cette infoco"
//        if () {
//            viewHolder.tvInscrit.setVisibility(View.VISIBLE);
//        }


        viewHolder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (datum.isComplet() == 1) {
                    Toast.makeText(viewHolder.tvComplet.getContext(), "Vous ne pouvez vous inscrire à cette information collective car elle est complète", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(viewHolder.root.getContext(), ValidationInformationCollectiveActivity.class);
                    intent.putExtra("infoco", datum);
                    viewHolder.root.getContext().startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
