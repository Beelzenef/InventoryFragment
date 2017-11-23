package com.example.inventoryfragment.ui.login;

/**
 * Created by usuario on 10/11/17.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractorImpl loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        loginInteractor = new LoginInteractorImpl();
    }


    @Override
    public void validateCredentials(String user, String passw) {
        loginInteractor.validateCredentials(user, passw, this);
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
    public void onPasswordLengthError() {
        loginView.setPasswordError();
    }

    @Override
    public void onSucess() {
        loginView.navigateToHome();
    }

    @Override
    public void onUserNotExists() {
        loginView.onUserNotExists();
    }

    @Override
    public void onDestroy() {
        loginView = null;
        loginInteractor = null;
    }
}
