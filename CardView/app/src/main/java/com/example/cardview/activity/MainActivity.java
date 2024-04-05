package com.example.cardview.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardview.R;
import com.example.cardview.activity.adapter.PostagemAdapter;
import com.example.cardview.activity.model.Postagem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;
    private ArrayList<Postagem> postagens = new ArrayList<>();

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

        recyclerPostagem = findViewById(R.id.recyclerView);

        // Definindo layout

        // Layout Linear Vertical
         RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        // Layout Linear Horizontal
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(RecyclerView.HORIZONTAL);

        // Layout Grid - no caso nao vai ficar bom porque nao tem apenas a imagem no xml,entao n via ficar igual no instagram por exemplo
//         RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);


        recyclerPostagem.setLayoutManager(layoutManager);


        this.prepararPostagens();

        // Definindo Adapter
        PostagemAdapter postagemAdapter = new PostagemAdapter(postagens);
        recyclerPostagem.setAdapter(postagemAdapter);
    }

    public void prepararPostagens(){

        Postagem p1 = new Postagem("Marlux", "Garantia de Qualidade", R.drawable.logo);
        this.postagens.add(p1);

        Postagem p2 = new Postagem("Marlux_2", "Garantia de Qualidade", R.drawable.logo);
        this.postagens.add(p2);

        Postagem p3 = new Postagem("Marlux_3", "Garantia de Qualidade", R.drawable.logo);
        this.postagens.add(p3);

    }

}