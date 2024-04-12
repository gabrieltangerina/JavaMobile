package com.example.atm_consultoria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.atm_consultoria.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                SE NAO COLOCAR O NAV AQUI, QUANDO ENTRAR EM UM ITEM DE MENU IRÁ PARACE A SETINHA PRA
//                VOLTAR ONDE <-
                R.id.nav_principal, R.id.nav_servico, R.id.nav_contato,
                R.id.nav_servico, R.id.nav_sobre, R.id.nav_clientes)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void enviarEmail(){

        Intent intent = new Intent(Intent.ACTION_SEND);

        // Seria para quem vai enviar o email, Para:
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"atendimento@consultoria.com.br"});

        // Assunto do email
        intent.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo app");

        // Conteudo do email
        intent.putExtra(Intent.EXTRA_TEXT, "Mensagem automática");

        // Sãos os apps que irão aparecer ao clicar no icone no canto inferior direito
        // intent.setType("message/rfc822"); // Pega os apps de email
        intent.setType("text/plain"); // Pega Whatzaap, Facebook

        // Aparece a telinha para clicar no app, o title é o titulo dessa telinha
        startActivity(Intent.createChooser(intent, "Compartilhar"));
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}