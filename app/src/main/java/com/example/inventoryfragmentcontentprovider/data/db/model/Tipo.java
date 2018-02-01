package com.example.inventoryfragmentcontentprovider.data.db.model;

/**
 * Created by usuario on 1/02/18.
 */

public class Tipo {

    int id;
    String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
