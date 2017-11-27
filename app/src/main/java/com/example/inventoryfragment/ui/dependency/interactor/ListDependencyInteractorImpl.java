package com.example.inventoryfragment.ui.dependency.interactor;

import com.example.inventoryfragment.db.model.Dependency;
import com.example.inventoryfragment.db.repo.DependencyRepository;

import java.util.List;

/**
 * Created by usuario on 27/11/17.
 */

public class ListDependencyInteractorImpl implements ListDependencyInteractor {

    private ListDependencyInteractor.OnLoadFinishedListener listener;

    public ListDependencyInteractorImpl (ListDependencyInteractor.OnLoadFinishedListener listener)
    {
        this.listener = listener;
    }

    @Override
    public void loadDependencies() {

    }
}
