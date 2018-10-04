package com.techsix.techsix_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etSenha;
    private Button btnEntrar;

    private FirebaseAuth autenticacao;
   private FirebaseAuth.AuthStateListener stateListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etSenha = (EditText) findViewById(R.id.etSenha);
        btnEntrar = (Button) findViewById(R.id.btnEntrar);


        autenticacao = FirebaseAuth.getInstance();

        btnEntrar.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if (etEmail.getText().toString().equalsIgnoreCase("Oftclinicas@gmail.com") && etSenha.getText().toString().equals("123456")){
                        Intent i = new Intent(LoginActivity.this, TelaInicialAdm.class);
                        startActivity(i);
                   } else {

//                       Intent i = new Intent(LoginActivity.this, CadastroPacienteActivity.class);
//                       startActivity(i);
                       entrar();

                   }
               }
           });

//            stateListener = new FirebaseAuth.AuthStateListener() {
//                @Override
//                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                    FirebaseUser user = firebaseAuth.getCurrentUser();
//                    if (user != null){
//                        Intent i = new Intent(LoginActivity.this, TelaInicial.class);
//                        startActivity(i);
//                    }
//                }
//            };


    }


    @Override
    protected void onStart() {
        super.onStart();
  //      autenticacao.addAuthStateListener(stateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
//        if (stateListener != null){
//            autenticacao.removeAuthStateListener(stateListener);
//        }
    }

    private void entrar(){
        String Email = etEmail.getText().toString();
        String senha = etSenha.getText().toString();

        if (!Email.isEmpty()){
            autenticacao.signInWithEmailAndPassword(Email, senha).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()){
                        Toast.makeText(LoginActivity.this, "Email ou senha inválidos", Toast.LENGTH_LONG).show();
                    }else{
                        Intent i = new Intent(LoginActivity.this, TelaInicial.class);
                        startActivity(i);

                    }
                }
            });
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_telainical, menu);
        return true;
}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.menu_cadastrar)
        {
            Intent i = new Intent(LoginActivity.this, CadastroPacienteActivity.class);
            startActivity(i);

        }

        if(item.getItemId() == R.id.menu_voltar)
        {
            Intent i = new Intent(LoginActivity.this, CadastroPacienteActivity.class);
            startActivity(i);

        }


        if (item.toString().equals("Sair")){
          //  FirebaseAuth.getInstance().signOut();
            finish();
        }


        return super.onOptionsItemSelected(item);
    }
}

