package com.example.inventoryfragment.ui.dependency.presenter;

import com.example.inventoryfragment.ui.dependency.contract.AddEditDependencyContract;
import com.example.inventoryfragment.ui.dependency.contract.DetailDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class DetailDependencyPresenter implements DetailDependencyContract.Presenter {

    DetailDependencyContract.View view;

    public DetailDependencyPresenter (DetailDependencyContract.View view)
    {
        this.view = view;
    }

    @Override
    public void onDestroy() {
        view = null;
    }
}
