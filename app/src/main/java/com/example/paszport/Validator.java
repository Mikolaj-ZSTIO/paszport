package com.example.paszport;

public class Validator {

    public static boolean czyPoprawneImie(String imie) {
        return imie != null && !imie.trim().isEmpty();
    }

    public static boolean czyPoprawneNazwisko(String nazwisko) {
        return nazwisko != null && !nazwisko.trim().isEmpty();
    }

    public static boolean czyPoprawnyNumer(String numer) {
        return numer != null && !numer.trim().isEmpty();
    }

    public static boolean czyPoprawnyKolorOczu(String kolorOczu) {
        if (kolorOczu == null) {
            return false;
        }

        return kolorOczu.equals("niebieskie")
                || kolorOczu.equals("zielone")
                || kolorOczu.equals("piwne");
    }

    public static boolean czyPoprawnyPaszport(Paszport paszport) {

        if (paszport == null) {
            return false;
        }

        return czyPoprawnyNumer(paszport.getNumer())
                && czyPoprawneImie(paszport.getImie())
                && czyPoprawneNazwisko(paszport.getNazwisko())
                && czyPoprawnyKolorOczu(paszport.getKolorOczu());
    }
}
