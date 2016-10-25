package com.example.lenovo.fulicenters.dao;

import android.content.Context;

import com.example.lenovo.fulicenters.bean.User;

/**
 * Created by lenovo on 2016/10/26.
 */

public class UserDao {
    public  static final String TABLE_USER_NAME="t_superwechat_user";
    public   static  final String TABLE_COLUMN_NAME="m_user_name";
    public   static  final String TABLE_COLUMN_NICK="m_user_avater_nick";
    public   static  final String TABLE_COLUMN_AVATAR_ID="m_user_avater_id";
    public   static  final String TABLE_COLUMN_AVATAR_TYPE="m_user_type";
    public   static  final String TABLE_COLUMN_AVATAR_PATH="m_user_avater_path";
    public   static  final String TABLE_COLUMN_AVATSR_SUFFIX="m_user_avater_suffix";
    public   static  final String TABLE_COLUMN_AVATAR_LASTUPDATE_TIME="m_user_avater_lastupdate_time";

    DBManger dbManger=new DBManger();

    public UserDao(Context context) {
        dbManger=DBManger.onInit(context);

    }



    public boolean saveuser(User user) {
        return dbManger.saveUser(user);
    }
    public User getUser(String username){
        return dbManger.getuser(username);

    }
    public boolean updateUser(User user){
        return  dbManger.updateuser(user);
    }
}
