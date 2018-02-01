package com.example.inventoryfragmentcontentprovider.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.inventoryfragmentcontentprovider.R;
import com.example.inventoryfragmentcontentprovider.data.db.model.Dependency;
import com.example.inventoryfragmentcontentprovider.data.db.model.Product;
import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductAdapter extends ArrayAdapter<Product> {

    public ProductAdapter(@NonNull Context context) {
        //LO dejamos vacio porque los cargaremos cuando el interactor nos diga que carguemos los datos:
        super(context, R.layout.item_product, new ArrayList<Product>());
        //SE HACE AQUI EL SORT
        //sort(un new comparator)
    }

    //Este metodo es el que devuelve un objeto View. Lo llama el S.O. automaticamente una vez por cada elemento del ArrayAdapter.
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        TextView txvName;


        ProductAdapter.ProductHolder productHolder;

        //Lo inicializamos con el objeto que desapareció de pantalla
        View view = convertView;


        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            productHolder = new ProductHolder();

            view = inflater.inflate(R.layout.item_product, null);


            productHolder.txvName = (TextView) view.findViewById(R.id.txtV_ProductName);


            //El tag puede parecer el mismo pero es diferente, ya que se crea un nuevo DependencyHolder
            //cada vez.
            view.setTag(productHolder);

        } else {
            productHolder = (ProductAdapter.ProductHolder) view.getTag();
        }

        //Mostrar los datos del arraylist mediante position

        productHolder.txvName.setText(getItem(position).getDescripcion());

        return view;
    }

    class ProductHolder {

        TextView txvName;

    }
}
