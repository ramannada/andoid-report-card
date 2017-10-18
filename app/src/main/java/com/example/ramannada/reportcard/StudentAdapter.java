package com.example.ramannada.reportcard;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ramannada on 10/17/2017.
 */

public class StudentAdapter extends ArrayAdapter<Student> {


    public StudentAdapter(@NonNull Activity context, ArrayList<Student> students) {
        super(context, 0, students);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_student,parent, false
            );
        }

        Student currentStudent = getItem(position);

        TextView tvName = listItemView.findViewById(R.id.tv_name);
        TextView tvSubject = listItemView.findViewById(R.id.tv_subject);
        TextView tvGrade = listItemView.findViewById(R.id.tv_grade);

        tvName.setText(currentStudent.getName());

        return listItemView;
    }
}
