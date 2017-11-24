package com.example.inventoryfragment.ui.base;

import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;

/**
 * Created by usuario on 24/11/17.
 */

public class BaseFragment extends Fragment {

    public void onError(String msg)
    {
        Snackbar.make(getView().findViewById(android.R.id.content), msg, Snackbar.LENGTH_SHORT).show();
    }

    public void onError (int id)
    {
        Snackbar.make(getView().findViewById(android.R.id.content), getResources().getString(id), Snackbar.LENGTH_SHORT).show();
    }
}
