package com.pavan.triviaapp.source.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.List;

@Entity
public class Summary implements Serializable {

    @PrimaryKey(autoGenerate = true)
    int _id;
    @ColumnInfo(name = "answer1")
    String answer1;
    @ColumnInfo(name = "answer2")
    String answer2;
    @ColumnInfo(name = "name")
    String name;
    @ColumnInfo(name = "timestamp")
    long timestamp;


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
