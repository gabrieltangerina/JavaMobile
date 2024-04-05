package com.example.teste.activity.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teste.R;
import com.example.teste.RecyclerItemClickListener;
import com.example.teste.adapter.AdapterFilmes;
import com.example.teste.model.Filmes;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filmes> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);

        this.criarFilmes();

        // Configurando Adapter
        AdapterFilmes adapterFilmes = new AdapterFilmes(listaFilmes);


        // Configurando RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapterFilmes);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Toast.makeText(getApplicationContext(), "Click curto: " + listaFilmes.get(position).getTituloFilme(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText(getApplicationContext(), "Longo click: " + listaFilmes.get(position).getTituloFilme(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
    }

    public void criarFilmes(){

        Filmes filme1 = new Filmes("Cidadão Kane", "Drama", "1941");
        this.listaFilmes.add(filme1);

        Filmes filme2 = new Filmes("O Poderoso Chefão", "Crime, Drama", "1972");
        this.listaFilmes.add(filme2);

        Filmes filme3 = new Filmes("Pulp Fiction: Tempo de Violência", "Crime, Drama", "1994");
        this.listaFilmes.add(filme3);

        Filmes filme4 = new Filmes("O Senhor dos Anéis: O Retorno do Rei", "Aventura, Fantasia", "2003");
        this.listaFilmes.add(filme4);

        Filmes filme5 = new Filmes("A Lista de Schindler", "Biografia, Drama, História", "1993");
        this.listaFilmes.add(filme5);

        Filmes filme6 = new Filmes("O Silêncio dos Inocentes", "Crime, Drama, Thriller", "1991");
        this.listaFilmes.add(filme6);

        Filmes filme7 = new Filmes("Forrest Gump: O Contador de Histórias", "Drama, Romance", "1994");
        this.listaFilmes.add(filme7);

        Filmes filme8 = new Filmes("A Origem", "Ação, Aventura, Ficção Científica", "2010");
        this.listaFilmes.add(filme8);

        Filmes filme9 = new Filmes("Interestelar", "Aventura, Drama, Ficção Científica", "2014");
        this.listaFilmes.add(filme9);

        Filmes filme10 = new Filmes("Matrix", "Ação, Ficção Científica", "1999");
        this.listaFilmes.add(filme10);

        Filmes filme11 = new Filmes("O Labirinto do Fauno", "Drama, Fantasia, Guerra", "2006");
        this.listaFilmes.add(filme11);

        Filmes filme12 = new Filmes("A Viagem de Chihiro", "Animação, Aventura, Família", "2001");
        this.listaFilmes.add(filme12);

        Filmes filme13 = new Filmes("O Rei Leão", "Animação, Aventura, Drama", "1994");
        this.listaFilmes.add(filme13);

        Filmes filme14 = new Filmes("De Volta para o Futuro", "Aventura, Comédia, Ficção Científica", "1985");
        this.listaFilmes.add(filme14);

        Filmes filme15 = new Filmes("O Poderoso Chefão: Parte II", "Crime, Drama", "1974");
        this.listaFilmes.add(filme15);


    }
}