package com.netcracker.databaselayer;

import com.netcracker.model.Record;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Vojts on 25.10.2016.
 */
public class DataBaseDriver implements DataClient {
    private static final String URL = "jdbc:mysql://localhost:3306/roadbook";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private Connection connection;

    public DataBaseDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Record> getList(int a, int b){
        ArrayList<Record> list = null;

        try {
            String search = "select * from roads where id between ? and ?";

            PreparedStatement search_record;

            search_record = connection.prepareStatement(search);
            search_record.setInt(1, a);
            search_record.setInt(2, b);

            ResultSet resultSet = search_record.executeQuery();

            if (resultSet.first()){
                list = new ArrayList<Record>();
                while (resultSet.next()) {
                    list.add(new Record(
                            resultSet.getInt("id"),
                            resultSet.getString("country"),
                            resultSet.getString("number"),
                            resultSet.getString("name"),
                            resultSet.getInt("long"),
                            resultSet.getString("control")
                    ));
                }
            }
            search_record.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int getCountPage(){
        int count = 0;

        try {
            String search = "select count(id) from roads";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(search);
            resultSet.next();

            count = resultSet.getInt(1);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    public Record getRecord(int id){
        Record record = null;

        try {

            String search = "select * from roads where id=?";

            PreparedStatement search_record = connection.prepareStatement(search);
            search_record.setInt(1, id);

            ResultSet resultSet = search_record.executeQuery();

            if (resultSet.first()) {
                resultSet.next();
                record = new Record(
                        resultSet.getInt("id"),
                        resultSet.getString("country"),
                        resultSet.getString("number"),
                        resultSet.getString("name"),
                        resultSet.getInt("long"),
                        resultSet.getString("control")
                );
            }

            search_record.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return record;
    }

    public void saveRecord(Record record) {
        try{
            String insert = "insert into roads (country, number, name, long, control) values (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, record.getCountry());
            preparedStatement.setString(2, record.getNumber());
            preparedStatement.setString(3, record.getName());
            preparedStatement.setInt(4, record.getLonger());
            preparedStatement.setString(5, record.getControl());

            preparedStatement.execute();

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRecord(Record record) {
        try {
            String update = "update roads set country=?, number=?, name=?, long=?, control=? where id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, record.getCountry());
            preparedStatement.setString(2, record.getNumber());
            preparedStatement.setString(3, record.getName());
            preparedStatement.setInt(4, record.getLonger());
            preparedStatement.setString(5, record.getControl());
            preparedStatement.setInt(6, record.getId());

            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteRecord(int id) {
        try {
            String delete = "delete from roads where id=?";

            PreparedStatement preparedStatement = connection.prepareStatement(delete);

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
