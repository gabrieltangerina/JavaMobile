package com.example.appaprendendoingles.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.appaprendendoingles.R;

public class NumerosFragment extends Fragment implements View.OnClickListener {

    private ImageView imageNum1, imageNum2, imageNum3, imageNum4, imageNum5, imageNum6;
    private MediaPlayer mediaPlayer;

    public NumerosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_numeros, container, false);

        imageNum1 = view.findViewById(R.id.imageNum1);
        imageNum2 = view.findViewById(R.id.imageNum2);
        imageNum3 = view.findViewById(R.id.imageNum3);
        imageNum4 = view.findViewById(R.id.imageNum4);
        imageNum5 = view.findViewById(R.id.imageNum5);
        imageNum6 = view.findViewById(R.id.imageNum6);

        imageNum1.setOnClickListener(this);
        imageNum2.setOnClickListener(this);
        imageNum3.setOnClickListener(this);
        imageNum4.setOnClickListener(this);
        imageNum5.setOnClickListener(this);
        imageNum6.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.imageNum1){
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.one);
            tocarSom();
        } else if (v.getId() == R.id.imageNum2) {
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.two);
            tocarSom();
        }else if (v.getId() == R.id.imageNum3) {
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.three);
            tocarSom();
        }else if (v.getId() == R.id.imageNum4) {
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.four);
            tocarSom();
        }else if (v.getId() == R.id.imageNum5) {
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.five);
            tocarSom();
        }else if (v.getId() == R.id.imageNum6) {
            mediaPlayer = MediaPlayer.create(getActivity(), R.raw.six);
            tocarSom();
        }
    }

    public void tocarSom(){
        if(mediaPlayer != null){
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.release();
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}