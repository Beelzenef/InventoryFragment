package com.example.inventoryfragment.ui.dependency.presenter;

import android.widget.Toast;

import com.example.inventoryfragment.ui.dependency.AddEditDependency_Fragment;
import com.example.inventoryfragment.ui.dependency.DetailDependency_Fragment;
import com.example.inventoryfragment.ui.dependency.contract.AddEditDependencyContract;
import com.example.inventoryfragment.ui.dependency.interactor.AddEditDependencyInteractor;
import com.example.inventoryfragment.ui.dependency.interactor.AddEditDependencyInteractorImpl;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependencyPresenter implements AddEditDependencyContract.Presenter, AddEditDependencyInteractor.onDependencyAddingListener {

    AddEditDependencyContract.View view;
    AddEditDependencyInteractor interactor;

    public AddEditDependencyPresenter (AddEditDependencyContract.View view)
    {
        this.view = view;
        interactor = new AddEditDependencyInteractorImpl();
    }

    @Override
    public void validateDependency(String name, String shortname, String desc) {
        interactor.validateDependency(name, shortname, desc, this);
    }

    @Override
    public void onNameEmpty() {
       view.setNameError();
    }

    @Override
    public void onShortNameEmpty() {
        view.setShortnameError();
    }

    @Override
    public void onDescEmpty() {
        view.setDescError();
    }

    @Override
    public void onSuccess() {
        view.addingCorrectDependency();
    }
}
