package com.example.preferenciasdousuario;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editNome;
    private Button buttonSalvar;
    private TextView textResultado;
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editNome = findViewById(R.id.editNome);
        buttonSalvar = findViewById(R.id.buttonSalvar);
        textResultado = findViewById(R.id.textResultado);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // O 0 (zero) no quer dizer que apenas o o nosso app pode salvar e ler o arquivo
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);

                // Retorna um objeto do tipo Editor, é com esse objeto que edita o arquivo de preferencias
                SharedPreferences.Editor editor = preferences.edit();

                // Valida nome e salva
                if(editNome.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Preencha o nome", Toast.LENGTH_SHORT).show();
                }else{
                    String nome = editNome.getText().toString();
                    editor.putString("nome", nome);
                    editor.commit();

                    textResultado.setText("Olá, " + nome);
                }

            }
        });

        // Recuperando o nome
        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);

        // Valida se tem o nome salvo
        if(preferences.contains("nome")){

            String nome = preferences.getString("nome", "usuário não definido");
            textResultado.setText("Olá, " + nome);

        }else{
            textResultado.setText("Olá, usuário não definido");
        }

    }
}