package com.example.trainingapp;

public class Organization {
    private int id;
    private String name;
    private String short_name;
    private String address;

    public Organization(int id, String name, String short_name, String address) {
        this.id = id;
        this.name = name;
        this.short_name = short_name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
