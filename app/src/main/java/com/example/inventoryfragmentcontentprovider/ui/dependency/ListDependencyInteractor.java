package com.example.inventoryfragmentcontentprovider.ui.dependency;

import com.example.inventoryfragmentcontentprovider.data.db.model.Dependency;

/**
 *
 */

public interface ListDependencyInteractor {
        void getAllDependencies();
        void deleteDependency(Dependency dependency);
        void orderByName();
        void orderById();
}
