package com.techsix.techsix_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TelaInicial extends AppCompatActivity {

        private Button btnMarcarConsulta;

    private FirebaseDatabase database;
    private DatabaseReference reference;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);


        btnMarcarConsulta = (Button) findViewById(R.id.btnMarcarConsultas);

//        databaseList() = FirebaseDatabase.getInstance();
//        reference = database.getReference();


        btnMarcarConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new  Intent(TelaInicial.this, CadastrarHorarioActivity. class);
                startActivity(i);
            }
        });

    }









    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_voltar,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menu_sair_programa){
            FirebaseAuth.getInstance().signOut();
            finish();
        }




        return super.onOptionsItemSelected(item);
    }



}
