package com.example.listatarefas.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.listatarefas.R;
import com.example.listatarefas.databinding.ActivityMainBinding;
import com.example.listatarefas.helper.TarefaDAO;
import com.example.listatarefas.model.Tarefa;
import com.google.android.material.textfield.TextInputEditText;

public class AdicionarTarefaActivity extends AppCompatActivity {

    private TextInputEditText editTarefa;
    private Tarefa tarefaEdicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);

        editTarefa = findViewById(R.id.editTarefa);

        tarefaEdicao = (Tarefa) getIntent().getSerializableExtra("tarefaSelecionada");

        if(tarefaEdicao != null){
            editTarefa.setText(tarefaEdicao.getNomeTarefa());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_adicionar_tarefa, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.itemSalvar){
            TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());

            String nomeTarefa = editTarefa.getText().toString();
            if(!nomeTarefa.isEmpty()){

                if(tarefaEdicao != null){ // Editando a tarefa

                    Tarefa tarefaEditada = new Tarefa();
                    tarefaEditada.setNomeTarefa(nomeTarefa);
                    tarefaEditada.setId(tarefaEdicao.getId());

                    if(tarefaDAO.atualizar(tarefaEditada)){
                        finish();
                        Toast.makeText(getApplicationContext(), "Tarefa atualizada", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "Erro ao atualizar tarefa: ", Toast.LENGTH_LONG).show();
                    }

                }else{
                    Tarefa tarefa = new Tarefa();
                    tarefa.setNomeTarefa(String.valueOf(editTarefa.getText()));

                    if(tarefaDAO.salvar(tarefa)){
                        finish();
                        Toast.makeText(getApplicationContext(), "Tarefa salva", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "Erro ao salvar tarefa: ", Toast.LENGTH_LONG).show();
                    }

                    // Para fechar a activity e voltar para a inicial
                    finish();
                }
            }else{
                Toast.makeText(this, "Informe uma tarefa para ser salva", Toast.LENGTH_SHORT).show();
                return false;
            }


        }

        return super.onOptionsItemSelected(item);
    }
}