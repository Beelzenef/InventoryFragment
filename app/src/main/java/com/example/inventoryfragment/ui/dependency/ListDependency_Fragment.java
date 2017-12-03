package com.example.inventoryfragment.ui.dependency;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.inventoryfragment.R;
import com.example.inventoryfragment.adapter.DependencyAdapter;
import com.example.inventoryfragment.db.model.Dependency;
import com.example.inventoryfragment.ui.base.BasePresenter;
import com.example.inventoryfragment.ui.dependency.contract.ListDependencyContract;
import com.example.inventoryfragment.ui.dependency.presenter.ListDependencyPresenter;
import com.example.inventoryfragment.ui.prefs.OrderSettingsActivity;
import com.example.inventoryfragment.utils.CommonDialog;

import java.util.List;

/**
 * Fragment, lista de dependencias
 */

public class ListDependency_Fragment extends ListFragment implements ListDependencyContract.View {

    public static final String TAG = "listDependency";
    private ListDependencyListener callback;
    private ListDependencyContract.Presenter presenter;

    DependencyAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.adapter = new DependencyAdapter(getActivity());
        setRetainInstance(true);
    }

    /**
     * Menu contextual creado con la pulsación larga sobre un elemento de lista
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getActivity().getMenuInflater().inflate(R.menu.secmenu_frag_listdependencies, menu);
    }

    /**
     * Se implementan las diferentes acciones a realizar en las opciones mostradas en el menu contextual
     * @param item
     * @return
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_listdependency_delete:

                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

                Bundle b = new Bundle();
                b.putParcelable(Dependency.TAG, adapter.getItem(info.position));
                b.putString(CommonDialog.MESSAGE, "¿Desea eliminar la dependencia " +
                        adapter.getItem(info.position).getName() + "?");
                b.putString(CommonDialog.TITLE, "Eliminar dependencia");

                // Confirmacion (?) interna, se elimina la dependencia
                CommonDialog.showConfirmationDialog(b, getActivity(), presenter).show();

                break;

        }

        return super.onContextItemSelected(item);
    }



    @Override
    public void showDependencies(List<Dependency> list) {
        adapter.clear();
        adapter.addAll(list);
    }

    interface ListDependencyListener {

        // Dos acciones que realiza la lista
        void addNewDependency(Bundle b);
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

        // Como el fragment mantiene el estado ( y solo se elimina la vista) se debe reinicializar el presenter
        // cuando se crea la vista
        this.presenter = new ListDependencyPresenter(this);

        // Como estamos en Fragment que inflamos con rootView, usamos rootview para buscar el FAB
        FloatingActionButton fab_Dependencies = (FloatingActionButton) rootView.findViewById(R.id.fab_dependency);
        Toolbar toolBar_dependencies = (Toolbar) rootView.findViewById(R.id.toolbar_Dependency);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolBar_dependencies);

        // Si el FAB se encontrase en el XML de la Activity, buscamos desde la Activity
        //FloatingActionButton fab_Dependencies = (FloatingActionButton) getActivity().findViewById(R.id.fab_dependency);

        fab_Dependencies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.addNewDependency(null);
            }
        });

        // Cargar toda dependencia:

        presenter.loadDependencies();
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
        //setListAdapter(new DependencyAdapter((getActivity())));
        setListAdapter(adapter);

        // Asignamos menu contextual cuando la vista ya se ha creado
        registerForContextMenu(getListView());

        // Cuando la lista está creada, mostrada, es entonces cuando lo obtenemos y le
        // añadimos listener para abrir DetailDependency
        ListView listV_ListaDependencias = (ListView) getListView().findViewById(android.R.id.list);
        listV_ListaDependencias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle b = new Bundle();
                b.putParcelable(Dependency.TAG, (Dependency)parent.getItemAtPosition(position));
                b.putInt("posicion", position);
                callback.addNewDependency(b);
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        adapter = null;
        presenter.onDestroy();
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (ListDependencyContract.Presenter) presenter;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_activity_depsorder, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.action_orderdeps_settings:
                startActivity(new Intent(getActivity(), OrderSettingsActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
