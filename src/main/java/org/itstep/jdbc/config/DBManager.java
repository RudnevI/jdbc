package org.itstep.jdbc.config;

import org.itstep.jdbc.entity.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

    private static final String GET_ALL_QUERY = "SELECT * FROM items.items_table";
    private static final String INSERT_QUERY = "INSERT INTO items.items_table values(NULL, ?, ?)";
    private static final String DELETE_QUERY = "DELETE FROM items.items_table WHERE id = ?";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "";


    public List<Item> getAllItemsDBM() throws ClassNotFoundException {
        List<Item> itemList = new ArrayList<>();
        Class.forName(DRIVER);
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_QUERY);
                ResultSet resultSet = preparedStatement.executeQuery()


        ) {

            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getLong(1));
                item.setName(resultSet.getString(2));
                item.setPrice(resultSet.getDouble(3));
                itemList.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;

    }

    public void createItem(Item c) throws ClassNotFoundException {
        Class.forName(DRIVER);
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)


        ) {
            preparedStatement.setString(1, c.getName());
            preparedStatement.setDouble(2, c.getPrice());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteItem(Long id) throws ClassNotFoundException {
        Class.forName(DRIVER);
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY)


        ) {

            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
