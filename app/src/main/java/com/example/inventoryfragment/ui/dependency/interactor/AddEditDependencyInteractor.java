package com.example.inventoryfragment.ui.dependency.interactor;

/**
 * Created by usuario on 24/11/17.
 */

public interface AddEditDependencyInteractor {

    void validateDependency(String name, String shortname, String desc, onDependencyAddingListener daL);

    interface onDependencyAddingListener
    {
        void onNameEmpty();
        void onShortNameEmpty();
        void onDescEmpty();
        void onSuccess();
    }
}
