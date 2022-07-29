package sample;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.sql.*;

public class DodajEmp {


    public TextField imieEmp;
    public TextField nazEmp;
    public Label resultsAddEmp;


    public void dodajEmp() throws SQLException {

        String imie = imieEmp.getText();
        String nazwisko = nazEmp.getText();
        Connection conn = null;

        try {

            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:warsztat.db");

            Statement stat = conn.createStatement();

            if (!imie.isEmpty() && !nazwisko.isEmpty()){

                resultsAddEmp.setText("Pracownik został dodany");
                resultsAddEmp.setTextFill(Color.GREEN);
                String dodajKlienta = "INSERT INTO pracownik(imie_p, nazw_p) VALUES('" + imie + "','" + nazwisko + "');";
            ResultSet rs = stat.executeQuery(dodajKlienta);

        }
        else{

            resultsAddEmp.setText("Nieprawidłowo wprowadzone dane");
                resultsAddEmp.setTextFill(Color.RED);
        }
            conn.close();


        } catch (SQLException | ClassNotFoundException e) {

            System.err.println(e.getMessage());


        } finally {
            try {

                if (conn != null) conn.close();

            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }


        }

    }
}
