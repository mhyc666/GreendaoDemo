package com.my.greendaotest;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
public class BaseApplication extends Application{

    private static DaoSession daoSession;
    private static DaoMaster.DevOpenHelper helper;
    @Override
    public void onCreate() {
        super.onCreate();
        //配置数据库
        setupDatabase();
    }

    /**
     * 配置数据库
     */
    private void setupDatabase() {
        helper = new DaoMaster.DevOpenHelper(this, "user.db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoInstant() {
        return daoSession;
    }

    /**
     * 关闭数据连接
     */
    public void close() {
        if (helper!= null) {
            helper.close();
        }
    }
}
