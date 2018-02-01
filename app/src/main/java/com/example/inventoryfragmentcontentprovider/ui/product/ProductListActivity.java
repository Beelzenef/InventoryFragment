package com.example.inventoryfragmentcontentprovider.ui.product;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.inventoryfragmentcontentprovider.R;
import com.example.inventoryfragmentcontentprovider.adapter.ProductAdapter;
import com.example.inventoryfragmentcontentprovider.data.db.dao.ProductDAO;
import com.example.inventoryfragmentcontentprovider.data.db.model.Product;

public class ProductListActivity extends AppCompatActivity {

    private ListView listaProductos;
    private ProductAdapter adapter;

    private ProductDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        adapter = new ProductAdapter(this);

        dao = new ProductDAO();

        listaProductos = (ListView) findViewById(android.R.id.list);

        listaProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /*
                Product p = (Product) adapterView.getItemAtPosition(i);
                Bundle b = new Bundle();
                b.putParcelable("P", (Product) adapterView.getItemAtPosition(i));
                Intent intent = new Intent(ProductListActivity.this, ProductActivity.class);
                intent.putExtra("Bundle", b);
                startActivity(intent);
                */
                showMsg("Has pulsado un item");
            }
        });

        adapter.addAll(dao.loadAll());
        listaProductos.setAdapter(adapter);

    }


    private void showMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
