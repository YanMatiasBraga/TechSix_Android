package com.techsix.techsix_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by android on 28/09/2018.
 */

public class TelaInicialAdm extends AppCompatActivity{

    private Button btnVisualizar;

    private FirebaseDatabase database;
    private DatabaseReference reference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inical_adm);

        btnVisualizar = (Button) findViewById(R.id.btnVisualizarConsultas);

        btnVisualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new  Intent(TelaInicialAdm.this, VisualizarConsultasActivity. class);
                startActivity(i);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_voltar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == R.id.menu_voltar){
//            Intent intent = new Intent();
//        }

        if(item.getItemId() == R.id.btnVisualizarConsultas)
        {
            Intent i = new Intent(TelaInicialAdm.this, VisualizarConsultasActivity.class);
            startActivity(i);

        }

        if (item.getItemId() == R.id.menu_voltar){
            FirebaseAuth.getInstance().signOut();
            finish();
        }

        if (item.toString().equals("Sair")){
            //  FirebaseAuth.getInstance().signOut();
            finish();
        }


        return super.onOptionsItemSelected(item);
    }



}
