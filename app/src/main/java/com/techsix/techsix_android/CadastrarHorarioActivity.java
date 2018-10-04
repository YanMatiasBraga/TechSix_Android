package com.techsix.techsix_android;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.techsix.techsix_android.model.Consulta;

/**
 * Created by android on 01/10/2018.
 */

public class CadastrarHorarioActivity extends AppCompatActivity {

    private EditText etDataCadastro, etNomeMedico;
    private Spinner spHora;

    private Button btnSalvarHorarios;

    private FirebaseDatabase database;
    private DatabaseReference reference;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar_horario);

        etDataCadastro = (EditText) findViewById(R.id.etDataCadastro);
        spHora = (Spinner) findViewById(R.id.spHora);
        etNomeMedico = (EditText) findViewById(R.id.etNomeCompleto);


        btnSalvarHorarios = (Button) findViewById(R.id.btnSalvarHorarios);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference();

        btnSalvarHorarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarHorarioConulta();
            }
        });
    }

    private void cadastrarHorarioConulta(){
        String data = etDataCadastro.getText().toString();
        String hora = spHora.getSelectedItem().toString();
        String medico = etNomeMedico.getText().toString();

        if (!medico.isEmpty() && !data.isEmpty() && !hora.isEmpty()){
            Consulta consulta = new Consulta();
            consulta.setMedico(medico);
            consulta.setData(data);
            consulta.setHora(spHora.getSelectedItem().toString());
            }


            reference.child("data").push().setValue(data);
            reference.child("hora").push().setValue(hora);

            Toast.makeText(this, "Horário e Data cadastrados com sucesso!", Toast.LENGTH_LONG);

            etDataCadastro.setText("");

            spHora.setSelection(0);

        }

    }


