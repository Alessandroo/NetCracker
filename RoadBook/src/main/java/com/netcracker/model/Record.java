package com.netcracker.model;

/**
 * Created by Vojts on 25.10.2016.
 */
public class Record {
    private int id;
    private String country;
    private String number;
    private String name;
    private int longer;
    private String control;
    public Record(int id, String country, String number, String name, int longer, String control){
        this.id = id;
        this.country = country;
        this.number = number;
        this.name = name;
        this.longer = longer;
        this.country = control;
    }

    public int getId(){
        return id;
    }

    public String getCountry(){
        return country;
    }

    public String getNumber(){
        return number;
    }

    public String getName(){
        return name;
    }

    public int getLonger(){
        return longer;
    }

    public String getControl(){
        return control;
    }
}
