package com.test.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import utils.Utility;

/**
 * Created by iriemo on 14/5/15.
 */
public class FirstActivity extends AppCompatActivity implements OnListItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_first);

        getSupportFragmentManager().beginTransaction().replace(R.id.firstContent,new FirstFragment()).commit();

        //First comment
        if(findViewById(R.id.secondContent) != null){
            SecondFragment secondFragment = new SecondFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(Utility.KEY_ARGS,0);
            secondFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.secondContent,secondFragment).commit();
        }
    }

    @Override
    public void onItemClick(int position) {

        if(findViewById(R.id.secondContent) != null){
            SecondFragment secondFragment = new SecondFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(Utility.KEY_ARGS,position);
            secondFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction().replace(R.id.secondContent,secondFragment).commit();

        } else{
            Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
            intent.putExtra(Utility.KEY_ARGS,position);
            startActivity(intent);
        }

    }
}
