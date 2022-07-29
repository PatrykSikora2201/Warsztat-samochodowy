package sample;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.sql.*;

public class UsunEmp {

    public TextField nazEmp;
    public TextField imieEmp;
    public Label resultRemEmp;

    public void usunEmp() throws SQLException {

        String nazwisko = nazEmp.getText();
        String imie = imieEmp.getText();

        Connection conn = null;
        try {

            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:warsztat.db");
            Statement stat = conn.createStatement();


            resultRemEmp.setText("Pracownik został usunięty");
            resultRemEmp.setTextFill(Color.GREEN);
            if (!imie.isEmpty() || !nazwisko.isEmpty()){
                String usunEmp = "DELETE FROM pracownik WHERE imie_p='" + imie + "' AND nazw_p='" + nazwisko + "';";
            ResultSet rs = stat.executeQuery(usunEmp);

        }

        else {

            resultRemEmp.setText("Nieprawidłowo wprowadzone dane");
            resultRemEmp.setTextFill(Color.RED);
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
