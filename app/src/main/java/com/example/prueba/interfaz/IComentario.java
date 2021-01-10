package com.example.prueba.interfaz;


import com.example.prueba.models.Persona;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;


public interface IComentario {

    @GET("comments/")
    Call< ArrayList<Persona> > getComentarios();

}