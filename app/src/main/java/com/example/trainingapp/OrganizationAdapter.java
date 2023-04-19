package com.example.trainingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

public class OrganizationAdapter extends ArrayAdapter<Organization> {
    private LayoutInflater inflater;
    private int layout;
    private List<Organization> organizations;

    public OrganizationAdapter(Context context, int resource, List<Organization> organizations) {
        super(context, resource, organizations);
        this.organizations = organizations;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent){
        View view =inflater.inflate(this.layout, parent,false);
        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewShortName = view.findViewById(R.id.textViewShortName);
        TextView textViewAddress = view.findViewById(R.id.textViewAddress);
        Organization organization = organizations.get(position);
        textViewName.setText(organization.getName());
        textViewShortName.setText(organization.getShort_name());
        textViewAddress.setText(organization.getAddress());
        return view;
    }


}
