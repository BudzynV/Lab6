module com.example.lab6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens pl.lublin.wsei.java.cwiczenia.test.TestConnection.java to javafx.fxml;
    exports pl.lublin.wsei.java.cwiczenia.test.TestConnection.java;
}