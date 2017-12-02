package com.example.inventoryfragment.ui.dependency.interactor;

import com.example.inventoryfragment.db.model.Dependency;
import com.example.inventoryfragment.db.repo.DependencyRepository;

import java.util.List;

/**
 * Created by usuario on 27/11/17.
 */

public class ListDependencyInteractorImpl implements ListDependencyInteractor {

    ListDependencyInteractor.OnLoadDependencyListener listener;

    public ListDependencyInteractorImpl(ListDependencyInteractor.OnLoadDependencyListener listener)
    {
        this.listener = listener;
    }

    @Override
    public void loadDependencies() {
        listener.OnSuccess(DependencyRepository.getInstance().getDependencies());
    }

    @Override
    public void removeDependency(Dependency d) {
        DependencyRepository.getInstance().deleteDependency(d);
        loadDependencies();
    }
}