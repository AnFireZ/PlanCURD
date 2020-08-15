package com.example.planproject.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context,"tasknote.db",null,1);
    }
//    private Integer nid;
//    private String listname;
//    private String datetime;
//    private String notelist;
//    private String state;

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTaskNote="create table tasknote(" +
                "nid integer primary key autoincrement," +
                "listname varchar(50) not null," +
                "datetime varchar(50) not null," +
                "notelist varchar(50) not null," +
                "state varchar(50) not null " +
                ")";
        db.execSQL(createTaskNote);
        String insertTaskNote="insert into tasknote values(?,?,?,?,?)";
        db.execSQL(insertTaskNote,new Object[]{null,"1aa","06.11","开会","已完成"});
        db.execSQL(insertTaskNote,new Object[]{null,"2b","06.11","敲代码","进行中"});
        db.execSQL(insertTaskNote,new Object[]{null,"3c","06.11","做项目","未完成"});
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
