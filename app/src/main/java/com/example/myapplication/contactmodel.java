package com.example.myapplication;

public class contactmodel {
    int img;
    String name, number;

    public  contactmodel(int img, String name, String number)
    {
        this.img = img;
        this.name = name;
        this.number = number;
    }

    public contactmodel(String name, String number)
    {
        this.name=name;
        this.number=number;
    }
}
