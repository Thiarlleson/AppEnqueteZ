package com.example.thiarlleson.enquentez.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.thiarlleson.enquentez.R;

public class TelaPrincipal extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listaEnquetes;
    String[] enquetes={"Item 6" , "Item 7" , "Item 8", "Item 9" ,"Item 10"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);


        listaEnquetes = (ListView) findViewById(R.id.listViewHome);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_dropdown_item_1line,
                enquetes);

        listaEnquetes.setAdapter(adaptador);



        toolbar= (Toolbar) findViewById(R.id.toolbarHome);

        toolbar.setTitle("Enquetes");
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.item_sair){

            Intent i = new Intent(getApplicationContext(),TelaInicial.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnAdd(View view){
        Intent i = new Intent(getApplicationContext(),TelaCriarEnquente.class);
        startActivity(i);
    }
}
