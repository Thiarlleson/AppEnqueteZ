package com.example.thiarlleson.enquentez.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.thiarlleson.enquentez.R;

public class TelaPersonalizarEnquente extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_personalizar_enquente);

        toolbar = (Toolbar) findViewById(R.id.toolbarPersonalizarEnquete);

        toolbar.setTitle("Personalizar Enquete");
        setSupportActionBar(toolbar);
    }

    public void btnAddHome(View view){
        Intent i = new Intent(getApplicationContext(),TelaPrincipal.class);
        startActivity(i);
    }
}
