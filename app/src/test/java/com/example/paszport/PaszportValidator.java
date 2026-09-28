package com.example.paszport;

import org.junit.Test;

import static org.junit.Assert.*;

public class PaszportValidator {

    @Test
    public void testUtworzeniePaszportu() {

        Paszport paszport = new Paszport(
                "123",
                "Jan",
                "Kowalski",
                "niebieskie"
        );

        assertEquals("123", paszport.getNumer());
        assertEquals("Jan", paszport.getImie());
        assertEquals("Kowalski", paszport.getNazwisko());
        assertEquals("niebieskie", paszport.getKolorOczu());
    }

    @Test
    public void testPoprawnyPaszport() {

        Paszport paszport = new Paszport(
                "123",
                "Jan",
                "Kowalski",
                "niebieskie"
        );

        assertTrue(Validator.czyPoprawnyPaszport(paszport));
    }

    @Test
    public void testBrakImienia() {

        Paszport paszport = new Paszport(
                "123",
                "",
                "Kowalski",
                "niebieskie"
        );

        assertFalse(Validator.czyPoprawnyPaszport(paszport));
    }

    @Test
    public void testBrakNazwiska() {

        Paszport paszport = new Paszport(
                "123",
                "Jan",
                "",
                "niebieskie"
        );

        assertFalse(Validator.czyPoprawnyPaszport(paszport));
    }

    @Test
    public void testBrakNumeru() {

        Paszport paszport = new Paszport(
                "",
                "Jan",
                "Kowalski",
                "niebieskie"
        );

        assertFalse(Validator.czyPoprawnyPaszport(paszport));
    }

    @Test
    public void testNiepoprawnyKolorOczu() {

        Paszport paszport = new Paszport(
                "123",
                "Jan",
                "Kowalski",
                "czerwone"
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

        assertFalse(Validator.czyPoprawnyKolorOczu("czerwone"));
        assertFalse(Validator.czyPoprawnyKolorOczu(""));
        assertFalse(Validator.czyPoprawnyKolorOczu(null));
    }

    @Test
    public void testToString() {

        Paszport paszport = new Paszport(
                "123",
                "Jan",
                "Kowalski",
                "niebieskie"
        );

        assertEquals(
                "Jan Kowalski kolor oczu niebieskie",
                paszport.toString()
        );
    }
}
