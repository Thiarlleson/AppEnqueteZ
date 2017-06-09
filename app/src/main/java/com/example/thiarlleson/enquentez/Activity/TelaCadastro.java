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

public class TelaCadastro extends AppCompatActivity {

    private Usuario usuario;
    private EditText nome;
    private EditText email;
    private EditText senha;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        nome = (EditText)  findViewById(R.id.nome);
        email = (EditText) findViewById(R.id.email);
        senha = (EditText) findViewById(R.id.senha);

    }

    public void btnCadastrar(View view) {

        usuario = new Usuario();
        usuario.setNome(nome.getText().toString());
        usuario.setEmail(email.getText().toString());
        usuario.setSenha(senha.getText().toString());
        cadastrarUsuario();
}

    private void cadastrarUsuario() {

        autenticacao = Firebase.getAuthFirebase();
        autenticacao.createUserWithEmailAndPassword(usuario.getEmail(), usuario.getSenha()).
                addOnCompleteListener(TelaCadastro.this,
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){

                                    Toast.makeText(getApplicationContext(),"Sucesso ao cadastrar o usuário!",Toast.LENGTH_LONG).show();
                                    usuario.setId(task.getResult().getUser().getUid());
                                    usuario.salvar();

                                    Intent intent = new Intent(getApplicationContext(),TelaLogin.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else{

                             /*   String excecao="";
                            try{
                                   throw task.getException();
                            }
                            catch (FirebaseAuthWeakPasswordException e) {
                                excecao="Senha muito fraca, digite outra";
                            } catch (FirebaseAuthUserCollisionException e) {
                                excecao="Email já cadastrado , digite outro";
                            } catch (FirebaseAuthInvalidCredentialsException e) {
                                excecao="Email digitado é inválido";
                            } catch (Exception e) {
                                excecao="Fatal";
                            }
                            */

                                    Toast.makeText(getApplicationContext(),"Erro: ",Toast.LENGTH_LONG).show();
                                }
                            }
                        });

    }
}
