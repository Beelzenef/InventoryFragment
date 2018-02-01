package com.example.inventoryfragmentcontentprovider.data.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.inventoryfragmentcontentprovider.data.db.InventoryContract;
import com.example.inventoryfragmentcontentprovider.data.db.InventoryOpenHelper;
import com.example.inventoryfragmentcontentprovider.data.db.model.Dependency;
import com.example.inventoryfragmentcontentprovider.data.db.model.Product;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductDAO {

    public ArrayList<Product> loadAll() {

        final ArrayList<Product> arrayList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();
        Cursor cursor = sqLiteDatabase.query(InventoryContract.ProductEntry.TABLE_NAME,
                InventoryContract.ProductEntry.ALL_COLUMNS,
                null, null, null, null,
                null, null);

        if (cursor.moveToFirst()) {
            do {
                Product tmp = new Product(cursor.getString(0), cursor.getInt(1), cursor.getInt(2), cursor.getInt(3), cursor.getInt(4));
                arrayList.add(tmp);
            } while (cursor.moveToNext());
        }

        InventoryOpenHelper.getInstance().closeDatabase();


        return arrayList;
    }
}

