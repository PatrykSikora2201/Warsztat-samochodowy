package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.objects.Pracownik;


import java.sql.*;

public class PokazEmp {

    public TableColumn<Pracownik, Integer> id_pr;
    public TableColumn<Pracownik, String> imie_pr;
    public TableColumn<Pracownik, String> nazw_pr;
    public TableView<Pracownik> tabela_p;

    public void showEmp() throws SQLException{

        Connection conn = null;
        try{

            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:warsztat.db");

            Statement stat = conn.createStatement();

            String dodajKlienta = "SELECT * FROM pracownik;";
            ResultSet rs = stat.executeQuery(dodajKlienta);

            tabela_p.getColumns().addAll(

                    id_pr, imie_pr, nazw_pr

            );

            while (rs.next()){

                int id2 = rs.getInt("id_p");
                String imie2 = rs.getString("imie_p");
                String nazwisko2 = rs.getString("nazw_p");


                id_pr.setCellValueFactory(new PropertyValueFactory<Pracownik, Integer>("id_p"));
                imie_pr.setCellValueFactory(new PropertyValueFactory<Pracownik,String>("imie_p"));
                nazw_pr.setCellValueFactory(new PropertyValueFactory<Pracownik, String>("nazwisko_p"));


                tabela_p.setItems(getEmp(id2, imie2, nazwisko2));

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

    private ObservableList<Pracownik> getEmp(int id, String imie, String nazwisko) {
        ObservableList<Pracownik> prac = FXCollections.observableArrayList(

                new Pracownik(id, imie, nazwisko)

        );

        return prac;
    }


}
