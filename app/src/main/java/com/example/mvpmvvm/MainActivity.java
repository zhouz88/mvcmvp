package com.example.mvpmvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvpmvvm.model.Callback;
import com.example.mvpmvvm.model.MainModel;
import com.example.mvpmvvm.model.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_username;
    private EditText et_password;
    private Button btn_login;
    private MainModel mainModel;

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

        mainModel = new MainModel();
    }


    @Override
    public void onClick(View v) {
        String username = et_username.getText().toString();
        String password = et_password.getText().toString();
        dialog.show();
        mainModel.login(username, password, new Callback() {
            @Override
            public void onSuccess(User user) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(String msg) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}