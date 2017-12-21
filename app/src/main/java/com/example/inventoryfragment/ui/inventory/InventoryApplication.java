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
    private static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
    }

    public InventoryApplication() {
            this.context = getApplicationContext();
    }

    public AppPreferencesHelper getAppPreferencesHelper()
    {
        return appPreferencesHelper;
    }

    public static Context getContext() {
        return context;
    }

    public AppPreferencesHelper getDefaultSharedPreferences()
    {
        return appPreferencesHelper;
    }
}
