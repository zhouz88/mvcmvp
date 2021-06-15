package com.example.mvpmvvm.model;

import android.os.Handler;
import android.os.Looper;

public class MainModel implements IModel {
    public void login(final String username, String password, final Callback callback) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.onSuccess(new User(1, "kerwin"));
            }
        }, 2000);
    }
}
