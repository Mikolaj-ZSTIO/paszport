package com.example.paszport;

public class Paszport {

    private String numer;
    private String imie;
    private String nazwisko;
    private String kolorOczu;

    public Paszport(String numer, String imie, String nazwisko, String kolorOczu) {
        this.numer = numer;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.kolorOczu = kolorOczu;
    }

    public String getNumer() {
        return numer;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getKolorOczu() {
        return kolorOczu;
    }

    public void setNumer(String numer) {
        this.numer = numer;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setKolorOczu(String kolorOczu) {
        this.kolorOczu = kolorOczu;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko + " kolor oczu " + kolorOczu;
    }
}
