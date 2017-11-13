package com.example.inventorymaterial.ui.login;

import android.support.annotation.StringRes;

/**
 * Implementación del de la interfaz del presentador.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener{
     private LoginView loginView;
     private LoginInteractorImpl loginInteractor;


    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String user, String password) {
        loginInteractor.validateCredentials(user, password, this);


    }

    @Override
    public void onDestroy() {
        loginView = null;
        loginInteractor = null;
    }

    @Override
    public void onUserEmptyError() {
        loginView.setUserEmptyError();
    }

    @Override
    public void onPasswordEmptyError() {
        loginView.setPasswordEmptyError();
    }

    @Override
    public void onPasswordError() {
        loginView.setPasswordError();
    }
}
