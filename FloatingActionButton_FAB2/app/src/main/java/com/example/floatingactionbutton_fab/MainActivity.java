package com.example.floatingactionbutton_fab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private TextView textID;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = findViewById(R.id.fab);
        textID = findViewById(R.id.textID);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Clicou", Snackbar.LENGTH_LONG).setAction("FAB pressionado", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textID.setText("Pressionou o botão do FAB");
                    }
                }).setActionTextColor(getResources().getColor(R.color.white)).show();
            }
        });
    }
}