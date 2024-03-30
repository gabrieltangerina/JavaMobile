package com.example.caixadetexto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText campoNome;
    private TextInputEditText campoEmail;
    private  TextView textoResultado;

    private CheckBox checkVerde, checkBranco, checkVermelho;

    private RadioGroup radioGroupSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TextInput
        campoNome = findViewById(R.id.editNome);
        campoEmail = findViewById(R.id.editEmail);
        textoResultado = findViewById(R.id.textResultado);

        // CheckBox
        checkVerde = findViewById(R.id.checkVerde);
        checkBranco = findViewById(R.id.checkBranco);
        checkVermelho = findViewById(R.id.checkVermelho);

        // RadioButton
        radioGroupSexo = findViewById(R.id.radioGroupSexo);
        radioButton();

    }

    public void radioButton(){

        radioGroupSexo.setOnCheckedChangeListener(new  RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                RadioButton radioButton = findViewById(checkedId);
                textoResultado.setText(radioButton.getText());
            }
        });

    }

    public void enviar(View view){

        //checkBox();

        //String nome = campoNome.getText().toString();
        //String email = campoEmail.getText().toString();
        //textoResultado.setText("Nome: " + nome + " E-mail: " + email);

    }

    public void checkBox(){

        String mensagem = "";

        if(checkVerde.isChecked()){
            mensagem += checkVerde.getText() + " selecionado - ";
        }

        if(checkBranco.isChecked()){
            mensagem += checkBranco.getText() + " selecionado - ";
        }

        if(checkVermelho.isChecked()){
            mensagem += checkVermelho.getText() + " selecionado - ";
        }

        textoResultado.setText(mensagem);

    }

    public void limpar(View view){
        campoNome.setText("");
        campoEmail.setText("");
    }

}