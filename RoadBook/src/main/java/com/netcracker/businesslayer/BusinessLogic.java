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

    ArrayList<Record> getList(int a, int b){
        return driver.getList(a, b);
    }

    int getCountPage() {
        return driver.getCountPage();
    }

    Record getRecord(int id) {
        return driver.getRecord(id);
    }

    void saveRecord(Record record) {
        driver.saveRecord(record);
    }

    void updateRecord(Record record) {
        driver.saveRecord(record);
    }

    void deleteRecord(int id) {
        driver.deleteRecord(id);
    }

    @Override
    protected void finalize() throws Throwable {
        driver.close();
    }
}
