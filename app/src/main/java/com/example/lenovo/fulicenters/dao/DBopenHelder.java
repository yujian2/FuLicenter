package com.example.lenovo.fulicenters.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lenovo.fulicenters.I;

/**
 * Created by lenovo on 2016/10/26.
 */

public class DBopenHelder extends SQLiteOpenHelper {
    private  static final int  DATAEASE_VERSION=1;
    private static  DBopenHelder instance;
    private  static final String CREATE_USER_TABLE="";

    public   static DBopenHelder onInit(Context context){
        if (instance==null){
            instance=new DBopenHelder(context);
        }
        return instance;
    }

    public DBopenHelder(Context context) {
        super(context, getUserDatabaseName(), null, DATAEASE_VERSION);
    }

    private static String getUserDatabaseName() {
        return I.User.TABLE_NAME+"demo.db";
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void closeDB(){
        if (instance!=null){
            instance.close();
            instance=null;
        }
    }


}
