package com.example.aprendendocomponentes2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResultado = findViewById(R.id.textResultado);
    }

    public void abrirDialog(View view){

        // Instânciou o AlertDialog
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        // Definiu o titulo e a mensagme
        dialog.setTitle("Título da dialog");
        dialog.setMessage("Mensagem da Dialog");

        // Configurar o cancelamento (Clicar fora da caixinha e sair sair dela) - Não obrigatório
        dialog.setCancelable(false);

        // Configurar icone - Não obrigatório
        dialog.setIcon(android.R.drawable.sym_def_app_icon);

        // Configurou as ações para as duas opções, no caso, sim e nao
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                Toast.makeText(getApplicationContext(), "Executar ação ao clicar no SIM", Toast.LENGTH_LONG).show();
                textResultado.setText("Clicou no SIM");
            }
        });

        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener(){
           @Override
           public void onClick(DialogInterface dialog, int which){
                Toast.makeText(getApplicationContext(), "Executar ação ao clicar no NÃO", Toast.LENGTH_LONG).show();
                textResultado.setText("Clicou no NÃO");
           }
        });

        // Cria e exibe AlertDialog
        dialog.create();
        dialog.show();

    }

}