package com.example.inventoryfragment.ui.dependency.contract;

import com.example.inventoryfragment.data.db.model.Dependency;
import com.example.inventoryfragment.ui.base.BasePresenter;
import com.example.inventoryfragment.ui.base.BaseView;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public interface ListDependencyContract {

    interface View extends BaseView {
        void showDependencies(List<Dependency> list);
    }

    interface Presenter extends BasePresenter {
        void loadDependencies();
        void removeItem(Dependency d);
    }
}
