package com.example.ramannada.reportcard;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {
    ArrayList<Student> student = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        student = getIntent().getParcelableArrayListExtra("students");


        StudentAdapter adapter = new StudentAdapter(DisplayActivity.this, student);
        Log.d("display", "adapter sukses");
        ListView listView = (ListView) findViewById(R.id.list_view_display);
        Log.d("display", "list view sukses");

        listView.setAdapter(adapter);
        Log.d("display", "set adapter sukses");


    }

}
