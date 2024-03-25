package com.example.appfrasedodia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gerarNovaFrase(View view){

        String[] frases = {
                "'Ao infinito e além!' Toy Story",
                "'Continue nadando.' Produrando Nemo",
                "'Você não é apenas um lutador. Você é um Creed. E o Creed nasceu para lutar.' Creed",
                "'Que a sorte esteja sempre a seu favor.' Jogos Vorazes",
                "'A vida é como uma caixa de chocolates, você nunca sabe o que vai encontrar.' Forest Gump",
                "'Eu vejo você.' Avatar"
        };

        int numero = new Random().nextInt(frases.length);

        TextView texto = findViewById(R.id.textResultado);
        texto.setText(frases[numero]);

    }

}