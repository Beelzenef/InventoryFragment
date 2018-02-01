package com.example.inventoryfragmentcontentprovider.data.db.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by usuario on 31/01/18.
 */

public class Product implements Parcelable {

    String descripcion;
    int sectionid;
    int dependencyid;
    int tipo;
    int categoria;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getSectionid() {
        return sectionid;
    }

    public void setSectionid(int sectionid) {
        this.sectionid = sectionid;
    }

    public int getDependencyid() {
        return dependencyid;
    }

    public void setDependencyid(int dependencyid) {
        this.dependencyid = dependencyid;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public Product(String descripcion, int sectionid, int dependencyid, int tipo, int categoria) {
        this.descripcion = descripcion;
        this.sectionid = sectionid;
        this.dependencyid = dependencyid;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    private Product(Parcel parcel) {
        this.descripcion = parcel.readString();
        this.sectionid = parcel.readInt();
        this.dependencyid = parcel.readInt();
        this.tipo = parcel.readInt();
        this.categoria = parcel.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(descripcion);
        parcel.writeInt(sectionid);
        parcel.writeInt(dependencyid);
        parcel.writeInt(tipo);
        parcel.writeInt(categoria);
    }

    public final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel parcel) {
            return new Product(parcel);
        }

        @Override
        public Product[] newArray(int i) {
            return new Product[0];
        }
    };
}
