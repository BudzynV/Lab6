package pl.lublin.wsei.java.cwiczenia.test.TestConnection.java;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Properties;

public class TestConnector {

    private String user = "root";
    private String password = "root";
    private String host = "LocalHost";
    private String database = "mydb";
    private Number port = 3306;



    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String serverName = "Localhost";
        String database = "mydb";
        Number portNumber = 3306;
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "root");
        connectionProps.put("serverTimezone", "Europe/Warsaw");

        conn = DriverManager.getConnection(
                "jdbc:mysql://" + serverName + ":" + portNumber + "/" + database, connectionProps
        );
        System.out.println("Connected to database ");
    }

    private Connection conn = null;

    private void connect(){
    Properties connectionProps = new Properties();
    connectionProps.put("user", user);
    connectionProps.put("password", password);
    connectionProps.put("serverTimezone", "Europe/Warsaw");

    String jdbcString = "jdbc:mysql://" + host + ":" + port + "/" + database;
    try {
        conn = DriverManager.getConnection(
                jdbcString, connectionProps
        );
    }
    catch (SQLException e){
        System.out.println("Bład podłaczenia do bazy" + jdbcString);
        System.out.println("Komunikat błędu" + e.getMessage());
        conn = null;
    }
        System.out.println("Connected to database" + database);
    }
    public Connection getConnection(){
        if (conn ==  null)
            connect();
        return conn;
    }
}





