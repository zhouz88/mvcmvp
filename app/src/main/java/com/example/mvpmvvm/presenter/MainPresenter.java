package com.example.mvpmvvm.presenter;

import com.example.mvpmvvm.IView;
import com.example.mvpmvvm.model.Callback;
import com.example.mvpmvvm.model.MainModel;
import com.example.mvpmvvm.model.User;

public class MainPresenter implements IPresenter, Callback {
    private MainModel mainModel;
    private IView mainView;

    public MainPresenter(IView mainView) {
        mainModel = new MainModel();
        this.mainView = mainView;
    }

    @Override
    public void login(String username, String password) {
        mainView.showProgress();
        mainModel.login(username, password, this);
    }

    @Override
    public void onSuccess(User user) {
        mainView.hideProgress();
        mainView.loginSuccess();
    }

    @Override
    public void onFailure(String msg) {
        mainView.hideProgress();
        mainView.loginFailure();
    }
}
