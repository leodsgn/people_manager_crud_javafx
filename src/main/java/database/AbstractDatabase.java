package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDatabase {
    protected Connection connection;
    protected String driver;
    protected String serverName;
    protected String databaseName;
    protected String username;
    protected String password;
    protected String url;

    public AbstractDatabase(String driver, String serverName, String databaseName, String username, String password) {
        this.driver = driver;
        this.serverName = serverName;
        this.databaseName = databaseName;
        this.username = username;
        this.password = password;

        this.url = "jdbc:mysql://" + this.serverName + "/" + this.databaseName;
        this.setConnection();
    }

    protected abstract Connection getConnection();

    protected abstract void setConnection() throws SQLException;
}
