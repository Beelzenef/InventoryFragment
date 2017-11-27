package com.example.inventoryfragment.ui.dependency.interactor;

/**
 * Created by usuario on 27/11/17.
 */

public interface ListDependencyInteractor {

    interface OnLoadFinishedListener {
        void onSucess();
    }

    void loadDependencies();
}
