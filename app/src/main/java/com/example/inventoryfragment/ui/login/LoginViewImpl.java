package com.example.inventoryfragment.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.inventoryfragment.ui.DashboardActivity;
import com.example.inventoryfragment.R;
import com.example.inventoryfragment.ui.base.BaseActivity;

/**
 *  Activity de Login con diversas redes sociales. Dirige al Dashboard
 *
 *  @author Elena G (Beelzenef)
 */
public class LoginViewImpl extends BaseActivity implements LoginView {

    private Button btn_SignIn;

    private LoginPresenter loginPresenter;

    EditText edT_User;
    EditText edT_Password;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.onDestroy();
        loginPresenter = null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edT_Password = (EditText) findViewById(R.id.edT_Passw);
        edT_User = (EditText) findViewById(R.id.edT_User);

        loginPresenter = new LoginPresenterImpl(this);

        btn_SignIn = (Button) findViewById(R.id.btn_SignIn);
        btn_SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.validateCredentials(edT_User.getText().toString(), edT_Password.getText().toString());
            }
        });
    }

    @Override
    public void navigateToHome() {
        Intent unIntent = new Intent(LoginViewImpl.this, DashboardActivity.class);
        startActivity(unIntent);
    }

    @Override
    public void setUserEmptyError() {
        onError(R.string.userEmptyError);
    }

    @Override
    public void setPasswordEmptyError() {
        onError(R.string.passwordEmptyError);
    }

    @Override
    public void setPasswordError() {
        onError(R.string.passwordLengthError);
    }

    @Override
    public void onUserNotExists()
    {
        onError(R.string.userNotExists);
    }
}
