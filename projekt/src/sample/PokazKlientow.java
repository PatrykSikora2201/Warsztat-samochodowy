package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.objects.Klient;


import java.sql.*;

public class PokazKlientow {
    public TableColumn<Klient, Integer> ID;
    public TableColumn<Klient, String> imie;
    public TableColumn<Klient, String> nazwisko;
    public TableColumn<Klient, String> naprawa;
    public TableView<Klient> tabela;
    public Button pokaKlientow;

    public ObservableList<Klient> getKlient(int id, String imie, String nazwisko, String naprawa) {

        ObservableList<Klient> klient = FXCollections.observableArrayList(
                new Klient(id, imie, nazwisko, naprawa)
        );

        return klient;
    }

    public void showClients() throws SQLException {

        Connection conn = null;
        try {

            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:warsztat.db");

            Statement stat = conn.createStatement();

            String dodajKlienta = "SELECT * FROM klient;";
            ResultSet rs = stat.executeQuery(dodajKlienta);

            tabela.getColumns().addAll(

                    ID, imie, nazwisko, naprawa

            );

            while (rs.next()) {

                int id1 = rs.getInt("id");
                String imie1 = rs.getString("imie_k");
                String nazwisko1 = rs.getString("naz_k");
                String naprawa1 = rs.getString("naprawa");



                tabela.setItems(getKlient(id1, imie1, nazwisko1, naprawa1));

//                Klient c1 = new Klient(id, imie1, nazwisko1, naprawa1);

                ID.setCellValueFactory(new PropertyValueFactory<>("id"));
                imie.setCellValueFactory(new PropertyValueFactory<>("imie_k"));
                nazwisko.setCellValueFactory(new PropertyValueFactory<>("nazw_k"));
                naprawa.setCellValueFactory(new PropertyValueFactory<>("naprawa"));


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
