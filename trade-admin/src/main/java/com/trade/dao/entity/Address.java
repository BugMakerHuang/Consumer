package com.trade.dao.entity;

public class Address implements Cloneable{
    private String provices;
    private String city;
    public void setAddress(String provices,String city){
        this.provices = provices;
        this.city = city;
    }
    @Override
    public String toString() {
        return "Address [provices=" + provices + ", city=" + city + "]";
    }

    @Override
    public Address clone() throws CloneNotSupportedException{
        return (Address) super.clone();
    }
}
