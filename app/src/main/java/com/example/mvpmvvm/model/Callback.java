package com.example.mvpmvvm.model;

public interface Callback {
    void onSuccess(User user);
    void onFailure(String msg);
}
