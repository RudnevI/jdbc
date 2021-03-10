package org.itstep.jdbc.service;

import org.itstep.jdbc.entity.Item;

import java.sql.SQLException;
import java.util.List;

public interface DbService {

    List<Item> getAllItems() throws SQLException, ClassNotFoundException;


    void createItem(Item item) throws ClassNotFoundException;

    void deleteItem(Long id) throws ClassNotFoundException;


}
