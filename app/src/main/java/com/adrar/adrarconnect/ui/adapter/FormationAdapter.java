package com.adrar.adrarconnect.ui.adapter;

//
// Created by FERRARIS Philippe on 13/06/2019 for adrarConnect.
//

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.adrar.adrarconnect.DescriptionFormationActivity;
import com.adrar.adrarconnect.R;
import com.adrar.adrarconnect.data.model.FormationBean;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class FormationAdapter extends RecyclerView.Adapter<FormationAdapter.ViewHolder> {

    //---------------
    // données
    //---------------
    private ArrayList<FormationBean> data;

    //---------------
    //
    //---------------
    public FormationAdapter(ArrayList<FormationBean> dataFormationBean) {
        this.data = dataFormationBean;
    }

    //---------------
    // class interne
    //---------------
    protected static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivLogoFormation;
        TextView tvIntituleFormation;
        View tvTransparent;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivLogoFormation = itemView.findViewById(R.id.ivLogoFormation);
            tvIntituleFormation = itemView.findViewById(R.id.tvIntituleFormation);
            tvTransparent = itemView.findViewById(R.id.root);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.plugin_formation, viewGroup, false);
        return new FormationAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final FormationBean datum = data.get(i);
        // set du texte avec l'intitulé de la formation
        viewHolder.tvIntituleFormation.setText(datum.getIntitule());
        // todo penser au set de l'image suivant les intitulés des formations( penser a la rajouter a la doc du web service)


        viewHolder.tvTransparent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(viewHolder.ivLogoFormation.getContext(), "clic", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(viewHolder.tvTransparent.getContext(), DescriptionFormationActivity.class);
                intent.putExtra("description", datum.getHtml());
                intent.putExtra("intitule", datum.getIntitule());
                viewHolder.tvTransparent.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private class DownLoadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

        public DownLoadImageTask(ImageView imageView) {
            this.imageView = imageView;
        }

        /*
            doInBackground(Params... params)
                Override this method to perform a computation on a background thread.
         */
        protected Bitmap doInBackground(String... urls) {
            String urlOfImage = urls[0];
            Bitmap logo = null;
            try {
                InputStream is = new URL(urlOfImage).openStream();
                /*
                    decodeStream(InputStream is)
                        Decode an input stream into a bitmap.
                 */
                logo = BitmapFactory.decodeStream(is);
            } catch (Exception e) { // Catch the download exception
                e.printStackTrace();
            }
            return logo;
        }

        /*
            onPostExecute(Result result)
                Runs on the UI thread after doInBackground(Params...).
         */
        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
    }
}
