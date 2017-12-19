package com.example.inventoryfragment.ui.inventory;

import android.app.Application;
import android.content.Context;

import com.example.inventoryfragment.data.prefs.AccountPreferencesHelper;
import com.example.inventoryfragment.data.prefs.AppPreferencesHelper;

/**
 *
 * @author Elena G (Beelzenef)
 */

public class InventoryApplication extends Application {

    private AppPreferencesHelper appPreferencesHelper;
    private Context context;


    @Override
    public void onCreate() {
        super.onCreate();
    }

    public InventoryApplication() {
            //appPreferencesHelper = AppPreferencesHelper.getInstance();
    }

    public AppPreferencesHelper getAppPreferencesHelper()
    {
        return appPreferencesHelper;
    }

    public void getContext() {
        context = getApplicationContext();
    }

    /*public AppPreferencesHelper getDefaultSharedPreferences()
    {
        return InventoryApplication.context.getSharedPreferences("Inventory_pref", MODE_PRIVATE);
    }*/
}
