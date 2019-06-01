package com.mohamedelloumi.android_challenge.ui.activities;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mohamedelloumi.android_challenge.R;
import com.mohamedelloumi.android_challenge.ui.fragments.FirstScreenFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // add first screen fragment
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        FirstScreenFragment mainScreenFragment = new FirstScreenFragment();
        fragmentTransaction.add(R.id.container, mainScreenFragment);
        fragmentTransaction.commit();
    }
}
