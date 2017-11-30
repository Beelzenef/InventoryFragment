package com.example.inventoryfragment.ui.dependency.interactor;

import com.example.inventoryfragment.db.model.Dependency;
import com.example.inventoryfragment.db.repo.DependencyRepository;

import java.util.List;

/**
 * Created by usuario on 27/11/17.
 */

public interface ListDependencyInteractor {

    interface OnLoadDependencyListener {
        void OnSuccess(List<Dependency> list);
    }

    void loadDependencies();
    void addNewDependency(String name, String shortname, String desc);
    void removeDependency(int position);
}
