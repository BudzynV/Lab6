package pl.lublin.wsei.java.cwiczenia.test.TestConnection.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyDB {

    private String user = "root";
    private String password = "root";
    private String host = "LocalHost";
    private String database = "mydb";
    private Number port = 3306;

    public static void main(String[] args){
        }

    MyDB(String host, Number port,String database){
        this.host = host;
        this.port = port;
        this.database = database;
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


    public void setUser(String root) {
    }

    public void setPassword(String root) {
    }
}



