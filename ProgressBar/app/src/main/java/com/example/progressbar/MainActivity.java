package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBarHorizontal;
    private ProgressBar progressBarCircular;
    private int progresso = 0;
    Boolean progressBarCircularAtivado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBarHorizontal = findViewById(R.id.progressBarHorizontal);
        progressBarCircular = findViewById(R.id.progressBarCircular);

        progressBarCircular.setVisibility(View.GONE);

    }

    public void carregarProgressBar(View view){
        this.progresso += 1;
        progressBarHorizontal.setProgress(progresso);

        progressBarCircularAtivado = !progressBarCircularAtivado;

        if(progressBarCircularAtivado){
            progressBarCircular.setVisibility(View.VISIBLE);
        }else{
            progressBarCircular.setVisibility(View.GONE);
        }
    }
}