package com.example.teste.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teste.R;
import com.example.teste.model.Filmes;

import java.util.List;

public class AdapterFilmes extends RecyclerView.Adapter<AdapterFilmes.MyViewHolder> {

    private List<Filmes> listaFilmes;
    public AdapterFilmes(List<Filmes> listaFilmes) {
        this.listaFilmes = listaFilmes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Esse método cria a visualização

        // Parent é o componente em que o item de lista está dentro
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_filmes, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Esse método exibe os itens

        // o Objeto holder é o retorno da função onCreateViewHolder

        Filmes filmes = listaFilmes.get(position);

        holder.titulo.setText(filmes.getTituloFilme());
        holder.genero.setText(filmes.getGenero());
        holder.ano.setText(filmes.getAno());
    }

    @Override
    public int getItemCount() {
        // Retorna a quantidade de itens que serão exibidos

        return listaFilmes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
         TextView titulo;
         TextView ano;
         TextView genero;
         public MyViewHolder(@NonNull View itemView) {
             super(itemView);

             titulo = itemView.findViewById(R.id.textTitulo);
             ano = itemView.findViewById(R.id.textAno);
             genero = itemView.findViewById(R.id.textGenero);
         }
     }

}
