package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database extends AbstractDatabase {

    public Database() {
        super(
                "com.mysql.jdbc.Driver",
                "localhost",
                "pessoa_2a_va",
                "root",
                "root");

        try {
            Class.forName(this.driver);

            this.setConnection();

            if (this.getConnection() == null) System.out.println("Não conectado");
            else System.out.println("Conectado com sucesso");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    @Override
    protected void setConnection() throws SQLException {
        this.connection = DriverManager.getConnection(this.url, this.username, this.password);
    }

    public boolean closeConnection() {
        try {
            this.connection.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}