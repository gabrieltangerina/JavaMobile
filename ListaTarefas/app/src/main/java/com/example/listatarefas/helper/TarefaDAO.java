package com.example.listatarefas.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.listatarefas.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefaDAO implements ITarefaDAO{

    private SQLiteDatabase salvaDados;
    private SQLiteDatabase leDados;

    public TarefaDAO(Context context) {
        DbHelper db = new DbHelper(context);

        salvaDados = db.getWritableDatabase();
        leDados = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Tarefa tarefa) {

        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getNomeTarefa());

        try{
            salvaDados.insert(DbHelper.TABELA_TAREFAS, null, cv);
            Log.i("INFO", "Tarefa salva com sucesso");
        }catch (Exception e){
            Log.i("INFO", "ERRO ao salvar tarefa");
            return false;
        }

        return true;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {

        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getNomeTarefa());

        try{
            String[] args = { tarefa.getId().toString() };
            salvaDados.update(DbHelper.TABELA_TAREFAS, cv, "id = ?", args);
            Log.i("INFO", "Tarefa atualizada com sucesso");
        }catch(Exception e){
            Log.i("INFO", "ERRO ao atualizar tarefa");
            return false;
        }

        return true;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {

        String[] args = { tarefa.getId().toString() };

        try{
            salvaDados.delete(DbHelper.TABELA_TAREFAS, " id = ?", args );
            Log.i("INFO", "Tarefa deletada com sucesso");
        }catch (Exception e){
            Log.i("INFO", "ERRO ao deletar tarefa");
            return false;
        }

        return true;
    }

    @Override
    public List<Tarefa> listar() {

        List<Tarefa> listaTarefas = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " ;";

        // Para que que serve o Cursor?
        Cursor c = leDados.rawQuery(sql, null);

        while(c.moveToNext()){
            Tarefa tarefa = new Tarefa();

            Long id = c.getLong(c.getColumnIndexOrThrow ("id"));
            String nomeTarefa = c.getString(c.getColumnIndexOrThrow ("nome"));

            tarefa.setId(id);
            tarefa.setNomeTarefa(nomeTarefa);

            listaTarefas.add(tarefa);
        }

        return listaTarefas;
    }
}
