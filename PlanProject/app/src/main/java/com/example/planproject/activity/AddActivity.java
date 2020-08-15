package com.example.planproject.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.planproject.R;
import com.example.planproject.bean.TaskNote;
import com.example.planproject.dao.TaskNoteDao;

public class AddActivity extends AppCompatActivity {
    private EditText et_listname,et_datetime,et_notelist;
    private Spinner sp_state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        setTitle("添加");
        et_listname=findViewById(R.id.et_listname);
        et_datetime=findViewById(R.id.et_datetime);
        et_notelist=findViewById(R.id.et_notelist);
        sp_state=findViewById(R.id.sp_state);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(AddActivity.this,
                android.R.layout.simple_list_item_1,new String[]{"未完成","已完成","进行中"});
        sp_state.setAdapter(arrayAdapter);
    }

    public void submit_add(View view) {
        String listname= et_listname.getText().toString();
        String datetime=et_datetime.getText().toString();
        String notelist=et_notelist.getText().toString();
        String state= (String) sp_state.getSelectedItem();
        TaskNote taskNote=new TaskNote(listname,datetime,notelist,state);
        TaskNoteDao taskNoteDao=new TaskNoteDao(AddActivity.this);
        taskNoteDao.add(taskNote);
        setResult(1);
        AddActivity.this.finish();
    }
}
