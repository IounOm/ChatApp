package com.iounom.chatapp.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import com.iounom.chatapp.R;
import com.iounom.chatapp.ui.fragments.LoginFragment;

public class LoginActivity extends AppCompatActivity {
    private Toolbar mToolbar;

    public static void  startIntent(Context context){
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    public static void  startIntent(Context context, int flags){
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(flags);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindViews();
        init();
    }

    private void bindViews(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void init(){
        setSupportActionBar(mToolbar);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_content_login,
                LoginFragment.newInstance(),
                LoginFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }
}
