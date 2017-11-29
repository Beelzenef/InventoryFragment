package com.example.inventoryfragment.ui.dependency;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.example.inventoryfragment.R;
import com.example.inventoryfragment.db.model.Dependency;
import com.example.inventoryfragment.ui.base.BaseActivity;
import com.example.inventoryfragment.ui.dependency.presenter.AddEditDependencyPresenter;
import com.example.inventoryfragment.ui.dependency.presenter.DetailDependencyPresenter;
import com.example.inventoryfragment.ui.dependency.presenter.ListDependencyPresenter;

/**
 * Clase para gestionar las adapter en una lista
 * @author Elena G (Beelzenef)
 */
public class DependencyActivity extends BaseActivity implements ListDependency_Fragment.ListDependencyListener, AddEditDependency_Fragment.AddNewDependencyClickListener {

    private ListDependency_Fragment listDependency;
    private ListDependencyPresenter listPresenter;

    private AddEditDependency_Fragment addeditDependency;
    private AddEditDependencyPresenter addeditPresenter;

    private DetailDependency_Fragment detailDependency;
    private DetailDependencyPresenter detailDependencyPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // 1. Creando la vista
        listDependency = (ListDependency_Fragment) fragmentManager.findFragmentByTag(ListDependency_Fragment.TAG);

        if (listDependency == null)
        {
            listDependency = ListDependency_Fragment.newInstance(null);
            fragmentTransaction.add(android.R.id.content, listDependency, ListDependency_Fragment.TAG);
            fragmentTransaction.commit();
        }

        // 2. Creando el presentador, pasando por constructor la vista correspondiente (su fragment)
        listPresenter = new ListDependencyPresenter(listDependency);

        // 3. Si necesitamos, se asigna el presentador a su fragment
        listDependency.setPresenter(listPresenter);
    }

    @Override
    public void addNewDependency(Bundle b) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        // 1. Creando la vista
        addeditDependency = (AddEditDependency_Fragment) fragmentManager.findFragmentByTag(AddEditDependency_Fragment.TAG);

        if (addeditDependency == null) {
            addeditDependency = AddEditDependency_Fragment.newInstance(b);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(android.R.id.content, addeditDependency, AddEditDependency_Fragment.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        // 2. Creando el presentador, pasando por constructor la vista correspondiente (su fragment)
        addeditPresenter = new AddEditDependencyPresenter(addeditDependency);
        // 3. Si necesitamos, se asigna el presentador a su fragment
        addeditDependency.setPresenter(addeditPresenter);
    }

    /*
    @Override
    public void editDependency(int item) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        // 1. Creando la vista
        detailDependency = (DetailDependency_Fragment) fragmentManager.findFragmentByTag(DetailDependency_Fragment.TAG);

        if (detailDependency == null)
        {
            detailDependency = DetailDependency_Fragment.newInstance(null);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(android.R.id.content, detailDependency, DetailDependency_Fragment.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        // 2. Creando el presentador, pasando por constructor la vista correspondiente (su fragment)
        Toast.makeText(this, "Pulsando item en posición " + Integer.toString(item), Toast.LENGTH_SHORT).show();
        detailDependencyPresenter = new DetailDependencyPresenter(detailDependency);
        // 3. Si necesitamos, se asigna el presentador a su fragment
        detailDependency.setPresenter(detailDependencyPresenter);
    }
    */

    @Override
    public void addingNewDependency(Dependency d) {
        listPresenter.addNewDependency(d.getName(), d.getShortname(), d.getDescription());
    }

    @Override
    public void returnToDependencyList() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();
    }
}
