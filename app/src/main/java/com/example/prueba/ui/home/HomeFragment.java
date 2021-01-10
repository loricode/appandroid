package com.example.prueba.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prueba.R;
import com.example.prueba.adapter.AdapterPersona;
import com.example.prueba.interfaz.IComentario;
import com.example.prueba.models.Persona;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {

      RecyclerView recycler;

      public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recycler = root.findViewById(R.id.listaComentarios);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        getComentarios();
        return root;
      }

      public void getComentarios() {
         Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final IComentario inter = retrofit.create(IComentario.class);
        Call<ArrayList<Persona>> cal = inter.getComentarios();
        cal.enqueue(new Callback<ArrayList<Persona>>() {
            @Override
            public void onResponse(Call<ArrayList<Persona>> call, Response<ArrayList<Persona>> response) {
                AdapterPersona adapter = new AdapterPersona(response.body());
                recycler.setAdapter(adapter);
                Toast.makeText(getContext(),"cargando...", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ArrayList<Persona>> call, Throwable t) {
                Toast.makeText(getContext(),"error", Toast.LENGTH_LONG).show();
            }
        });
      }


}