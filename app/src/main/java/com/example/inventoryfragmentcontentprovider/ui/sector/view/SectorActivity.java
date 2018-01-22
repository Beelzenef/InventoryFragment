package com.example.inventoryfragmentcontentprovider.ui.sector.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import com.example.inventoryfragmentcontentprovider.R;
import com.example.inventoryfragmentcontentprovider.adapter.SectorAdapter;
import com.example.inventoryfragmentcontentprovider.data.db.model.Sector;
import com.example.inventoryfragmentcontentprovider.ui.sector.contract.ContractSector;
import com.example.inventoryfragmentcontentprovider.ui.sector.presenter.SectorPresenter;

public class SectorActivity extends AppCompatActivity implements ContractSector.View {

    private RecyclerView recyclerSector;
    private SectorAdapter sectorAdapter;
    private ContractSector.Presenter presenter;
    //No implementamos la interfaz porque no queremos que la activity sea el escuchador, sino que este sea independiente.
    private SectorAdapter.OnItemClickListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector);

        presenter = new SectorPresenter(this);

        recyclerSector = (RecyclerView) findViewById(R.id.rcvwSector);
        //Le decimos que layout va a usar para repartir los elementos en el interior del RecyclerView mediante un
        //GridLayoutManager.
        recyclerSector.setLayoutManager(new GridLayoutManager(this, 2, 1, false));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listener = new SectorAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Sector sector) {
                Toast.makeText(SectorActivity.this, "Se ha pulsado " + sector.get_name(), Toast.LENGTH_SHORT).show();
            }
        };
        //if (savedInstanceState != null) {
        //    sectorAdapter = new SectorAdapter(savedInstanceState.<Sector>getParcelableArrayList("sector"));
        //} else {
        sectorAdapter = new SectorAdapter(listener);
        //}

        //En MVP lo hacemos desde el metodo de la interfaz setAdapter.
        //recyclerSector.setAdapter(sectorAdapter);

        //Pedimos el adapter al presenter
        presenter.RequestAdapter(listener);

    }

    //Cargamos el menu.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity_sector,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Almaceno los sectores que se han modificado en la vista y no han sido guardados para visualizar
    //el estado correcto en OnCreate()
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("sector", sectorAdapter.getSectorsModified());
    }

    @Override
    public void setAdapter(SectorAdapter adapter) {
        recyclerSector.setAdapter(adapter);
    }
}