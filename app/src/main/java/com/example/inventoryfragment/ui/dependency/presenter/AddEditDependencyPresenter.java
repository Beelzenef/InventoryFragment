package com.example.inventoryfragment.ui.dependency.presenter;

import com.example.inventoryfragment.ui.dependency.DetailDependency_Fragment;
import com.example.inventoryfragment.ui.dependency.contract.AddEditDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependencyPresenter implements AddEditDependencyContract.Presenter {

    AddEditDependencyContract.View view;

    public AddEditDependencyPresenter (AddEditDependencyContract.View view)
    {
        this.view = view;
    }
}
