package com.livrai.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbstractDao {

    private Connection connection;

    private final String user = System.getenv("DATABASE_USERNAME");
    private final String password = System.getenv("DATABASE_PASSWORD");

    private Connection getConnection() {
        if (connection == null) {
            loadDatabase();
        }
        return connection;
    }

    protected <T> T execute(SqlQuery<T> query) {
        try {
            return query.execute(getConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void loadDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/livrai", user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected interface SqlQuery<T> {
        T execute(Connection connection) throws SQLException;
    }

}
