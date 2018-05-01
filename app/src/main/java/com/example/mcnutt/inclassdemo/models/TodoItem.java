package com.example.mcnutt.inclassdemo.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class TodoItem implements Parcelable {
    public String uid;
    public String title;
    public boolean done;

    public TodoItem() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public TodoItem(String title, boolean done) {
        this.title = title;
        this.done = done;
    }

    public TodoItem(Parcel in) {
        title = in.readString();
        done = in.readByte() != 0;
    }

    public static final Creator<TodoItem> CREATOR = new Creator<TodoItem>() {
        @Override
        public TodoItem createFromParcel(Parcel in) {
            return new TodoItem(in);
        }

        @Override
        public TodoItem[] newArray(int size) {
            return new TodoItem[size];
        }
    };

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("title", title);
        result.put("done", done);

        return result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeByte((byte) (done ? 1 : 0));
    }
}
