package com.techsix.techsix_android;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by android on 01/10/2018.
 */

public class CadastrarHorarioActivity extends AppCompatActivity {

    private EditText etDataCadastro, etHoraCadastro;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar_horario);


    }
}
