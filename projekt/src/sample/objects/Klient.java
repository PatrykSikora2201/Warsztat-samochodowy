package sample.objects;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.beans.property.SimpleStringProperty;

public class Klient {

    private int id;

    public Klient(int id, String imie_k, String nazw_k, String naprawa) {
        this.id = id;
        this.imie_k = imie_k;
        this.nazw_k = nazw_k;
        this.naprawa = naprawa;
    }

    private String imie_k;
    private String nazw_k;
    private String naprawa;




}
