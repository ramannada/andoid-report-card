package com.example.ramannada.reportcard;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Switch;

import java.io.Serializable;

/**
 * Created by ramannada on 10/16/2017.
 */

public class Student implements Parcelable {

    private String name;
    private Subject subject;

    public Student(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Subject getSubject() {
        return subject;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeParcelable(this.subject, flags);
    }

    protected Student(Parcel in) {
        this.name = in.readString();
        this.subject = in.readParcelable(Subject.class.getClassLoader());
    }

    public static final Parcelable.Creator<Student> CREATOR = new Parcelable.Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", subject=" + subject +
                '}';
    }
}
