package com.zaksen.zaksincclocks.database;

import com.zaksen.zaksincclocks.ZaksIncClocks;
import com.zaksen.zaksincclocks.data.ClockData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DatabaseManager {
    public static final DatabaseManager instance = new DatabaseManager();
    private final Logger logger;
    private Connection connection;
    private Statement statement;

    private DatabaseManager() {
        logger = LoggerFactory.getLogger(ZaksIncClocks.class);
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:zaks-inc_clocks.sqlite");
            statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS clocks(id INTEGER, uuid TEXT);");
        } catch (SQLException e) {
            logger.error("unstable database connection: ", e);
        }
    }

    // TODO - сделать сохранение в базу данных
    public void addNewClock() {

    }

    public void updateClock() {

    }

    public void removeClock() {

    }

    public ClockData getClockData() {
        return null;
    }

    public List<ClockData> getAllClocksData() {
        return null;
    }
}
