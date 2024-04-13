package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button buttonPlay;
    private Button buttonPause;
    private Button buttonStop;
    private SeekBar seekVolume;
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.teste);

        buttonPlay = findViewById(R.id.buttonPlay);
        buttonPause = findViewById(R.id.buttonPause);
        buttonStop = findViewById(R.id.buttonStop);

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executarMusica(v);
            }
        });

        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pausarMusica(v);
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pararMusica(v);
            }
        });

        inicializarSeekBar();

    }

    public void inicializarSeekBar(){

        seekVolume = findViewById(R.id.seekVolume);

        // O audioManager manager pega volume atual e volume maximo do dispositivo
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        int volumeMaximo = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int volumeAtual = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        // Configurando os valores máximos do Seekbar
        seekVolume.setMax(volumeMaximo);

        // Configurando o valor atual da Seekbar
        seekVolume.setProgress(volumeAtual);

        seekVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // A flag (do parâmetro abaixo) faz algumas configurações adicionais, ver documentação
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void executarMusica(View view){
        if(mediaPlayer != null){
            mediaPlayer.start();
        }
    }

    public void pausarMusica(View v){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }

    public void pararMusica(View v){
        if(mediaPlayer.isPlaying()){
            // Com o stop o mediaPlayer fica null, ent precisa criar novamente
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.teste);
        }
    }

    // Toda vez que o usuário minimizar o app, a musica é pausada
    @Override
    protected void onStop() {
        super.onStop();

        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }

    // Volta a musica quando o usuário voltar para o app
    @Override
    protected void onRestart() {
        super.onRestart();

        if(mediaPlayer != null){
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();

            // Libera os recursos da memoria
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}