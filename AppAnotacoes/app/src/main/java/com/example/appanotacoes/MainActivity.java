package com.example.appanotacoes;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;


import com.example.appanotacoes.databinding.ActivityMainBinding;

import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private AnotacaoPreferencias preferencias;
    private EditText editAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Os elementos tem que ser pego depois de inflar o layou, ou seja, depois das linhas de codigo abaixo
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        editAnotacao = findViewById(R.id.editAnotacao);

        preferencias = new AnotacaoPreferencias(getApplicationContext());

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Valida se foi digitado algo no input
                String textoRecuperado = editAnotacao.getText().toString();
                if(textoRecuperado.equals("")){
                    Snackbar.make(view, "Preencha a anotação", Snackbar.LENGTH_LONG).show();
                }else{
                    preferencias.salvarAnotacao(textoRecuperado);
                    Snackbar.make(view, "Anotação salva com sucesso", Snackbar.LENGTH_LONG).show();
                }


            }
        });

        // Recuperando anotações
        String anotacao = preferencias.recuperarAnotacoes();
        if(!anotacao.equals("")){
            editAnotacao.setText(anotacao);
        }
    }

}