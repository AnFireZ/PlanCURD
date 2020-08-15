package com.example.planproject.bean;

import java.io.Serializable;

public class TaskNote implements Serializable {
    private Integer nid;
    private String listname;
    private String datetime;
    private String notelist;
    private String state;

    public TaskNote() {
    }

    public TaskNote(String listname, String datetime, String notelist, String state) {
        this.listname = listname;
        this.datetime = datetime;
        this.notelist = notelist;
        this.state = state;
    }

    public TaskNote(Integer nid, String listname, String datetime, String notelist, String state) {
        this.nid = nid;
        this.listname = listname;
        this.datetime = datetime;
        this.notelist = notelist;
        this.state = state;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getListname() {
        return listname;
    }

    public void setListname(String listname) {
        this.listname = listname;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getNotelist() {
        return notelist;
    }

    public void setNotelist(String notelist) {
        this.notelist = notelist;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "TaskNote{" +
                "nid=" + nid +
                ", listname='" + listname + '\'' +
                ", datetime='" + datetime + '\'' +
                ", notelist='" + notelist + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
