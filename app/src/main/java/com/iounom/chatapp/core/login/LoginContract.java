package com.iounom.chatapp.core.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.Nullable;

/**
 * Author: Kartik Sharma
 * Created on: 8/28/2016 , 11:06 AM
 * Project: FirebaseChat
 */

public interface LoginContract {
    interface View {
        @Nullable android.view.View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

        void onLoginSuccess(String message);

        void onLoginFailure(String message);
    }

    interface Presenter {
        void login(Activity activity, String email, String password);
    }

    interface Interactor {
        void performFirebaseLogin(Activity activity, String email, String password);
    }

    interface OnLoginListener {
        void onSuccess(String message);

        void onFailure(String message);
    }
}
