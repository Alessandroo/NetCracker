package com.netcracker.businesslayer;

import com.netcracker.databaselayer.DataBaseDriver;
import com.netcracker.databaselayer.DataClient;
import com.netcracker.model.Record;

import java.util.ArrayList;

/**
 * Created by Vojts on 25.10.2016.
 */
public class BusinessLogic {
    private DataClient driver;

    public BusinessLogic(){
        driver = new DataBaseDriver();
    }

    public ArrayList<Record> getList() {
        return driver.getList();
    }

    public ArrayList<Record> getList(int a, int b){
        return driver.getList(a, b);
    }

    public int getCountPage() {
        return driver.getCountPage();
    }

    public Record getRecord(int id) {
        return driver.getRecord(id);
    }

    public void saveRecord(Record record) throws Exception {
        driver.saveRecord(record);
    }

    public void updateRecord(Record record) {
        driver.updateRecord(record);
    }

    public void deleteRecord(int id) {
        driver.deleteRecord(id);
    }
}
