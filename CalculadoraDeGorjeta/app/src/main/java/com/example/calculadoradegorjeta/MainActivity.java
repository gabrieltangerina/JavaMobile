package com.example.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText textValorConta;
    private SeekBar seekBar;
    private TextView textGorjeta;
    private TextView textTotal;
    private TextView textPorcentagem;
    private double porcentagem = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textValorConta = findViewById(R.id.textValorConta);
        seekBar = findViewById(R.id.seekBar);
        textGorjeta = findViewById(R.id.textGorjeta);
        textTotal = findViewById(R.id.textTotal);
        textPorcentagem = findViewById(R.id.textPorcentagem);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                porcentagem = progress;
                textPorcentagem.setText(Math.round(porcentagem) + "%");
                calcular();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void calcular(){

        String valorRecuperado = textValorConta.getText().toString();

        if( valorRecuperado == null || valorRecuperado.equals("")){
            Toast.makeText(getApplicationContext(), "Campo valor vazio", Toast.LENGTH_LONG).show();
        }else{
            double valorDigitado = Double.parseDouble(valorRecuperado);

            double gorjeta = valorDigitado * (porcentagem/100);

            textGorjeta.setText("R$ " + gorjeta);

            textTotal.setText("R$ " + (gorjeta + valorDigitado));
        }

    }

}