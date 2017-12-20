package com.example.inventoryfragment.ui.dependency.presenter;

import com.example.inventoryfragment.adapter.DependencyAdapter;
import com.example.inventoryfragment.data.db.model.Dependency;
import com.example.inventoryfragment.ui.dependency.contract.ListDependencyContract;
import com.example.inventoryfragment.ui.dependency.interactor.ListDependencyInteractor;
import com.example.inventoryfragment.ui.dependency.interactor.ListDependencyInteractorImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependencyPresenter implements ListDependencyContract.Presenter, ListDependencyInteractor.OnLoadDependencyListener {

    private ListDependencyContract.View view;
    private ListDependencyInteractorImpl listDependencyInteractor;

    private HashMap<Integer, Boolean> listaItemsSeleccionados;

    public ListDependencyPresenter(ListDependencyContract.View view) {
        this.view = view;
        this.listDependencyInteractor = new ListDependencyInteractorImpl(this);
        listaItemsSeleccionados = new HashMap<>();
    }


    @Override
    public void OnSuccess(List<Dependency> list) {
        view.showDependencies(list);
    }

    @Override
    public void loadDependencies() {
        listDependencyInteractor.loadDependencies();
    }

    @Override
    public void removeItem(Dependency d) {
        listDependencyInteractor.removeDependency(d);
    }

    @Override
    public void onDestroy() {
        view = null;
        listDependencyInteractor = null;
    }


    // ActionBarContextMode: Métodos para gestionar lista multiseleccionable

    // Método que elimina elementos seleccionados en el mapa
    @Override
    public void deleteSelection(DependencyAdapter adapter) {

        Set<Integer> posicionesSeleccionados = listaItemsSeleccionados.keySet();

        ArrayList<Dependency> dependenciasABorrar = new ArrayList<>();

        // Recogiendo los items a borrar de Clase Dependency:
        for (Iterator<Integer> iterador = posicionesSeleccionados.iterator(); iterador.hasNext(); )
        {
            dependenciasABorrar.add(adapter.getItem(iterador.next()));
        }

        // Una vez recogidas todas las instancias que hay que borrar, interactor borra todas ellas:
        for (int i = 0; i < dependenciasABorrar.size(); i++) {
            listDependencyInteractor.removeDependency(dependenciasABorrar.get(i));
        }

        loadDependencies();
    }

    @Override
    public void setNewSelection(int position) {
        listaItemsSeleccionados.put(position, true);
    }

    @Override
    public void removeSelection(int position) {
        listaItemsSeleccionados.remove(position);
    }

    @Override
    public void clearSelection() {
        listaItemsSeleccionados.clear();
    }

    // ¿Existe el elemento en el mapa?
    @Override
    public boolean isPositionChecked(int position) {
        return listaItemsSeleccionados.get(position) != null;
    }
}
