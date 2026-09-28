package com.example.paszport;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText numer;
    private EditText imie;
    private EditText nazwisko;

    private ImageView zdjecie;
    private ImageView odcisk;

    private RadioButton niebieskie;
    private RadioButton zielone;
    private RadioButton piwne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numer = findViewById(R.id.numer);
        imie = findViewById(R.id.imie);
        nazwisko = findViewById(R.id.nazwisko);

        zdjecie = findViewById(R.id.zdjecie);
        odcisk = findViewById(R.id.odcisk);

        niebieskie = findViewById(R.id.niebieskie);
        zielone = findViewById(R.id.zielone);
        piwne = findViewById(R.id.piwne);

        Button ok = findViewById(R.id.ok);

        numer.setOnFocusChangeListener((view, hasFocus) -> {
            if (!hasFocus) {
                aktualizujZdjecia();
            }
        });

        ok.setOnClickListener(view -> pokazDane());
    }

    private void aktualizujZdjecia() {

        String numerZdjecia = numer.getText().toString().trim();

        if (numerZdjecia.isEmpty()) {
            zdjecie.setImageDrawable(null);
            odcisk.setImageDrawable(null);
            return;
        }

        int idZdjecie = getResources().getIdentifier(
                "zdjecie" + numerZdjecia,
                "drawable",
                getPackageName()
        );

        int idOdcisk = getResources().getIdentifier(
                "odcisk" + numerZdjecia,
                "drawable",
                getPackageName()
        );

        if (idZdjecie != 0) {
            zdjecie.setImageResource(idZdjecie);
        } else {
            zdjecie.setImageDrawable(null);
        }

        if (idOdcisk != 0) {
            odcisk.setImageResource(idOdcisk);
        } else {
            odcisk.setImageDrawable(null);
        }
    }

    private void pokazDane() {

        String imieTekst = imie.getText().toString().trim();
        String nazwiskoTekst = nazwisko.getText().toString().trim();

        if (TextUtils.isEmpty(imieTekst)
                || TextUtils.isEmpty(nazwiskoTekst)) {

            Toast.makeText(
                    this,
                    "Wprowadź dane",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        String kolorOczu;

        if (niebieskie.isChecked()) {
            kolorOczu = "niebieskie";
        } else if (zielone.isChecked()) {
            kolorOczu = "zielone";
        } else {
            kolorOczu = "piwne";
        }

        String komunikat =
                imieTekst + " "
                        + nazwiskoTekst
                        + " kolor oczu "
                        + kolorOczu;

        Toast.makeText(
                this,
                komunikat,
                Toast.LENGTH_LONG
        ).show();
    }
}

