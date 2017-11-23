package com.example.inventoryfragment.ui.dependency;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.inventoryfragment.R;
import com.example.inventoryfragment.adapter.DependencyAdapter;
import com.example.inventoryfragment.db.model.Dependency;
import com.example.inventoryfragment.db.repo.DependencyRepository;

/**
 * Clase para gestionar las adapter en una lista
 * @author Elena G (Beelzenef)
 */
public class DependencyActivity extends AppCompatActivity {

    private ArrayAdapter<Dependency> adapter;
    private ListView listView;
    private FloatingActionButton fab;
    private CoordinatorLayout coord_lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);

        // Caso 1, adapter no personalizado
        // Agregando lista de adapter con InventoryApplication, que contiene el array de Dependencias
        // Estamos mezclando Application con Dependency, MALA SOLUCION, vía rápida pero mala
        adapter = new ArrayAdapter<Dependency>(this, android.R.layout.simple_list_item_1,
                DependencyRepository.getInstance().getDependencies());

        // Añadiendo toolbar:
        listView = (ListView) findViewById(android.R.id.list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_Dependency);
        // Tomando coordinatorLayout:
        coord_lista = (CoordinatorLayout) findViewById(R.id.coord_lista);
        // Tomando boton
        fab = (FloatingActionButton) findViewById(R.id.fab_dependency);
        // Al pulsar sobre el boton, se visualiza snackbar y boton se desplaza hacia arriba,
        // empujado por el snackbar
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DependencyActivity.this, AddDependencyActivity.class));
                //Snackbar.make(coord_lista, "Ejemplo Snackbar", Snackbar.LENGTH_SHORT).show();
            }
        });

        setSupportActionBar(toolbar);
        // Caso 2 A, adapter personalizado
        adapter = new DependencyAdapter(this);
        listView.setAdapter(adapter);
    }
}
