package com.example.lenovo.fulicenters.utils;

import android.widget.Toast;

import com.example.lenovo.fulicenters.FuLiCenterApplication;


public class CommonUtils {
    public static void showLongToast(String msg){
        Toast.makeText(FuLiCenterApplication.application,msg,Toast.LENGTH_LONG).show();
    }
    public static void showShortToast(String msg){
        Toast.makeText(FuLiCenterApplication.application,msg,Toast.LENGTH_SHORT).show();
    }
    public static void showLongToast(int rId){
        showLongToast(FuLiCenterApplication.application.getString(rId));
    }
    public static void showShortToast(int rId){
        showShortToast(FuLiCenterApplication.application.getString(rId));
    }
}