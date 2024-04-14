package com.example.executandovideos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageExecutar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageExecutar= findViewById(R.id.imageExecutar);

        imageExecutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirVideo(v);
            }
        });
    }

    public void abrirVideo(View view){
        startActivity(new Intent(this, PlayerActivity.class));
    }
}