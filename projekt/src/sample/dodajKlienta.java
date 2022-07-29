package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.sql.*;


public class dodajKlienta {

    public TextField imieC;
    public TextField nazwiskoC;
    public Button btnAdd = new Button();
    public Label resultsCAdd;
    public TextField opis;

    public void dodajC() throws SQLException{

        String imie = imieC.getText();
        String nazwisko = nazwiskoC.getText();
        String opiss = opis.getText();

        Connection conn = null;
        try{

            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:warsztat.db");

            Statement stat = conn.createStatement();

            if(!imie.isEmpty() && !nazwisko.isEmpty() && !opiss.isEmpty()) {

                resultsCAdd.setText("Klient został dodany");
                resultsCAdd.setTextFill(Color.GREEN);
                String dodajKlienta = "INSERT INTO klient(imie_k, naz_k, naprawa) VALUES('" + imie + "','" + nazwisko + "','" + opiss + "');";
                ResultSet rs = stat.executeQuery(dodajKlienta);


            }
            else{

                resultsCAdd.setText("Nieprawidłowo wprowadzone dane");
                resultsCAdd.setTextFill(Color.RED);
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
