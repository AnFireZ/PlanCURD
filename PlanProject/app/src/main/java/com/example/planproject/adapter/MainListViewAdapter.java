package com.example.planproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.planproject.R;
import com.example.planproject.bean.TaskNote;
import com.example.planproject.dao.TaskNoteDao;

import java.util.List;

public class MainListViewAdapter extends BaseAdapter {
    private Context context;
    private List<TaskNote> taskNotes;
    private TaskNoteDao taskNoteDao;

    public MainListViewAdapter(Context context) {
        this.context = context;
        taskNoteDao=new TaskNoteDao(context);
        taskNotes=taskNoteDao.list();
    }
    public void refresh(){
        taskNotes=taskNoteDao.list();
    }
    @Override
    public int getCount() {
        return taskNotes.size();
    }

    @Override
    public Object getItem(int position) {
        return taskNotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return taskNotes.get(position).getNid();
    }
//    private Integer nid;
//    private String listname;
//    private String datetime;
//    private String notelist;
//    private String state;

    class ViewHolder{
        TextView tv_listname,tv_datetime,tv_notelist,tv_state;
    }
    ViewHolder viewHolder;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TaskNote t = (TaskNote) getItem(position);
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_item, null);
            viewHolder=new ViewHolder();
            viewHolder.tv_listname=convertView.findViewById(R.id.tv_listname);
            viewHolder.tv_datetime=convertView.findViewById(R.id.tv_datetime);
            viewHolder.tv_notelist=convertView.findViewById(R.id.tv_notelist);
            viewHolder.tv_state=convertView.findViewById(R.id.tv_state);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_listname.setText(t.getListname());
        viewHolder.tv_datetime.setText(t.getDatetime());
        viewHolder.tv_notelist.setText(t.getNotelist());
        viewHolder.tv_state.setText(t.getState());
        return convertView;
    }
}
