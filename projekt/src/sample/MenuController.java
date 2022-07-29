package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MenuController {


    public void addC(javafx.event.ActionEvent actionEvent) throws IOException{

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/dodajKlienta.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Dodaj klienta");
        stage.setScene(new Scene(root1, 400, 300));
        stage.show();}          //deklaracja przycisków w main

    public void removeC(ActionEvent actionEvent) throws IOException{


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/usunKlienta.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Usuń klienta");
        stage.setScene(new Scene(root1, 400, 300));
        stage.show();}

    public void showC(ActionEvent actionEvent) throws IOException{


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/pokazKlientow.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Lista klientów");
        stage.setScene(new Scene(root1,  500, 400));
        stage.show();}


    public void addEmp(ActionEvent actionEvent) throws IOException{


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/dodajEmp.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Dodaj pracownika");
        stage.setScene(new Scene(root1, 400, 300));
        stage.show();}


    public void removeEmp(ActionEvent actionEvent) throws IOException{


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/usunEmp.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Usuń pracownika");
        stage.setScene(new Scene(root1, 400, 300));
        stage.show();}

    public void showEmp(ActionEvent actionEvent) throws IOException{


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/pokazEmp.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Lista Pracowników");
        stage.setScene(new Scene(root1, 500, 400));
        stage.show();}

}



