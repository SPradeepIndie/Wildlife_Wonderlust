package com.example.home.model;


public class Location {
    private String l_id;
    private String l_name;

    public Location(String l_id, String l_name) {
        this.l_id = l_id;
        this.l_name = l_name;
    }

    public Location() {
    }

    public String getL_id() {
        return l_id;
    }

    public void setL_id(String l_id) {
        this.l_id = l_id;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }
}
