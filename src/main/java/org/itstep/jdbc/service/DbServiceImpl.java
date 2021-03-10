package org.itstep.jdbc.service;

import org.itstep.jdbc.config.DBManager;
import org.itstep.jdbc.entity.Item;

import java.util.List;

public class DbServiceImpl implements DbService {

    private final DBManager dbManager = new DBManager();


    @Override
    public List<Item> getAllItems() throws ClassNotFoundException {
        return dbManager.getAllItemsDBM();
    }

    @Override
    public void createItem(Item item) throws ClassNotFoundException {
        dbManager.createItem(item);
    }

    @Override
    public void deleteItem(Long id) throws ClassNotFoundException {
        dbManager.deleteItem(id);
    }
}
