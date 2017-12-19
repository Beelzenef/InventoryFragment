package com.example.inventoryfragment.data.prefs;

import android.content.SharedPreferences;

import com.example.inventoryfragment.ui.inventory.InventoryApplication;
import com.example.inventoryfragment.utils.AppConstants;

/**
 * Created by usuario on 4/12/17.
 */

public class AppPreferencesHelper implements AccountPreferencesHelper {

    // 1) Se definen todas las KEY posibles del fichero de preferencias
    // Obtenidas por Interface

    // Instancia para editar las preferencias

    private static final SharedPreferences editorPreferencias = null;
    private static AppPreferencesHelper instance;

    private AppPreferencesHelper()
    {
        //editorPreferencias = InventoryApplication.getContext().getDefaultSharedPreferences();
    }



    /**
     * Metodo de acceso a la instancia, efecto Singleton
     * @return
     */
    public static AppPreferencesHelper getInstance()
    {
        if (instance == null)
        {
            instance = new AppPreferencesHelper();
        }
        return instance;
    }

    public long getPrefKeyCurrentUserId() {
        long id = editorPreferencias.getLong(PREF_KEY_CURRENT_USER_ID, AppConstants.NULL_INDEX);
        return id;
    }

    public void setPrefKeyCurrentUserId(long id) {
        editorPreferencias.edit().putLong(PREF_KEY_CURRENT_USER_ID, id).apply();
    }

    public String getPrefKeyCurrentUserName() {
        String name = editorPreferencias.getString(PREF_KEY_CURRENT_USER_NAME, null);
        return name;
    }

    public void setPrefKeyCurrentUserName(String name) {
        editorPreferencias.edit().putString(PREF_KEY_CURRENT_USER_NAME, name).apply();
    }

    public boolean getPrefKeyCurrentUserRem() {
        boolean rememberMe = editorPreferencias.getBoolean(PREF_KEY_CURRENT_USER_NAME, false);
        return rememberMe;
    }

    public void setPrefKeyCurrentUserRem(boolean rememberMe) {
        editorPreferencias.edit().putBoolean(PREF_KEY_CURRENT_USER_REM, rememberMe).apply();
    }


}
