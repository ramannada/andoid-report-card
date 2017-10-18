package com.example.ramannada.reportcard;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ramannada on 10/16/2017.
 */

public class Subject implements Parcelable {
    String subject;
    Grade grade;

    public Subject(String subject)  {
        this.subject = subject;
    }

    public Subject(String subject, Grade grade) {
        this.subject = subject;
        this.grade = grade;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public Grade getGrade() {
        return grade;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.subject);
        dest.writeParcelable(this.grade, flags);
    }

    protected Subject(Parcel in) {
        this.subject = in.readString();
        this.grade = in.readParcelable(Grade.class.getClassLoader());
    }

    public static final Parcelable.Creator<Subject> CREATOR = new Parcelable.Creator<Subject>() {
        @Override
        public Subject createFromParcel(Parcel source) {
            return new Subject(source);
        }

        @Override
        public Subject[] newArray(int size) {
            return new Subject[size];
        }
    };
}
