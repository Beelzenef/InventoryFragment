package com.example.inventoryfragment.ui.dependency.interactor;

import com.example.inventoryfragment.db.model.Dependency;

/**
 * Created by usuario on 24/11/17.
 */

public interface AddEditDependencyInteractor {

    void validateDependency(String name, String shortname, String desc, onDependencyAddingListener daL);
    void addNewDependency(String name, String shortname, String desc);
    void updateDependency(Dependency d);

    interface onDependencyAddingListener
    {
        void onNameEmpty();
        void onShortNameEmpty();
        void onDescEmpty();
        void onSuccess();
    }
}
