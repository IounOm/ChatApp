package com.iounom.chatapp.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.database.core.Constants;
import com.iounom.chatapp.R;
import com.iounom.chatapp.ui.fragments.ChatFragment;

public class ChatActivity extends AppCompatActivity {
    private Toolbar mToolbar;

    public static void startActivity(Context context,
                                     String receiver,
                                     String receiverUid,
                                     String firebaseToken){
        Intent intent = new Intent(context, ChatActivity.class);
        intent.putExtra(String.valueOf(Constants.DOT_INFO), receiver);
        intent.putExtra(String.valueOf(Constants.DOT_INFO_AUTHENTICATED), receiverUid);
        intent.putExtra(String.valueOf(Constants.DOT_INFO_CONNECTED), firebaseToken);
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

        mToolbar.setTitle(getIntent().getExtras().getString(String.valueOf(Constants.DOT_INFO)));

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_content_chat,
                ChatFragment.newInstance(getIntent().getExtras().getString(String.valueOf(Constants.DOT_INFO)),
                        getIntent().getExtras().getString(String.valueOf(Constants.DOT_INFO_AUTHENTICATED)),
                        getIntent().getExtras().getString(String.valueOf(Constants.DOT_INFO_CONNECTED))),
                ChatFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }
}
