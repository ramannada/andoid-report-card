package com.example.ramannada.reportcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Student> listStudent = new ArrayList<>();
    Subject subject;
    Student student;
    Grade grade;
    public static final String KEY_STUDENT = "student";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        instansiasi
        Spinner spinner = (Spinner) findViewById(R.id.spinner_subject);
        Button button = (Button) findViewById(R.id.btn_save);
        final EditText etName = (EditText) findViewById(R.id.et_name);
        final EditText etGrade = (EditText) findViewById(R.id.et_grade);


//        set spinner value
        String[] list = getResources().getStringArray(R.array.subject);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, list);
        spinner.setAdapter(adapter);


//        Listener

//        spinner listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                subject = new Subject((String) adapterView.getItemAtPosition(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                subject = new Subject("Bahasa Indonesia");
            }
        });

//        button listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                student = new Student(etName.getText().toString());
                student.setSubject(subject);
                student.getSubject().setGrade(new Grade(etGrade.getText().toString()));

                listStudent.add(student);


                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("students", listStudent);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}
