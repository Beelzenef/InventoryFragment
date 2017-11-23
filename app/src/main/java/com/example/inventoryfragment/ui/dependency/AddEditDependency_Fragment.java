package com.example.inventoryfragment.ui.dependency;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inventoryfragment.R;
import com.example.inventoryfragment.ui.dependency.contract.AddEditDependencyContract;

/**
 * Fragment, añadir/editar una dependencia
 */

public class AddEditDependency_Fragment extends Fragment implements AddEditDependencyContract.View {

    public static final String TAG = "addeditDependency";

    AddEditDependencyContract.Presenter presenter;

    public static AddEditDependency_Fragment newInstance(Bundle args) {

        AddEditDependency_Fragment addeditDependency = new AddEditDependency_Fragment();

        if (args != null)
        {
            addeditDependency.setArguments(args);
        }

        return addeditDependency;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dependencyaddedit_fragment, container, false);

        if (getArguments() != null)
        {

        }

        return rootView;
    }

    @Override
    public void setPresenter(AddEditDependencyContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
