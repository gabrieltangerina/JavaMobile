package com.example.appaprendendoingles.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.appaprendendoingles.R;

public class BichosFragment extends Fragment implements View.OnClickListener {

    private ImageView imageCao, imageGato, imageLeao, imageMacaco, imageOvelha, imageVaca;
    private MediaPlayer mediaPlayer;

    public BichosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bichos, container, false);

        imageCao = view.findViewById(R.id.imageCao);
        imageGato = view.findViewById(R.id.imageGato);
        imageLeao = view.findViewById(R.id.imageLeao);
        imageMacaco = view.findViewById(R.id.imageMacaco);
        imageOvelha = view.findViewById(R.id.imageOvelha);
        imageVaca = view.findViewById(R.id.imageVaca);

        // Aplicando evento de click. Usa-se o "this" para falar que o evento de click será tratado pela propria classe
        imageCao.setOnClickListener(this);
        imageGato.setOnClickListener(this);
        imageLeao.setOnClickListener(this);
        imageMacaco.setOnClickListener(this);
        imageOvelha.setOnClickListener(this);
        imageVaca.setOnClickListener(this);



        return view;
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.imageCao){
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dog);
            tocarSom();
        }else if(v.getId() == R.id.imageGato){
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cat);
            tocarSom();
        }else if(v.getId() == R.id.imageLeao){
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lion);
            tocarSom();
        }else if(v.getId() == R.id.imageMacaco){
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.monkey);
            tocarSom();
        }else if(v.getId() == R.id.imageOvelha){
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.sheep);
            tocarSom();
        }else if(v.getId() == R.id.imageVaca){
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cow);
            tocarSom();
        }

    }

    public void tocarSom(){
        if(mediaPlayer != null){
            mediaPlayer.start();

            // Sempre que completar o som será liberado os recursos da memória armazenados ao usar o som
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.release();
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();

        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}