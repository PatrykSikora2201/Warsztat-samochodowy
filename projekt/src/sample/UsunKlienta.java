package sample;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.sql.*;

public class UsunKlienta {

    public TextField nazwiskoC;
    public TextField imieC;
    public Label resultRemC;

    public void usunC() throws SQLException {

        String imie = imieC.getText();
        String nazwisko = nazwiskoC.getText();

        Connection conn = null;
        try{

            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:warsztat.db");

            Statement stat = conn.createStatement();


            resultRemC.setText("Klient został usunięty");
            resultRemC.setTextFill(Color.GREEN);

            if(!imie.isEmpty() && !nazwisko.isEmpty()) {

                String usunKlienta = "DELETE FROM klient WHERE imie_k='" + imie + "' AND naz_k='" + nazwisko + "';";
                ResultSet rs = stat.executeQuery(usunKlienta);


            }
            else {

                resultRemC.setText("Nieprawidłowo wprowadzone dane");
                resultRemC.setTextFill(Color.RED);
            }

            conn.close();


        } catch (SQLException | ClassNotFoundException e){

            System.err.println(e.getMessage());


        }finally {
            try{

                if(conn != null)conn.close();

            }catch (SQLException e){
                System.err.println(e.getMessage());
            }

        }


    }
}
