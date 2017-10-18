package com.example.ramannada.reportcard;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ramannada on 10/16/2017.
 */

public class Grade implements Parcelable {
    private String stringGrade;
    private Character charGrade;
    private int intGrade;
    private double doubleGrade;

    public Grade(Character grade) {
        this.charGrade = grade;
    }

    public Grade(String grade) {
        this.stringGrade = grade;
    }

    public Grade(int grade) {
        this.intGrade = grade;
    }

    public Grade(double grade) {
        this.doubleGrade = grade;
    }

    public void setGrade(String grade) {
        this.stringGrade = grade;
    }

    public void setGrade(Character grade) {
        this.charGrade = grade;
    }

    public void setGrade(int grade) {
        this.intGrade = grade;
    }

    public void setGrade(double grade) {
        this.doubleGrade = grade;
    }


    public String getGrade() {
        if (this.stringGrade != null) {
            return this.stringGrade;
        } else if (this.charGrade != null) {
            return this.charGrade.toString();
        } else if (this.intGrade != 0) {
            return Integer.toString(this.intGrade);
        } else if (this.doubleGrade != 0) {
            return Double.toString(this.doubleGrade);
        } else {
            return "0";
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.stringGrade);
        dest.writeSerializable(this.charGrade);
        dest.writeInt(this.intGrade);
        dest.writeDouble(this.doubleGrade);
    }

    protected Grade(Parcel in) {
        this.stringGrade = in.readString();
        this.charGrade = (Character) in.readSerializable();
        this.intGrade = in.readInt();
        this.doubleGrade = in.readDouble();
    }

    public static final Parcelable.Creator<Grade> CREATOR = new Parcelable.Creator<Grade>() {
        @Override
        public Grade createFromParcel(Parcel source) {
            return new Grade(source);
        }

        @Override
        public Grade[] newArray(int size) {
            return new Grade[size];
        }
    };
}
