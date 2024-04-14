package com.example.executandovideos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayerActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        videoView = findViewById(R.id.videoView);

        // Executar o vídeo
        videoView.setMediaController(new MediaController(this)); // Controlador do video. Aparece os botoes play, avançar e voltar
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video ); // Pegando o caminho do video a ser executado
        videoView.start();

        // Escondendo a ActionBar
        getSupportActionBar().hide();

        // Escondendo StaturBar e barra de navegação
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

    }
}