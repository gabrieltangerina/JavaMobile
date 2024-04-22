package com.example.criandomenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_principal, menu);

        return super.onCreateOptionsMenu(menu);
    }

    // Tratando o evento de click


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.itemSalvar){
            Toast.makeText(getApplicationContext(), "Clicou no item de salvar", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == R.id.itemConfiguracoes){
            Toast.makeText(getApplicationContext(), "Clicou no item de configurações", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}