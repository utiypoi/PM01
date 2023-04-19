package com.example.trainingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.course:
                Intent intentCourse = new Intent(this, CourseActivity.class);
                startActivity(intentCourse);
                break;
            case R.id.organization:
                Intent intentOrganization = new Intent(this, OrganizationActivity.class);
                startActivity(intentOrganization);
                break;
            case R.id.addressOrganization:
                Intent intentLicenze = new Intent(this, LicenzeActivity.class);
                startActivity(intentLicenze);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}