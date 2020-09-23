package com.hollysmart.smarttool.db;

import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

public class DBHelper {
    private AndroidConnectionSource connectionSource;
    private static DBHelper dbHelper;

    public static DBHelper getInstance(String dbPath) {
        if (dbHelper == null) {
            dbHelper = new DBHelper(dbPath);
        }
        return dbHelper;
    }
    private DBHelper(String dbPath) {
        SQLiteDatabase db = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
        connectionSource = new AndroidConnectionSource(db);
    }
    public <D extends Dao<T, ?>, T> D getDao(Class<T> clazz) throws Exception {
        if (connectionSource != null) {
            return DaoManager.createDao(connectionSource, clazz);
        }
        return null;
    }
}