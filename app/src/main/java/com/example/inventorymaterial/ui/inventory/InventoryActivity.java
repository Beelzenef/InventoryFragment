package com.example.inventorymaterial.ui.inventory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.inventorymaterial.R;

/**
 * Esta clase carga el interfaz de la activity de Inventory
 * @author Carlos Cruz Domínguez
 */

public class InventoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
    }
}
