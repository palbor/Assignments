package com.example.neeta.project1;

/**
 * Created by Neeta on 27/02/2016.
 */
public class Todo {
    int key_id,key_status;
    String key_title,key_desc, date;

    public Todo() {}

    public Todo(int key_status, String key_title, String key_desc, String date) {
        this.key_status = key_status;
        this.key_title = key_title;
        this.key_desc = key_desc;
        this.date = date;
    }

    public int getKey_id() {
        return key_id;
    }

    public void setKey_id(int key_id) {
        this.key_id = key_id;
    }

    public int getKey_status() {
        return key_status;
    }

    public void setKey_status(int key_status) {
        this.key_status = key_status;
    }

    public String getKey_title() {
        return key_title;
    }

    public void setKey_title(String key_title) {
        this.key_title = key_title;
    }

    public String getKey_desc() {
        return key_desc;
    }

    public void setKey_desc(String key_desc) {
        this.key_desc = key_desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
