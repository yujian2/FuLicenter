package com.example.lenovo.fulicenters.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.lenovo.fulicenters.R;
import com.example.lenovo.fulicenters.utils.L;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        L.i("MainActivity onCreate");
    }

    public void onCheckedChange(View v){

    }
}
