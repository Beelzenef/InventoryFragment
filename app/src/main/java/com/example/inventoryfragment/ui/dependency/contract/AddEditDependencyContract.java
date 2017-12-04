package com.example.inventoryfragment.ui.dependency.contract;

import com.example.inventoryfragment.data.db.model.Dependency;
import com.example.inventoryfragment.ui.base.BasePresenter;
import com.example.inventoryfragment.ui.base.BaseView;

/**
 * Created by usuario on 23/11/17.
 */

public interface AddEditDependencyContract {

    interface View extends BaseView {

        void setNameError();
        void setDescError();
        void setShortnameError();
        void addingCorrectDependency();
    }

    interface Presenter extends BasePresenter {

        void validateDependency(String name, String shortname, String desc);
        void addNewDependency(String name, String shortname, String desc);
        void editDependency(Dependency d);
    }
}
