package com.example.recyclerview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.activity.adapter.Adapter;
import com.example.recyclerview.activity.model.Filme;
import com.example.recyclerview.activity.ClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // Listagem de filmes
        this.criarFilmes();

        // Configurando adapter
        Adapter adapter = new Adapter( listaFilmes );

        // Configurando RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
            // Para criar o divisor entre os filmes
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        // Evento de click
        recyclerView.addOnItemTouchListener(
            new ClickListener(
                    getApplicationContext(),
                    recyclerView,
                    new ClickListener.OnItemClickListener(){
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        }

                        @Override
                        public void onItemClick(View view, int position){
                            Filme filme = listaFilmes.get(position);
                            Toast.makeText(getApplicationContext(), "Item pressionado: " + filme.getTituloFilme(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);
                            Toast.makeText(getApplicationContext(), "Click longo: " + filme.getTituloFilme(), Toast.LENGTH_SHORT).show();
                        }
                    }
            )
        );
    }

    public void criarFilmes(){

        Filme filme1 = new Filme("Cidadão Kane", "Drama", "1941");
        this.listaFilmes.add(filme1);

        Filme filme2 = new Filme("O Poderoso Chefão", "Crime, Drama", "1972");
        this.listaFilmes.add(filme2);

        Filme filme3 = new Filme("Pulp Fiction: Tempo de Violência", "Crime, Drama", "1994");
        this.listaFilmes.add(filme3);

        Filme filme4 = new Filme("O Senhor dos Anéis: O Retorno do Rei", "Aventura, Fantasia", "2003");
        this.listaFilmes.add(filme4);

        Filme filme5 = new Filme("A Lista de Schindler", "Biografia, Drama, História", "1993");
        this.listaFilmes.add(filme5);

        Filme filme6 = new Filme("O Silêncio dos Inocentes", "Crime, Drama, Thriller", "1991");
        this.listaFilmes.add(filme6);

        Filme filme7 = new Filme("Forrest Gump: O Contador de Histórias", "Drama, Romance", "1994");
        this.listaFilmes.add(filme7);

        Filme filme8 = new Filme("A Origem", "Ação, Aventura, Ficção Científica", "2010");
        this.listaFilmes.add(filme8);

        Filme filme9 = new Filme("Interestelar", "Aventura, Drama, Ficção Científica", "2014");
        this.listaFilmes.add(filme9);

        Filme filme10 = new Filme("Matrix", "Ação, Ficção Científica", "1999");
        this.listaFilmes.add(filme10);

        Filme filme11 = new Filme("O Labirinto do Fauno", "Drama, Fantasia, Guerra", "2006");
        this.listaFilmes.add(filme11);

        Filme filme12 = new Filme("A Viagem de Chihiro", "Animação, Aventura, Família", "2001");
        this.listaFilmes.add(filme12);

        Filme filme13 = new Filme("O Rei Leão", "Animação, Aventura, Drama", "1994");
        this.listaFilmes.add(filme13);

        Filme filme14 = new Filme("De Volta para o Futuro", "Aventura, Comédia, Ficção Científica", "1985");
        this.listaFilmes.add(filme14);

        Filme filme15 = new Filme("O Poderoso Chefão: Parte II", "Crime, Drama", "1974");
        this.listaFilmes.add(filme15);


    }

}