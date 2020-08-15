package com.example.planproject.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.planproject.R;
import com.example.planproject.adapter.MainListViewAdapter;
import com.example.planproject.bean.TaskNote;
import com.example.planproject.dao.TaskNoteDao;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private MainListViewAdapter mainListViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("TaskList");
        lv=findViewById(R.id.lv);
        mainListViewAdapter=new MainListViewAdapter(MainActivity.this);
        lv.setAdapter(mainListViewAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TaskNote oldTaskNote = (TaskNote) parent.getItemAtPosition(position);
                Intent ToEdit=new Intent(MainActivity.this,EditActivity.class);
                ToEdit.putExtra("tasknote",oldTaskNote);
                MainActivity.this.startActivityForResult(ToEdit,1);
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                TaskNote oldTaskNote = (TaskNote) parent.getItemAtPosition(position);
                delete(oldTaskNote);
                return true;
            }
        });
    }
    public void delete(final TaskNote oldTaskNote){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("删除");
        builder.setMessage("是否删除"+oldTaskNote.getNid());
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TaskNoteDao taskNoteDao=new TaskNoteDao(MainActivity.this);
                taskNoteDao.delete(oldTaskNote.getNid());
                mainListViewAdapter.refresh();
                mainListViewAdapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create();
        builder.show();
    }
    public void add(View view) {
        Intent ToAdd=new Intent(MainActivity.this,AddActivity.class);
        MainActivity.this.startActivityForResult(ToAdd,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==1){
            mainListViewAdapter.refresh();
            mainListViewAdapter.notifyDataSetChanged();
        }
    }
}
