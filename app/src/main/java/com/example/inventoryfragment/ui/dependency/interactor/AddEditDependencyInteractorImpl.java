package com.example.inventoryfragment.ui.dependency.interactor;

import android.text.TextUtils;

import com.example.inventoryfragment.data.db.model.Dependency;
import com.example.inventoryfragment.data.db.repo.DependencyRepository;

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

    @Override
    public void addNewDependency(String name, String shortname, String desc) {
        DependencyRepository.getInstance().addDependency(new Dependency(0, name, shortname, desc));
    }

    @Override
    public void updateDependency(Dependency d) {
        DependencyRepository.getInstance().editDependency(d);
    }
}
