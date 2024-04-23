package com.example.listatarefas.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    // CLASSE PARA MANIPULAÇÃO DO BANCO DE DADOS
    // ESSA CLASSE PODE SER USADA POR OUTRAS CLASSES, COMO UsuarioDAO

    public static int VERSION = 2;
    public static String NOME_DB = "DB_TAREFAS";
    public static String TABELA_TAREFAS = "tarefas";
    private Context context;

    public DbHelper(@Nullable Context context) {
        super(context, NOME_DB, null, VERSION);
        this.context = context;
    }

    @Override // Usado para criar a primeira vez o banco de dados. Chamado apenas uma vez quando o usuário instalar o app
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_TAREFAS +
                     " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     " nome TEXT NOT NULL ); ";

        try{
            db.execSQL(sql);
            Toast.makeText(context, "Sucesso ao criar a tabela", Toast.LENGTH_SHORT).show();
        }catch(Exception e){
            Toast.makeText(context, "Erro ao criar a tabela: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override // Usado para criar mais tabelas ou fazer alterações em tabelas existentes. Chamado quando o usuário atualiza o app. Voce altera o VERSION (versão do app)
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + NOME_DB + " ; ";

        try{
            // Apenas de mudar o atributo VERSAO o app ja executa esse método
            db.execSQL(sql);
            onCreate(db);
            Toast.makeText(context, "Sucesso ao atualizar app", Toast.LENGTH_LONG).show();
            Toast.makeText(context, "Versão antiga: " + oldVersion + "\nVersão atual: " + newVersion, Toast.LENGTH_LONG).show();
        }catch(Exception e){
            Toast.makeText(context, "Erro ao atualizar a tabela: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
