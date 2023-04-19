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
    EditText nameOrganization;
    EditText shortNameOrganization;
    EditText addressOrganization;
    String name, shortName, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setInitialData();
        nameOrganization = findViewById(R.id.nameOrganization);
        shortNameOrganization = findViewById(R.id.shortNameOrganization);
        addressOrganization = findViewById(R.id.addressOrganization);
        organizationList = findViewById(R.id.listViewOrganization);
        OrganizationAdapter organizationAdapter = new OrganizationAdapter(this, R.layout.list_item, organizations);
        organizationList.setAdapter(organizationAdapter);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Organization selectedOrganization = (Organization) parent.getItemAtPosition(position);
                name = selectedOrganization.getName();
                shortName = selectedOrganization.getShort_name();
                address = selectedOrganization.getAddress();
                nameOrganization.setText(name);
                shortNameOrganization.setText(shortName);
                addressOrganization.setText(address);
//                Toast.makeText(getApplicationContext(), "Выбрано: " + selectedOrganization.getId(), Toast.LENGTH_SHORT).show();
            }
        };
        organizationList.setOnItemClickListener(itemClickListener);
    }

    int n = 0;

    private void setInitialData() {
        organizations.add(new Organization(n + 1,
                "Учреждение повышения квалификации и переподготовки технических специальностей 'ItTech'",
                "ItTech",
                "ул. Гоголя, д. 223"));

        organizations.add(new Organization(n + 2,
                "ГАПОУ 'Оренбургский колледж экономики и информатики'",
                "ГАПОУ 'ОКЭИ'",
                "ул. Чкалова, д. 11"));
    }

    public void saveEntry(View view) {
        //пример
        if (nameOrganization.length() == 0) {
            Toast.makeText(this, "Введите наименование организации", Toast.LENGTH_SHORT).show();
        } else if (shortNameOrganization.length() == 0) {
            Toast.makeText(this, "Введите краткое наименование организации", Toast.LENGTH_SHORT).show();
        } else if (addressOrganization.length() == 0) {
            Toast.makeText(this, "Введите адрес организации", Toast.LENGTH_SHORT).show();
        } else if (nameOrganization.length() == 0 && shortNameOrganization.length() == 0 && addressOrganization.length() == 0) {
            Toast.makeText(this, "Все поля должны быть заполнены", Toast.LENGTH_SHORT).show();
        } else {
            organizations.add(new Organization(n + 3, nameOrganization.getText().toString(), shortNameOrganization.getText().toString(), addressOrganization.getText().toString()));
            OrganizationAdapter organizationAdapter = new OrganizationAdapter(this, R.layout.list_item, organizations);
            organizationList.setAdapter(organizationAdapter);
        }
    }
}