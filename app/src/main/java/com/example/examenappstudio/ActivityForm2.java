package com.example.examenappstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.examenappstudio.db.DBContacts;

public class ActivityForm2 extends AppCompatActivity {

    EditText txtusername, txtpassword;
    Button btnsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form2);

        txtusername = findViewById(R.id.txtusername);
        txtpassword = findViewById(R.id.txtpassword);
        btnsave = findViewById(R.id.btnsave);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBContacts DBContacts = new DBContacts(ActivityForm2.this);
             long id =  DBContacts.insertarUsuario(txtusername.getText().toString(), txtpassword.getText().toString());

               if(id > 0){
                   Toast.makeText(ActivityForm2.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                   impiar();
               }else{
                   Toast.makeText(ActivityForm2.this, "ERROR AL GUARDAR RREGISTRO", Toast.LENGTH_LONG).show();
               }
            }
        });

    }
    private void impiar(){
        txtusername.setText("");
        txtpassword.setText("");
    }
}