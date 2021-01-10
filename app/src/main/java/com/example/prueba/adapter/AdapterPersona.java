package com.example.prueba.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.prueba.R;

import com.example.prueba.models.Persona;

import java.util.ArrayList;

public class AdapterPersona  extends RecyclerView.Adapter<AdapterPersona.ViewHolder>{

    ArrayList<Persona> list;

    public AdapterPersona(ArrayList<Persona> list){
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams") View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_product,null,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.writePersona(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView  personaName, personaEmail, personaBody;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            personaName = itemView.findViewById(R.id.persona_name);
            personaEmail = itemView.findViewById(R.id.persona_email);
            personaBody = itemView.findViewById(R.id.persona_body);

        }

        public void writePersona(Persona p) {
            personaName.setText(("NAME:\n" + p.getName()));
            personaEmail.setText(("EMAIL:\n" + p.getEmail()));
            personaBody.setText(("BODY:\n" + p.getBody()));
        }
    }
}
