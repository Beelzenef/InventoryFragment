package com.example.inventoryfragment.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.inventoryfragment.R;
import com.example.inventoryfragment.data.db.model.Dependency;
import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.ArrayList;

// Se ha de importar la R porque estamos en un package "aparte" que utiliza la Clase R

/**
 * Solucion más o menos optimizada
 * @author Elena G (Beelzenef)
 */

public class DependencyAdapter extends ArrayAdapter<Dependency> {

    private ArrayList<Dependency> dependencies;

    public DependencyAdapter(@NonNull Context context) {

        // Al tener más de un criterio, se crea una copia del Arraylist de DependencyRepositoriy
        // para tener una copia local en Adapter, modificable sin modificar los datos
        //super(context, R.layout.item_dependency, new ArrayList<>(DependencyRepository.getInstance().getDependencies()));

        super(context, R.layout.item_dependency, new ArrayList<Dependency>());

        sort(new Dependency.DependencyOrderBySortName());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        DependencyHolder dependencyHolder;
        View view = convertView;

        if (view == null) {

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
            dependencyHolder = new DependencyHolder();

            // Paso 3, inicializar las variables a los objetos ya creados de los widget del XML
            // CUIDADO --> usar view.findViewById() !!!

            dependencyHolder.icon = (MaterialLetterIcon) view.findViewById(R.id.materialLetterIcon);
            dependencyHolder.txtV_Name = (TextView) view.findViewById(R.id.txtV_NameDependecy);
            dependencyHolder.txtV_ShortName = (TextView) view.findViewById(R.id.txtV_ShortnameDependecy);

            // Cambiando fuentes programaticamente
            Typeface typeface = Typeface.createFromAsset(view.getContext().getAssets(), "font/mastercomics.ttf");
            dependencyHolder.txtV_ShortName.setTypeface(typeface);

            view.setTag(dependencyHolder);
        }
        else
        {
            dependencyHolder = (DependencyHolder) view.getTag();
        }

        // Paso 4, mostrar los datos del ArrayList mediante position
        dependencyHolder.txtV_Name.setText(getItem(position).getName());
        dependencyHolder.txtV_ShortName.setText(getItem(position).getShortname());
        dependencyHolder.icon.setLetter(getItem(position).getShortname().substring(0, 1));

        //return super.getView(position, convertView, parent);
        return view;
    }

    class DependencyHolder {

        MaterialLetterIcon icon;
        TextView txtV_Name;
        TextView txtV_ShortName;
    }
}
