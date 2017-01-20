package com.example.android.themeapp2;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("App", Thread.currentThread().getStackTrace()[2]+"getSupportFragmentManager() "+getSupportFragmentManager());

        if(savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_fragment_container, new MainFragment())
                    .commit();
        }
    }
}
