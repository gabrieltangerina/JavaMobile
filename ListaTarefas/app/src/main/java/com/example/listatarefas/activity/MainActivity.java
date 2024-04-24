package com.example.listatarefas.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;

import com.example.listatarefas.R;
import com.example.listatarefas.activity.AdicionarTarefaActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listatarefas.adapter.AdapterTarefas;
import com.example.listatarefas.databinding.ActivityMainBinding;
import com.example.listatarefas.helper.DbHelper;
import com.example.listatarefas.helper.RecyclerItemClickListener;
import com.example.listatarefas.helper.TarefaDAO;
import com.example.listatarefas.model.Tarefa;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private View binding;
    private List<Tarefa> listaTarefas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerListaTarefas);

        // Pegando o botao do canto inferior direito que cria tarefas
        binding = findViewById(R.id.fab);

        // Quando o usuário carregar o app pela primeira vez, será criado o evento de click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Toast.makeText(getApplicationContext(), "Clicou no item: " + listaTarefas.get(position).getNomeTarefa(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText(getApplicationContext(), "Clicou e segurou no item: " + listaTarefas.get(position).getNomeTarefa(), Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );

        binding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), AdicionarTarefaActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        // O método onCreate é chamado apenas quando a activity é carregada, logo quando criarmos uma tarefa e retornarmos para o menu principal, não aparecerá a nova tarefa
        carregarListaTarefas();
    }

    public void carregarListaTarefas(){

        TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
        listaTarefas = tarefaDAO.listar();

        // Criando adapter
        AdapterTarefas adapterTarefas = new AdapterTarefas(listaTarefas);

        // Configurando RecyclerView
        recyclerView = findViewById(R.id.recyclerListaTarefas);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapterTarefas);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Configurações", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

}