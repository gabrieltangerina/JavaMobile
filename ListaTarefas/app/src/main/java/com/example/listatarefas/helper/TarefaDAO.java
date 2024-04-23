package com.example.listatarefas.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.listatarefas.model.Tarefa;

import java.util.List;

public class TarefaDAO implements ITarefaDAO{

    private SQLiteDatabase salvaDados;
    private SQLiteDatabase leDados;
    private Context context;

    public TarefaDAO(Context context) {
        DbHelper db = new DbHelper(context);
        this.context = context;

        salvaDados = db.getWritableDatabase();
        leDados = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Tarefa tarefa) {

        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getNomeTarefa());

        try{
            salvaDados.insert(DbHelper.NOME_DB, null, cv);
            Toast.makeText(context, "Tarefa salva com SUCESSO!", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(context, "Erro ao salvar tarefa: " + e.getMessage(), Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {
        return false;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {
        return false;
    }

    @Override
    public List<Tarefa> listar() {
        return null;
    }
}
