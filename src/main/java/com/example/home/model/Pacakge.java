package com.example.home.model;

public class Pacakge {
    private String p_name;
    private Double max_price;

    public Pacakge(String p_name, Double max_price) {
        this.p_name = p_name;
        this.max_price = max_price;
    }

    public Pacakge() {
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public Double getMax_price() {
        return max_price;
    }

    public void setMax_price(Double max_price) {
        this.max_price = max_price;
    }
}
