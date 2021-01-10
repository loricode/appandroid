package com.example.prueba.models;

public class Persona {

    int  id;
    String name;
    String email;
    String body;


    public Persona(){
        id = 0;
        name = "";
        email = "";
        body = "";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }

}
