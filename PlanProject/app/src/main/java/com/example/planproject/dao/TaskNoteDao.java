package com.example.planproject.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.planproject.bean.TaskNote;

import java.util.ArrayList;
import java.util.List;

public class TaskNoteDao extends DBHelper{
    public TaskNoteDao(Context context) {
        super(context);
    }
    public void add(TaskNote taskNote){
        SQLiteDatabase db = getReadableDatabase();
        String insertTaskNote="insert into tasknote values(?,?,?,?,?)";
        db.execSQL(insertTaskNote,new Object[]{null,taskNote.getListname(),taskNote.getDatetime(),
        taskNote.getNotelist(),taskNote.getState()});
        db.close();
    }
    public void delete(int nid){
        SQLiteDatabase db = getReadableDatabase();
        String deleteTaskNote="delete from tasknote where nid=?";
        db.execSQL(deleteTaskNote,new Object[]{nid});
        db.close();
    }
    public void update(TaskNote taskNote){
        SQLiteDatabase db = getReadableDatabase();
        String updateTaskNote="update tasknote set listname=?,datetime=?,notelist=?,state=? where nid=?";
        db.execSQL(updateTaskNote,new Object[]{taskNote.getListname(),taskNote.getDatetime(),
                taskNote.getNotelist(),taskNote.getState(),taskNote.getNid()});
        db.close();
    }
    public List<TaskNote> list(){
        List<TaskNote> taskNotes=new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from tasknote", null);
        while(cursor.moveToNext()){
            int nid=cursor.getInt(0);
            String listname=cursor.getString(1);
            String datetime=cursor.getString(2);
            String notelist=cursor.getString(3);
            String state=cursor.getString(4);
            TaskNote taskNote=new TaskNote(nid,listname,datetime,notelist,state);
            taskNotes.add(taskNote);
        }
        db.close();
        return taskNotes;
    }
}
