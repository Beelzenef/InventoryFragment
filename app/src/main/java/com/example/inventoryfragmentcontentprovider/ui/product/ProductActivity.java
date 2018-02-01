package com.example.inventoryfragmentcontentprovider.ui.product;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.inventoryfragmentcontentprovider.R;
import com.example.inventoryfragmentcontentprovider.data.db.model.Product;

/**
 * Esta clase carga el interfaz de la activity de Product
 * @author Carlos Cruz Domínguez
 */

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Product p = getIntent().getExtras().getParcelable("P");
    }
}
