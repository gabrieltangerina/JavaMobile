package com.example.fragment.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragment.R;
import com.example.fragment.fragment.ContatosFragment;
import com.example.fragment.fragment.ConversasFragment;

public class MainActivity extends AppCompatActivity {

    private Button buttonConversas, buttonContatos;
    private ConversasFragment conversasFragment;
    private ContatosFragment contatosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Remover sombra da action bar
        getSupportActionBar().setElevation(0);

        buttonConversas = findViewById(R.id.buttonConversa);
        buttonContatos = findViewById(R.id.buttonContato);

        conversasFragment = new ConversasFragment();

        // Configurando objeto para o Fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameConteudo, conversasFragment);
        transaction.commit();

        buttonContatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                contatosFragment = new ContatosFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, contatosFragment);
                transaction.commit();

            }
        });

        buttonConversas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                conversasFragment = new ConversasFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, conversasFragment);
                transaction.commit();

            }
        });

    }
}