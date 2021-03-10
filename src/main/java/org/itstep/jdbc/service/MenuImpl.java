package org.itstep.jdbc.service;

import org.itstep.jdbc.entity.Item;

import java.util.Scanner;
import java.util.logging.Logger;

public class MenuImpl implements Menu {

    private static final String MENU_MESSAGE = "PRESS [1] TO ADD ITEMS\n" +
            "PRESS [2] TO LIST ITEMS\n" +
            "PRESS [3] TO DELETE ITEMS\n" +
            "PRESS [0] TO EXIT\n" +
            "----------------------\n";
    private static final Logger LOGGER = Logger.getLogger(MenuImpl.class.getName());
    private final DbServiceImpl service = new DbServiceImpl();
    private final Scanner input = new Scanner(System.in);


    @Override
    public void displayMenu() {
        LOGGER.info(MENU_MESSAGE);
    }

    @Override
    public void prompt() throws ClassNotFoundException {
        int option = -1;
        while (option != 0) {
            displayMenu();
            option = Integer.parseInt(input.nextLine());
            if (option == 1) {
                Item item = new Item();
                LOGGER.info("Name: ");
                item.setName(input.nextLine());
                LOGGER.info("Price: ");
                item.setPrice(Double.parseDouble(input.nextLine()));
                service.createItem(item);
            } else if (option == 2) {
                service.getAllItems()
                        .forEach(item -> LOGGER.info(item.toString()));
            } else if (option == 3) {
                LOGGER.info("Id: ");
                service.deleteItem(Long.parseLong(input.nextLine()));
            } else {
                if (option != 0) LOGGER.info("No such option");
            }
        }
    }
}
