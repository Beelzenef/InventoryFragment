package com.example.inventoryfragment.ui.dependency.presenter;

import com.example.inventoryfragment.db.model.Dependency;
import com.example.inventoryfragment.ui.dependency.contract.ListDependencyContract;
import com.example.inventoryfragment.ui.dependency.interactor.ListDependencyInteractor;
import com.example.inventoryfragment.ui.dependency.interactor.ListDependencyInteractorImpl;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependencyPresenter implements ListDependencyContract.Presenter, ListDependencyInteractor.OnLoadDependencyListener {

    private ListDependencyContract.View view;
    private ListDependencyInteractorImpl listDependencyInteractor;

    public ListDependencyPresenter(ListDependencyContract.View view) {
        this.view = view;
        this.listDependencyInteractor = new ListDependencyInteractorImpl(this);
    }


    @Override
    public void OnSuccess(List<Dependency> list) {
        view.showDependencies(list);
    }

    @Override
    public void loadDependencies() {
        listDependencyInteractor.loadDependencies();
    }

    @Override
    public void removeItem(Dependency d) {
        listDependencyInteractor.removeDependency(d);
    }

    @Override
    public void onDestroy() {
        view = null;
        listDependencyInteractor = null;
    }
}
