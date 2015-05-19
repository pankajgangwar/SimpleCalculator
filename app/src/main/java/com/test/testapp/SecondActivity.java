package com.test.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import utils.Utility;

/**
 * Created by iriemo on 14/5/15.
 */
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        int position = getIntent().getIntExtra(Utility.KEY_ARGS,0);
        SecondFragment secondFragment = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Utility.KEY_ARGS, position);
        secondFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().replace(R.id.secondContent,secondFragment).commit();
    }
}
