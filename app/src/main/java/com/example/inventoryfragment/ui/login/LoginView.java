package com.example.inventoryfragment.ui.login;

/**
 * Created by usuario on 10/11/17.
 */

public interface LoginView {

    void navigateToHome();

    void setUserEmptyError();

    void setPasswordEmptyError();

    void setPasswordError();

    void onUserNotExists();
}
