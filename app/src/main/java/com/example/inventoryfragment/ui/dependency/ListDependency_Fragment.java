package com.example.inventoryfragment.ui.dependency;

import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.inventoryfragment.R;
import com.example.inventoryfragment.adapter.DependencyAdapter;
import com.example.inventoryfragment.ui.dependency.contract.ListDependencyContract;

/**
 * Fragment, lista de dependencias
 */

public class ListDependency_Fragment extends ListFragment implements ListDependencyContract.View {

    public static final String TAG = "listDependency";
    private ListDependencyListener callback;
    private ListDependencyContract.Presenter presenter;

    interface ListDependencyListener {

        // Dos acciones que realiza la lista
        void addNewDependency();
        void editDependency(int item);
    }

    public static ListDependency_Fragment newInstance(Bundle args) {

        ListDependency_Fragment listDependency = new ListDependency_Fragment();

        if (args != null)
        {
            listDependency.setArguments(args);
        }

        return listDependency;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.dependencylist_fragment, container, false);

        // Como estamos en Fragment que inflamos con rootView, usamos rootview para buscar el FAB
        FloatingActionButton fab_Dependencies = (FloatingActionButton) rootView.findViewById(R.id.fab_dependency);

        // Si el FAB se encontrase en el XML de la Activity, buscamos desde la Activity
        //FloatingActionButton fab_Dependencies = (FloatingActionButton) getActivity().findViewById(R.id.fab_dependency);

        fab_Dependencies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.addNewDependency();
            }
        });

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            callback = (ListDependencyListener) activity;
        } catch (ClassCastException e)
        {
            throw new ClassCastException(getActivity().getLocalClassName() + " must be implemented");
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListAdapter(new DependencyAdapter((getActivity())));

        // Cuando la lista está creada, mostrada, es entonces cuando lo obtenemos y le
        // añadimos listener para abrir DetailDependency
        ListView listV_ListaDependencias = (ListView) getListView().findViewById(android.R.id.list);
        listV_ListaDependencias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                callback.editDependency(position);
            }
        });
    }

    @Override
    public void setPresenter(ListDependencyContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
