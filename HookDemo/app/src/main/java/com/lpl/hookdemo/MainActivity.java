package com.lpl.hookdemo;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.pingan.pad.skyeye.hookdemo.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.click).setOnClickListener((v)->{
            onEvent("click");
        });
    }

    public static void onEvent(String log){
        Log.d("ZB", log);
    }
}