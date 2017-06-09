package com.example.thiarlleson.enquentez.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thiarlleson.enquentez.DAO.Firebase;
import com.example.thiarlleson.enquentez.Entidades.Usuario;
import com.example.thiarlleson.enquentez.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class TelaLogin extends AppCompatActivity {

    private Usuario usuario;
    private EditText email;
    private EditText senha;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        email = (EditText) findViewById(R.id.email);
        senha = (EditText) findViewById(R.id.senha);
    }

    public void btnCadastrar(View view){
        Intent intent = new Intent(getApplicationContext(),TelaCadastro.class);
        startActivity(intent);
    }

    public void btnLogin(View view){

        usuario = new Usuario();
        usuario.setEmail(email.getText().toString());
        usuario.setSenha(senha.getText().toString());
        loginUsuario();
    }

    private void loginUsuario(){

        autenticacao = Firebase.getAuthFirebase();
        autenticacao.signInWithEmailAndPassword(usuario.getEmail(), usuario.getSenha()).
                addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Intent intent = new Intent(getApplicationContext(),TelaPrincipal.class);
                                    startActivity(intent);
                                    finish();
                                    Toast.makeText(getApplicationContext(),"Sucesso ao fazer o login do usuario!",Toast.LENGTH_LONG).show();
                                }
                                else{
                                    Toast.makeText(getApplicationContext(),"Erro ao fazer o login do usuario!",Toast.LENGTH_LONG).show();
                                }
                            }
                        });
    }

}
