package com.example.inventoryfragment.ui.sector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import com.example.inventoryfragment.R;
import com.example.inventoryfragment.adapter.SectionAdapter;
import com.example.inventoryfragment.data.db.model.Section;

public class SectorActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SectionAdapter sectionAdapter;

    /// OnClickRecyclerView: integrando el interfaz en la Clase, sin implementación
    private SectionAdapter.OnItemClickListener onItemClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerSection);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_Section);
        setSupportActionBar(toolbar);

        onItemClickListener = new SectionAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Section s) {
                Toast.makeText(SectorActivity.this, "Has pulsado un item", Toast.LENGTH_SHORT)
                        .show();
            }
        };

        if (savedInstanceState != null) {
            sectionAdapter = new SectionAdapter(savedInstanceState.<Section>getParcelableArrayList("seccion"), onItemClickListener);
        }
        else {
            sectionAdapter = new SectionAdapter(onItemClickListener);
        }

        recyclerView.setAdapter(sectionAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflador = getMenuInflater();
        menuInflador.inflate(R.menu.menu_activity_sector, menu);

        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Almaceno las secciones modificadas en la vista y no han sido guardados para visualizarlos
     * en el estado correcto en onCreate()
     *
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelableArrayList("seccion", sectionAdapter.getSectionsModified());

        // Identificar switch
        // Comprobar cambio
        // Comprobar todos los sections
    }
}
