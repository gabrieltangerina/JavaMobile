package com.example.recyclerview.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.activity.model.Filme;

import java.util.List;


public class Adapter extends RecyclerView.Adapter {

    private List<Filme> listaFilmes;
    public Adapter(List<Filme> lista) {
        this.listaFilmes = lista;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_listar, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // O onBindViewHolder vai ser chamado a qtnd de vezes q estiver no getItemCount

        MyViewHolder myViewHolder = (MyViewHolder) holder;

        Filme filme = listaFilmes.get(position);
        ((MyViewHolder) holder).titutlo.setText(filme.getTituloFilme());
        ((MyViewHolder) holder).genero.setText(filme.getGenero());
        ((MyViewHolder) holder).ano.setText(filme.getAno());

    }

    @Override
    public int getItemCount() {
        return listaFilmes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titutlo;
        TextView ano;
        TextView genero;

        public MyViewHolder(View itemView){
            super(itemView);

            titutlo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);
        }
    }

}
