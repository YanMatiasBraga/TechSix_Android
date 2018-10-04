package com.techsix.techsix_android;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
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
    private Button btnVoltar;

    private FirebaseDatabase database;
    private DatabaseReference reference;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar_horario);

        etDataCadastro = (EditText) findViewById(R.id.etDataCadastro);
        spHora = (Spinner) findViewById(R.id.spHora);


        btnSalvarHorarios = (Button) findViewById(R.id.btnSalvarHorarios);
        btnVoltar = (Button) findViewById(R.id.btnVoltarCadastrarHorario);



        database = FirebaseDatabase.getInstance();
        reference = database.getReference();

        btnSalvarHorarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarHorarioConulta();
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void cadastrarHorarioConulta(){
        String data = etDataCadastro.getText().toString();
        String hora = spHora.getSelectedItem().toString();

        if (!data.isEmpty() && !hora.isEmpty()) {
            Consulta consulta = new Consulta();
            consulta.setData(data);
            consulta.setHora(spHora.getSelectedItem().toString());
            String codPaciente = FirebaseAuth.getInstance().getCurrentUser().getUid();
            consulta.setCodPaciente(  codPaciente );


            reference.child("consultas").push().setValue(consulta);

            Toast.makeText(this, "Horário e Data cadastrados com sucesso!", Toast.LENGTH_LONG);

            etDataCadastro.setText("");

            spHora.setSelection(0);

        }

        }

    }


