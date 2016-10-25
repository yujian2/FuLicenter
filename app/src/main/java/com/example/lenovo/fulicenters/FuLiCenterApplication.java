package com.example.lenovo.fulicenters;

import android.app.Application;


public class FuLiCenterApplication extends Application {
    public static FuLiCenterApplication application;
    private static FuLiCenterApplication instance;
    private  static FuLiCenterApplication username;


    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        instance = this;
    }
    public static FuLiCenterApplication getInstance(){
        if(instance==null){
            instance = new FuLiCenterApplication();
        }
        return instance;
    }

    public static FuLiCenterApplication getUsername() {
        return username;
    }

    public static void setUsername(FuLiCenterApplication username) {
        FuLiCenterApplication.username = username;
    }
}