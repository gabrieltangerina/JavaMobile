package com.example.apppedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada(0);
    }
    public void selecionadoPapel(View view){
        this.opcaoSelecionada(1);
    }
    public void selecionadoTesoura(View view){
        this.opcaoSelecionada(2);
    }

    public void opcaoSelecionada(int opcaoSelecionada){

        // Pegando o elemento da tela (Imagem resposta)
        ImageView imgResultado = findViewById(R.id.imageResultado);

        // Pegando o elemento da tela (Mensagem Resposta)
        TextView textoResposta = findViewById(R.id.textResposta);

        ConstraintLayout telaDeFundo = findViewById(R.id.telaDeFundo);

        // Criando variavel que tera numeros aleatorios
        int numero = new Random().nextInt(3);


        Integer[] opcoes = {0, 1, 2};
        Integer opcoesApp = opcoes[numero];

        switch (opcoesApp){
            case 0:
                imgResultado.setImageResource(R.drawable.pedra);
                break;
            case 1:
                imgResultado.setImageResource(R.drawable.papel);
                break;
            case 2:
                imgResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if((opcoesApp == 0 && opcaoSelecionada == 2) || (opcoesApp == 1 && opcaoSelecionada == 0) || (opcoesApp == 2 && opcaoSelecionada == 1)){ // App ganhador
            textoResposta.setText("Você perdeu :(");
            telaDeFundo.setBackgroundColor(Color.parseColor("#F57168"));
        }else if((opcaoSelecionada == 0 && opcoesApp == 2) || (opcaoSelecionada == 1 && opcoesApp == 0) || (opcaoSelecionada == 2 && opcoesApp == 1)){ // Usuário ganhador
            textoResposta.setText("Você ganhou :)");
            telaDeFundo.setBackgroundColor(Color.parseColor("#79F27C"));
        }else{ // Empate
            textoResposta.setText("Empate");
            telaDeFundo.setBackgroundColor(Color.parseColor("#fefefe"));
        }

    }

}