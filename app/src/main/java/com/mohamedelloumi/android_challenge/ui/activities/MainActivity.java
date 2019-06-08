package com.mohamedelloumi.android_challenge.ui.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.mohamedelloumi.android_challenge.ApplicationContext;
import com.mohamedelloumi.android_challenge.R;
import com.mohamedelloumi.android_challenge.ui.fragments.FirstScreenFragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApplicationContext.getInstance().init(this);
        // add first screen fragment
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        FirstScreenFragment firstScreenFragment = new FirstScreenFragment();
        fragmentTransaction.add(R.id.container, firstScreenFragment);
        fragmentTransaction.commit();
    }
}
