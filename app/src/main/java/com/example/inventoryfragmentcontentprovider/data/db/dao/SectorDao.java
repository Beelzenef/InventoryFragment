package com.example.inventoryfragmentcontentprovider.data.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.example.inventoryfragmentcontentprovider.data.db.InventoryContract;
import com.example.inventoryfragmentcontentprovider.data.db.InventoryOpenHelper;
import com.example.inventoryfragmentcontentprovider.data.db.model.Sector;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 */

public class SectorDao {

    public ArrayList<Sector> loadAll () {
        ArrayList<Sector> listaSectores = new ArrayList<>();

        SQLiteDatabase db = InventoryOpenHelper.getInstance().openDatabase();
        Cursor c = db.query(InventoryContract.SectorEntry.TABLE_NAME,
                InventoryContract.SectorEntry.ALL_COLUMNS,
                null, null, null,null,
                null, null);

        if (c.moveToFirst()) {
            while (c.moveToNext()) {
                Sector s = new Sector(c.getInt(0), c.getString(1), c.getString(2),
                        c.getString(3), c.getInt(4), false, false);
                listaSectores.add(s);
            }
        }

        db.close();

        return listaSectores;
    }

    public long save(Sector s) {
        SQLiteDatabase db = InventoryOpenHelper.getInstance().openDatabase();

        long filasAfectadas = db.insert(InventoryContract.SectorEntry.TABLE_NAME,
                null, genContentValues(s));

        db.close();
        return filasAfectadas;
    }

    public long update(Sector s) {
        SQLiteDatabase db = InventoryOpenHelper.getInstance().openDatabase();

        long filasAfectadas = db.update(InventoryContract.SectorEntry.TABLE_NAME,
                genContentValues(s), BaseColumns._ID + "=" + s.get_name(), null);

        db.close();
        return filasAfectadas;
    }

    public long delete(Sector s) {
        SQLiteDatabase db = InventoryOpenHelper.getInstance().openDatabase();

        long filasAfectadas = db.delete(InventoryContract.SectorEntry.TABLE_NAME,
                BaseColumns._ID + "=" + s.get_name(), null);

        db.close();
        return filasAfectadas;
    }

    private ContentValues genContentValues(Sector s) {

        ContentValues cV = new ContentValues();
        cV.put(InventoryContract.SectorEntry.COLUMN_DEPENDENCYID, s.get_dependencyId());
        cV.put(InventoryContract.SectorEntry.COLUMN_NAME, s.get_name());
        cV.put(InventoryContract.SectorEntry.COLUMN_SHORTNAME, s.get_shortname());
        cV.put(InventoryContract.SectorEntry.COLUMN_DESCRIPTION, s.get_description());

        return cV;
    }
}
