package com.techsix.techsix_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * Created by android on 28/09/2018.
 */

public class TelaInicialAdm extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inical_adm);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_voltar){
            Intent intent = new Intent();
        }

        if(item.getItemId() == R.id.btnCadastrarHorarios)
        {
            Intent i = new Intent(TelaInicialAdm.this, CadastroPacienteActivity.class);
            startActivity(i);

        }

        return super.onOptionsItemSelected(item);
    }



}
