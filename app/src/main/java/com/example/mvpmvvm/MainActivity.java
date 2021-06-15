package com.example.mvpmvvm;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvpmvvm.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, IView {
    private EditText et_username;
    private EditText et_password;
    private Button btn_login;
    private MainPresenter mainPresenter;

    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_username = findViewById(R.id.edit1);
        et_password = findViewById(R.id.edit2);
        btn_login = findViewById(R.id.button);
        btn_login.setOnClickListener(this);
        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setCancelable(false);
        dialog.setMessage("Please wait....");

        mainPresenter = new MainPresenter(this);
    }

    @Override
    public void onClick(View v) {
        String username = et_username.getText().toString();
        String password = et_password.getText().toString();
        dialog.show();
        mainPresenter.login(username, password);
    }

    @Override
    public void showProgress() {
        dialog.show();
    }

    @Override
    public void hideProgress() {
        dialog.dismiss();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginFailure() {
        Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_LONG).show();
    }
}