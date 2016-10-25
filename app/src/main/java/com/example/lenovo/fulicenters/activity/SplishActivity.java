package com.example.lenovo.fulicenters.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.lenovo.fulicenters.R;

public class SplishActivity extends AppCompatActivity {
    private final long sleepTime = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splish);
    }

    @Override
    protected void onStart() {
        super.onStart();
        new Thread(new Runnable() {
            @Override
            public void run() {

                long start = System.currentTimeMillis();
                //create db
                long costTime = System.currentTimeMillis() - start;
                if(sleepTime-costTime>0){
                    try {
                        Thread.sleep(sleepTime-costTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                startActivity(new Intent(SplishActivity.this,MainActivity.class));
            }
        }).start();
    }
}

