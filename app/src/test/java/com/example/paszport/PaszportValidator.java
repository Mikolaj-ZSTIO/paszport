package com.example.paszport;

import org.junit.Test;

import static org.junit.Assert.*;

public class PaszportValidator {

    @Test
    public void testUtworzeniePaszportu() {

        Paszport paszport = new Paszport(
                "456",
                "Adam",
                "Nowak",
                "zielone"
        );

        assertEquals("456", paszport.getNumer());
        assertEquals("Adam", paszport.getImie());
        assertEquals("Nowak", paszport.getNazwisko());
        assertEquals("zielone", paszport.getKolorOczu());
    }

    @Test
    public void testPoprawnyPaszport() {

        Paszport paszport = new Paszport(
                "456",
                "Adam",
                "Nowak",
                "zielone"
        );

        assertTrue(Validator.czyPoprawnyPaszport(paszport));
    }

    @Test
    public void testBrakImienia() {

        Paszport paszport = new Paszport(
                "456",
                "",
                "Nowak",
                "zielone"
        );

        assertFalse(Validator.czyPoprawnyPaszport(paszport));
    }

    @Test
    public void testBrakNazwiska() {

        Paszport paszport = new Paszport(
                "456",
                "Adam",
                "",
                "zielone"
        );

        assertFalse(Validator.czyPoprawnyPaszport(paszport));
    }

    @Test
    public void testBrakNumeru() {

        Paszport paszport = new Paszport(
                "",
                "Adam",
                "Nowak",
                "zielone"
        );

        assertFalse(Validator.czyPoprawnyPaszport(paszport));
    }

    @Test
    public void testNiepoprawnyKolorOczu() {

        Paszport paszport = new Paszport(
                "456",
                "Adam",
                "Nowak",
                "fioletowe"
        );

        assertFalse(Validator.czyPoprawnyPaszport(paszport));
    }

    @Test
    public void testPoprawneKoloryOczu() {

        assertTrue(Validator.czyPoprawnyKolorOczu("niebieskie"));
        assertTrue(Validator.czyPoprawnyKolorOczu("zielone"));
        assertTrue(Validator.czyPoprawnyKolorOczu("piwne"));
    }

    @Test
    public void testNiepoprawneKoloryOczu() {

        assertFalse(Validator.czyPoprawnyKolorOczu("fioletowe"));
        assertFalse(Validator.czyPoprawnyKolorOczu(""));
        assertFalse(Validator.czyPoprawnyKolorOczu(null));
    }

    @Test
    public void testToString() {

        Paszport paszport = new Paszport(
                "456",
                "Adam",
                "Nowak",
                "zielone"
        );

        assertEquals(
                "Adam Nowak kolor oczu zielone",
                paszport.toString()
        );
    }
}