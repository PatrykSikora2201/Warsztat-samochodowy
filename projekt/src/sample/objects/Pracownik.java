package sample.objects;

public class Pracownik {

    private int id_p;
    private String imie_p;
    private String nazwisko_p;

    public Pracownik(int id_p, String imie_p, String nazwisko) {
        this.id_p = id_p;
        this.imie_p = imie_p;
        this.nazwisko_p = nazwisko_p;
    }



    public int getId_p() {
        return id_p;
    }

    public void setId_p(int id_p) {
        this.id_p = id_p;
    }

    public String getImie_p() {
        return imie_p;
    }

    public void setImie_p(String imie_p) {
        this.imie_p = imie_p;
    }

    public String getNazwisko_p() {
        return nazwisko_p;
    }

    public void setNazwisko_p(String nazwisko) {
        this.nazwisko_p = nazwisko;
    }




}
