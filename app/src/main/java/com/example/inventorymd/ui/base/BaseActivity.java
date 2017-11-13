package com.example.inventorymd.ui.base;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.inventorymd.R;

public class BaseActivity extends AppCompatActivity {

    public void onError(String msg)
    {
        Snackbar.make(findViewById(android.R.id.content), msg, Snackbar.LENGTH_SHORT).show();
    }

    public void onError (int id)
    {
        Snackbar.make(findViewById(android.R.id.content), getResources().getString(id), Snackbar.LENGTH_SHORT).show();
    }
}
