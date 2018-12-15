package com.example.prikster.acomodacaojava;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.prikster.acomodacaojava.model.Acomodacao;

import java.util.List;

public class AcomodacaoAdapter extends ArrayAdapter<Acomodacao> {
    private Context context;
    private List<Acomodacao> acomodacoes;

    public AcomodacaoAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Acomodacao> objects) {
        super(context, resource, objects);
        this.context = context;
        this.acomodacoes = objects;
    }

    @Override
    public View getView(final int pos, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_acomodacao, parent, false);

        TextView txtAcomodacaoTitulo = (TextView) rowView.findViewById(R.id.txtAcomodacaoTituloList);
        TextView txtAcomodacaoCapacidade = (TextView) rowView.findViewById(R.id.txtAcomodacaoCapacidadeList);
        TextView txtAcomodacaoPreco = (TextView) rowView.findViewById(R.id.txtAcomodacaoPrecoList);

        txtAcomodacaoTitulo.setText(String.format("%s", acomodacoes.get(pos).getTitulo()));
        txtAcomodacaoCapacidade.setText(String.format("%s", acomodacoes.get(pos).getCapacidade()));
        txtAcomodacaoPreco.setText(String.format("%s", acomodacoes.get(pos).getPreco()));

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start Activity User Form
                Intent intent = new Intent(context, AcomodacaoActivity.class);
                intent.putExtra("acomodacao_id", String.valueOf(acomodacoes.get(pos).getId()));
                context.startActivity(intent);
            }
        });

        return rowView;
    }
}
