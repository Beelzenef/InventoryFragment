package com.example.inventoryfragment.ui.dependency.interactor;

import android.text.TextUtils;

/**
 * Created by usuario on 24/11/17.
 */

public class AddEditDependencyInteractorImpl implements AddEditDependencyInteractor {

    @Override
    public void validateDependency(String name, String shortname, String desc, onDependencyAddingListener daL) {

        if (TextUtils.isEmpty(name))
            daL.onNameEmpty();
        else if (TextUtils.isEmpty(shortname))
            daL.onShortNameEmpty();
        else if (TextUtils.isEmpty(desc))
            daL.onDescEmpty();
        else
            daL.onSuccess();
    }
}
