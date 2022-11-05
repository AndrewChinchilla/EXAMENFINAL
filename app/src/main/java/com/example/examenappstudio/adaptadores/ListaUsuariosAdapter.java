package com.example.examenappstudio.adaptadores;

import static com.example.examenappstudio.db.dbHelper.TABLE_USUARIO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenappstudio.R;
import com.example.examenappstudio.db.DBContacts;
import com.example.examenappstudio.db.dbHelper;
import com.example.examenappstudio.entidades.usuarios;

import java.util.ArrayList;

public class ListaUsuariosAdapter extends RecyclerView.Adapter<ListaUsuariosAdapter.usuarioViewHolder> {

    ArrayList<usuarios> listausuarios;


    public void listausuariosAdapter(ArrayList<usuarios> listausuarios){
        this.listausuarios =listausuarios;
    }
    @NonNull
    @Override
    public usuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_usuario, null, false);
        return new usuarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull usuarioViewHolder holder, int position) {
holder.viewnombre.setText(listausuarios.get(position).getUsername());
holder.viewpassword.setText(listausuarios.get(position).getPassword());
    }

    @Override
    public int getItemCount() {
       return listausuarios.size();

    }

    public static class usuarioViewHolder extends RecyclerView.ViewHolder {

        TextView viewnombre, viewpassword;
        public usuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            viewnombre=itemView.findViewById(R.id.viewnombre);
            viewpassword=itemView.findViewById(R.id.viewpass);
        }
    }
}
