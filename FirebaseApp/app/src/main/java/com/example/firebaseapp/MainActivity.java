package com.example.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference(); // Referência para a raiz dos dados
    private FirebaseAuth autenticacao = FirebaseAuth.getInstance(); // Autenticação de login

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // FAZENDO LOGIN
        autenticacao.signInWithEmailAndPassword("gabrieltng05@gmail.com", "123456")
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(), "Usuário logado com sucesso", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "Falha ao fazer login", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        // DESLOGANDO USUÁRIO
        // autenticacao.signOut();

        // VERIFICA USUÁRIO LOGADO
        /*
        if(autenticacao.getCurrentUser() != null){
            Toast.makeText(getApplicationContext(), "Usuário logado", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(), "Usuário NÃO está logado", Toast.LENGTH_LONG).show();
        }
         */

        /* // CADASTRANDO UM USUÁRIO
        autenticacao.createUserWithEmailAndPassword("gabriel@email.com", "123456")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(), "Sucesso ao cadastrar usuário", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "Erro ao cadastrar usuário", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
         */

        /* CRIANDO REFERÊNCIAS NOS NÓS
        DatabaseReference noUsuario = referencia.child("usuarios");
        DatabaseReference noUsuario001 = referencia.child("usuarios").child("001");
        DatabaseReference noProduto = referencia.child("produtos");
         */

        /* ADICIONANDO ESCUTADOR PARA MUDANÇAS DOS DADOS E RECUPERANDO DADOS
        noUsuario001.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Quando ocorre uma mudança no no referenciado
                Toast.makeText(getApplicationContext(), Objects.requireNonNull(snapshot.getValue()).toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Para tratamento de erros
            }
        });
         */

        /* SALVANDO DADOS NO FIREBASE
        referencia.child("pontos").setValue("100"); // Criando uma registro de pontos com o valor 100
        referencia.child("usuarios").child("001").child("nome").setValue("Gabriel");

        Usuario usuario = new Usuario("Gabriel", "Tangerina", 19);
        noUsuario.child("002").setValue(usuario);

        Produto produto = new Produto("MacBook M1", "Apple", 6200.00);
        noProduto.child("001").setValue(produto);
        */
    }
}