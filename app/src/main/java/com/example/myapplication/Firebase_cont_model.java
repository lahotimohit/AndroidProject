package com.example.myapplication;

public class Firebase_cont_model {
    String name;
    String mob_no;

    Firebase_cont_model()
    {

    }
    Firebase_cont_model(String name, String mob_no)
    {
        this.name=name;
        this.mob_no=mob_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMob_no() {
        return mob_no;
    }

    public void setMob_no(String mob_no) {
        this.mob_no = mob_no;
    }
}
