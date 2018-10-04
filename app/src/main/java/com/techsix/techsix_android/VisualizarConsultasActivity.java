package com.techsix.techsix_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.techsix.techsix_android.model.Consulta;
import com.techsix.techsix_android.model.Paciente;

import java.util.ArrayList;
import java.util.List;

public class VisualizarConsultasActivity extends AppCompatActivity {

    private ListView lvPacientes;
    private List<Consulta> listaDeConsultas;
    private ArrayAdapter adapter;
    private FirebaseDatabase database;
    private DatabaseReference reference;
    private Query queryRef;
    private ChildEventListener childEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visualizar_consultas_marcadas);

        lvPacientes = (ListView) findViewById(R.id.lvConsultasMarcadas);
        listaDeConsultas = new ArrayList<>();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDeConsultas);
        lvPacientes.setAdapter(adapter);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference();



    }


    @Override
    protected void onStart() {
        super.onStart();

        queryRef = reference.child("consultas").orderByChild("data");

        listaDeConsultas.clear();

        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {


                Consulta consulta = new Consulta();
                consulta.setId(dataSnapshot.getKey());
                consulta.setData(dataSnapshot.child("data").getValue(String.class));
                consulta.setHora(dataSnapshot.child("hora").getValue(String.class));
                listaDeConsultas.add(consulta);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        queryRef.addChildEventListener(childEventListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        queryRef.removeEventListener(childEventListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add("Sair");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.toString().equals("Sair")){
            FirebaseAuth.getInstance().signOut();
            finish();
        }

        if (item.getItemId() == R.id.menu_sair_programa){
            FirebaseAuth.getInstance().signOut();
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
