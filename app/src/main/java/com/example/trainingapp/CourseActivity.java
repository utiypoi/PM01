package com.example.trainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}