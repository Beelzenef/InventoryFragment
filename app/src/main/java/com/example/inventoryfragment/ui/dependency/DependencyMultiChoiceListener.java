package com.example.inventoryfragment.ui.dependency;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;

import com.example.inventoryfragment.R;
import com.example.inventoryfragment.adapter.DependencyAdapter;
import com.example.inventoryfragment.ui.dependency.contract.ListDependencyContract;
import com.example.inventoryfragment.ui.dependency.presenter.ListDependencyPresenter;

/**
 * Created by usuario on 18/12/17.
 */

class DependencyMultiChoiceListener implements AbsListView.MultiChoiceModeListener {

    private ListDependencyContract.Presenter presenter;
    private DependencyAdapter adapter;
    private int count;


    public DependencyMultiChoiceListener (ListDependencyContract.Presenter p, DependencyAdapter a)
    {
        this.presenter = p;
        this.adapter = a;
    }

    // Cuando se seleccionan diferentes elementos
    @Override
    public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

        // Cambiar estilos cuando se marca o desmarca

        if (checked) {
            count++;
            presenter.setNewSelection(position);
        }
            else
        {
            count--;
            presenter.removeSelection(position);
        }
        mode.setTitle(Integer.toString(count) + " seleccionados");
    }

    // Creacion de Action Mode la primera y única vez
    // Aquí se inicializa la bar
    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        // Inflamos un menú que aparecerá en la barra, para que además de modificar título muestre
        // la opción de eliminar items
        MenuInflater inflador = mode.getMenuInflater();
        inflador.inflate(R.menu.secmenu_frag_listdependencies, menu);
        mode.setTitle("Iniciando actionMode");
        return true;
    }

    // Se ejecuta antes de modificar la toolbar
    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    // Cuando se pulsa sobre un elemento
    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_listdependency_delete:
                presenter.deleteSelection();
                presenter.loadDependencies();
                break;
        }

        mode.finish();
        return true;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        count = 0;
        presenter.clearSelection();
    }
}
