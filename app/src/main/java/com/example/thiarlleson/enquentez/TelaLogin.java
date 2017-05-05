package com.example.thiarlleson.enquentez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TelaLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
    }


    public void btnCadastrar(View view){
        Intent i = new Intent(getApplicationContext() , TelaHome.class);
        startActivity(i);
    }
}
