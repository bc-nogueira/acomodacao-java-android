package com.example.prikster.acomodacaojava;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAcomodacaoAdapter extends ArrayAdapter<String> {
    private Context context;
    private List<String> urls;

    public ImageAcomodacaoAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        this.context = context;
        this.urls = objects;
    }

    @Override
    public View getView(final int pos, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.image_acomodacao, parent, false);

        ImageView imgAcomodacao = (ImageView) rowView.findViewById(R.id.imgAcomodacao);
        Picasso.get().load(urls.get(pos)).into(imgAcomodacao);

        return rowView;
    }
}
