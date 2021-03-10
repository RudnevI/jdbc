package org.itstep.jdbc;

import org.itstep.jdbc.service.Menu;
import org.itstep.jdbc.service.MenuImpl;

import java.util.Arrays;
import java.util.logging.Logger;

public class JdbcManager {
    private static final Logger LOGGER = Logger.getLogger(JdbcManager.class.getName());
    public static void main(String[] args) {

        try {
            Menu menu = new MenuImpl();
            menu.prompt();
        }
        catch (Exception exception) {
            LOGGER.info(exception.getMessage());
            LOGGER.info(Arrays.toString(exception.getStackTrace()));
        }

    }
}
