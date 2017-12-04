package com.example.inventoryfragment.ui.dependency.interactor;

import com.example.inventoryfragment.data.db.model.Dependency;

import java.util.List;

/**
 * Created by usuario on 27/11/17.
 */

public interface ListDependencyInteractor {

    interface OnLoadDependencyListener {
        void OnSuccess(List<Dependency> list);
    }

    void loadDependencies();
    void removeDependency(Dependency d);
}
