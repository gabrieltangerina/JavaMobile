package com.example.appalcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResult = findViewById(R.id.textResult);

    }

    public void calcularPreco(View view){

        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        Boolean validacao = this.validaCampos(precoAlcool, precoGasolina);

        if(!validacao){
            textResult.setText("Campos inválidos. Preencha os preços primeiro!");
            return;
        }

        Double valorAlcool = Double.parseDouble(precoAlcool);
        Double valorGasolina = Double.parseDouble(precoGasolina);

        if((valorAlcool / valorGasolina) >= 0.7){
            textResult.setText("Melhor utilizar Gasolina");
        }else{
            textResult.setText("Melhor utilizar Álcool");
        }
    }

    public Boolean validaCampos(String valAlcool, String valGasolina){
        Boolean validacao = true;

        if(valAlcool == null || valAlcool.equals("")){
            validacao = false;
            Toast.makeText(getApplicationContext(), "Campo Álcool inválido", Toast.LENGTH_SHORT).show();
        }else if(valGasolina == null || valGasolina.equals("")){
            validacao = false;
            Toast.makeText(getApplicationContext(), "Campo Gasolina inválido", Toast.LENGTH_SHORT).show();
        }

        return validacao;
    }



}