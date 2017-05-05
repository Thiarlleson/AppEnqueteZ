package com.example.thiarlleson.enquentez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TelaPrincipal extends AppCompatActivity {

    private ListView listaEnquetes;
    String[] enquetes={"Item 1" , "Item 2" , "Item 3", "Item 4" ,"Item 5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        listaEnquetes=(ListView) findViewById(R.id.listViewPrincipal);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_dropdown_item_1line,
                enquetes);

        listaEnquetes.setAdapter(adaptador);
    }

    public void btnLogar(View view){
        Intent i = new Intent(getApplicationContext(),TelaLogin.class);
        startActivity(i);
    }



}
