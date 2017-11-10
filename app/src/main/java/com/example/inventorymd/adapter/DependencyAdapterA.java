package com.example.inventorymd.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.inventorymd.R;
import com.example.inventorymd.db.model.Dependency;
import com.example.inventorymd.db.repo.DependencyRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

// Se ha de importar la R porque estamos en un package "aparte" que utiliza la Clase R

/**
 * Solucion no optimizada
 * @author Elena G (Beelzenef)
 */

public class DependencyAdapterA extends ArrayAdapter<Dependency> {


    public DependencyAdapterA(@NonNull Context context) {
        super(context, R.layout.item_dependency, DependencyRepository.getInstance().getDependencies());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        MaterialLetterIcon icon;
        TextView txtV_Name;
        TextView txtV_ShortName;

        View view;

        // Paso 1, obtener el servicio del sistema LayoutInflater

        // Opcion 1:
        //LayoutInflater inflador = LayoutInflater.from(getContext());
        // Opcion 2: no recomendada por Lourdes
        //LayoutInflater inflador = ((Activity)getContext()).getLayoutInflater();
        // Opcion 3:
        LayoutInflater inflador = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // Paso 2, inflar la vista, en memoria el objeto View con todos los widget de item_dependecy.xml

        // Necesita un null, no estamos asignando otro ViewGroup que no sea el que ya contiene item_dependency.xml
        view = inflador.inflate(R.layout.item_dependency, null);

        // Paso 3, inicializar las variables a los objetos ya creados de los widget del XML
        // CUIDADO --> usar view.findViewById() !!!

        icon = (MaterialLetterIcon) view.findViewById(R.id.materialLetterIcon);
        txtV_Name = (TextView) view.findViewById(R.id.txtV_NameDependecy);
        txtV_ShortName = (TextView) view.findViewById(R.id.txtV_ShortnameDependecy);

        // Paso 4, mostrar los datos del ArrayList mediante position
        txtV_Name.setText(getItem(position).getName());
        txtV_ShortName.setText(getItem(position).getShortname());
        icon.setLetter(getItem(position).getShortname().substring(0, 1));

        //return super.getView(position, convertView, parent);
        return view;
    }
}
