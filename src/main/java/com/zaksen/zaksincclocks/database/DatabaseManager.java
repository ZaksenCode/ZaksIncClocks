package com.zaksen.zaksincclocks.database;

import com.zaksen.zaksincclocks.data.ClockData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static com.zaksen.zaksincclocks.ZaksIncClocks.LOGGER;

public class DatabaseManager {
    private static final DatabaseManager instance = new DatabaseManager();
    private Connection connection;
    private Statement statement;

    public static DatabaseManager getInstance() {
        return instance;
    }

    private DatabaseManager() {
    }

    public void init() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:zaks-inc_clocks.sqlite");
            statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS clocks(id INTEGER, uuid TEXT);");
        } catch (SQLException e) {
            LOGGER.error("unstable database connection: ", e);
        }
    }

    public void stop() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            LOGGER.error("unable stop database connection: ", e);
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
