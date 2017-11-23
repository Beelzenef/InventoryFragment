package com.example.inventoryfragment.ui.login;

/**
 * Created by usuario on 10/11/17.
 */

public interface LoginInteractor {
    void validateCredentials(String u, String p, OnLoginFinishedListener lp);

    interface OnLoginFinishedListener {
        void onUserEmptyError();
        void onPasswordEmptyError();
        void onPasswordLengthError();
        void onSucess();
        void onUserNotExists();
    }
}
