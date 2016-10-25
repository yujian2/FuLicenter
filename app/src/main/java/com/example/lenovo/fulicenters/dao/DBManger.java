package com.example.lenovo.fulicenters.dao;

import android.content.Context;

import com.example.lenovo.fulicenters.bean.User;

/**
 * Created by lenovo on 2016/10/26.
 */

public class DBManger {
    private static DBManger dbMgr=new DBManger();
    private static DBopenHelder mHolder;

    public DBManger() {

    }
    public  static DBManger onInit(Context context){
        if (mHolder==null) {
            mHolder = DBopenHelder.onInit(context);
        }
        return  dbMgr;
    }
    public static void close(){
        if (mHolder!=null){
            mHolder.closeDB();
        }


    }
    public boolean saveUser(User user){
        return  false;
    }
    public User getuser(String username){
        return null;
    }
    public boolean updateuser(User user){
        return false;
    }
}
