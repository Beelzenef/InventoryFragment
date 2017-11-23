package com.example.inventoryfragment.db.model;

import android.support.annotation.NonNull;

import java.util.Comparator;

/**
 * Clase POJO para contener Dependencias
 * @author Elena G (Beelzenef)
 */

public class Dependency implements Comparable {
    private int _ID;
    private String name;
    private String shortname;
    private String description;

    // Getters y setters

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Constructor

    public Dependency(int _ID, String name, String shortname, String description) {
        this._ID = _ID;
        this.name = name;
        this.shortname = shortname;
        this.description = description;
    }

    // Sobreescribiendo toString()

    @Override
    public String toString() {
        return this.shortname;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        return name.compareTo(((Dependency)o).getName());
    }

    public static class DependencyOrderBySortName implements Comparator<Dependency>
    {

        @Override
        public int compare(Dependency o1, Dependency o2) {
            return o1.getShortname().compareTo(o2.getShortname());
        }
    }
}
