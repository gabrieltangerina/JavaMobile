package com.example.bd_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{

            // Criando banco de dados
            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            // Criar tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (nome VARCHAR, idade INT(3))");

            // Inserindo dados
            // bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Gabriel', 19)");
            // bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Maria', 35)");

            // Recuperando dados
            Cursor cursor = bancoDados.rawQuery("SELECT * FROM pessoas", null);

            // Indice da tabela. Cada coluna da tabela tem um índice 0, 1, 2... Use-se esse indice para pegar o valor no looping
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst(); // Quando o cursor recebe o rawQuery ele para no último elemento, entao tem q usar esse moveToFirst para ir para o inicio da lista
            while (cursor != null){
                Toast.makeText(getApplicationContext(), "Pessoa: " + cursor.getString(indiceNome) + " | Idade: " + cursor.getString(indiceIdade), Toast.LENGTH_SHORT).show();
                cursor.moveToNext(); // Passa para o próximo item
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}