package com.example.trainingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrganizationActivity extends AppCompatActivity {
    ArrayList<Organization> organizations = new ArrayList<Organization>();
    ListView organizationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setInitialData();
        Init();
        organizationList = findViewById(R.id.listViewOrganization);
        OrganizationAdapter organizationAdapter = new OrganizationAdapter(this, R.layout.list_item,organizations);
        organizationList.setAdapter(organizationAdapter);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Organization selectedOrganization = (Organization) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Выбрано: " + selectedOrganization.getId(), Toast.LENGTH_SHORT).show();
            }
        };
        organizationList.setOnItemClickListener(itemClickListener);
    }

    private void Init() {
        EditText nameOrganization = (EditText) findViewById(R.id.nameOrganization);
        EditText shortNameOrganization = (EditText) findViewById(R.id.shortNameOrganization);
        EditText addressOrganization = (EditText) findViewById(R.id.addressOrganization);
    }

    private void setInitialData() {
        organizations.add(new Organization(1,
                "Учреждение повышения квалификации и переподготовки технических специальностей 'ItTech'",
                "ItTech",
                "ул. Гоголя, д. 223"));

        organizations.add(new Organization(2,
                "ГАПОУ 'Оренбургский колледж экономики и информатики'",
                "ГАПОУ 'ОКЭИ'",
                "ул. Чкалова, д. 11"));
    }
}