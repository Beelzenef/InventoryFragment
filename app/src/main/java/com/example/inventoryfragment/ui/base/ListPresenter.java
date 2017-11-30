package com.example.inventoryfragment.ui.base;

/**
 * Created by usuario on 30/11/17.
 */

public interface ListPresenter extends BasePresenter {

    void removeItem(int position);
    void confirmRemoving(int position);
}
