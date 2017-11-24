package com.example.inventoryfragment.ui.dependency;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inventoryfragment.R;
import com.example.inventoryfragment.ui.base.BasePresenter;
import com.example.inventoryfragment.ui.dependency.contract.DetailDependencyContract;

/**
 * Fragment, visualizar una dependencia
 */

public class DetailDependency_Fragment extends Fragment implements DetailDependencyContract.View {

    public static final String TAG = "detailDependency";

    DetailDependencyContract.Presenter presenter;

    public static DetailDependency_Fragment newInstance(Bundle args) {

        DetailDependency_Fragment detailDependency = new DetailDependency_Fragment();

        if (args != null)
        {
            detailDependency.setArguments(args);
        }

        return detailDependency;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dependencydetail_fragment, container, false);

        if (getArguments() != null)
        {

        }

        return rootView;
    }


    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (DetailDependencyContract.Presenter) presenter;
    }
}
