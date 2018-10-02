package com.techsix.techsix_android;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.techsix.techsix_android.model.Paciente;


public class CadastroPacienteActivity extends AppCompatActivity {

        private EditText etNome, etSenha_Cadastro, etNascimento, etEndereco, etTelefone, etEmail;
        private Spinner spSexo, spEstadoCivil;
        private Button btnSalvar;

        private FirebaseDatabase database;
        private DatabaseReference reference;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cadastro_paciente);

            etNome = (EditText) findViewById(R.id.etNomeCompleto);
            etSenha_Cadastro = (EditText) findViewById(R.id.etSenha);
            etNascimento = (EditText) findViewById(R.id.etNascimento);
            etEndereco = (EditText) findViewById(R.id.etEndereco);
            etTelefone = (EditText) findViewById(R.id.etTelefone);
            etEmail = (EditText) findViewById(R.id.etEmail);

            spSexo = (Spinner) findViewById(R.id.spSexo);
            spEstadoCivil = (Spinner) findViewById(R.id.spEstadoCivil);

            btnSalvar = (Button) findViewById(R.id.btnSalvar);

            database = FirebaseDatabase.getInstance();
            reference = database.getReference();

            btnSalvar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    cadastroPaciente();
                }
            });



        }


        private void cadastroPaciente(){
            String nome = etNome.getText().toString();
            String senha = etSenha_Cadastro.getText().toString();
            String nascimento = etNascimento.getText().toString();
            String endereco = etEndereco.getText().toString();
            String telefone = etTelefone.getText().toString();
            String email = etEmail.getText().toString();

         //   String sexo = spSexo.getSelectedItem().toString();
            String estadoCivil = spEstadoCivil.getSelectedItem().toString();


            if (!nome.isEmpty()  && !senha.isEmpty() && !endereco.isEmpty() && !telefone.isEmpty() && !email.isEmpty()  ) {
                Paciente paciente = new Paciente();
                paciente.setNome(nome);
                paciente.setSenha( senha );
                paciente.setEndereco(endereco);
                paciente.setTelefone(telefone);
                paciente.setEmail(email);


                   if (spSexo.getSelectedItemPosition() == 0){
                        paciente.setSexo("");
                   } else{
                       paciente.setSexo(spSexo.getSelectedItem().toString());
                   }

                if (estadoCivil.isEmpty()){
                    paciente.setEstado_civil(0);
                } else{
                    paciente.setEstado_civil(Integer.valueOf(estadoCivil));
                }


                reference.child("pacientes").push().setValue(paciente);

                  Toast.makeText(this, "Paciente salvo com sucesso!", Toast.LENGTH_LONG);


                    etEmail.setText("");
                    etNascimento.setText("");

                    etEndereco.setText("");
                    etTelefone.setText("");

                   etNome.setText("");
                   etSenha_Cadastro.setText("");
            } else {

                AlertDialog.Builder alerta = new AlertDialog.Builder(this);
                alerta.setTitle(0);
            }
        }
}
