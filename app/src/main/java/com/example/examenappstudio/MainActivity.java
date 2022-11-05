package com.example.examenappstudio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.examenappstudio.adaptadores.ListaUsuariosAdapter;
import com.example.examenappstudio.db.DBContacts;
import com.example.examenappstudio.db.dbHelper;
import com.example.examenappstudio.entidades.usuarios;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

 RecyclerView listausuarios;
ArrayList<usuarios> listaArrayusuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listausuarios = findViewById(R.id.listaUsuarios);

        listausuarios.setLayoutManager(new LinearLayoutManager(this));
        DBContacts DBContacts = new DBContacts(MainActivity.this);
        listaArrayusuarios = new ArrayList<>(DBContacts.MostrarUsuarios());

        ListaUsuariosAdapter adapter = new ListaUsuariosAdapter();
        listausuarios.setAdapter(adapter);

    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.menuNuevo:
                nuevoRegistro();
                return true;

            default:
             return super.onOptionsItemSelected(item);

        }
    }
    private void nuevoRegistro() {
        Intent intent = new Intent(this, ActivityForm2.class);
        startActivity(intent);
    }

}