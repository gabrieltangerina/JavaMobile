package com.example.navigationdrawer;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.navigationdrawer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Configura barra de navegação
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot()); // O erro estava aqui, o binding estava no lugar errado e nao aqui
        setSupportActionBar(binding.appBarMain.toolbar);

        // A tela como um toda
        DrawerLayout drawer = binding.drawerLayout;

        // Área que abre ao clicar no menu hamburguer
        NavigationView navigationView = binding.navView;

        // Onde fica os itens dentro do menu hamburguer
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_contato)
                .setOpenableLayout(drawer)
                .build();

        // Área que irá carregar os fragments, o conteudo que troca ao clicar nos itens do menu hamburguer
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);

        // Exibe o icone do menu hamburguer e faz o evento de abrir o NavigationView
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        // Configura a ação de clicar no botão dos itens do NavigationView e carregar o fragment
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    // Esse é o método que permite a ação de abrir e fechar o menu
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


}