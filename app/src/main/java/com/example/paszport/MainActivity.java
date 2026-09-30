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

    private EditText poleNumeru;
    private EditText poleImienia;
    private EditText poleNazwiska;

    private ImageView obrazekOsoby;
    private ImageView obrazekOdcisku;

    private RadioButton oczyNiebieskie;
    private RadioButton oczyZielone;
    private RadioButton oczyPiwne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        poleNumeru = findViewById(R.id.numer);
        poleImienia = findViewById(R.id.imie);
        poleNazwiska = findViewById(R.id.nazwisko);

        obrazekOsoby = findViewById(R.id.zdjecie);
        obrazekOdcisku = findViewById(R.id.odcisk);

        oczyNiebieskie = findViewById(R.id.niebieskie);
        oczyZielone = findViewById(R.id.zielone);
        oczyPiwne = findViewById(R.id.piwne);

        Button przyciskOk = findViewById(R.id.ok);

        poleNumeru.setOnFocusChangeListener((view, hasFocus) -> {
            if (!hasFocus) {
                wyswietlZdjecia();
            }
        });

        przyciskOk.setOnClickListener(view -> wyswietlInformacje());
    }

    private void wyswietlZdjecia() {

        String numer = poleNumeru.getText().toString().trim();

        if (numer.isEmpty()) {
            obrazekOsoby.setImageDrawable(null);
            obrazekOdcisku.setImageDrawable(null);
            return;
        }

        int zdjecieId = getResources().getIdentifier(
                "zdjecie" + numer,
                "drawable",
                getPackageName()
        );

        int odciskId = getResources().getIdentifier(
                "odcisk" + numer,
                "drawable",
                getPackageName()
        );

        if (zdjecieId != 0) {
            obrazekOsoby.setImageResource(zdjecieId);
        } else {
            obrazekOsoby.setImageDrawable(null);
        }

        if (odciskId != 0) {
            obrazekOdcisku.setImageResource(odciskId);
        } else {
            obrazekOdcisku.setImageDrawable(null);
        }
    }

    private void wyswietlInformacje() {

        String imie = poleImienia.getText().toString().trim();
        String nazwisko = poleNazwiska.getText().toString().trim();

        if (TextUtils.isEmpty(imie) || TextUtils.isEmpty(nazwisko)) {

            Toast.makeText(
                    this,
                    "Wprowadź dane",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        String kolorOczu;

        if (oczyNiebieskie.isChecked()) {
            kolorOczu = "niebieskie";
        } else if (oczyZielone.isChecked()) {
            kolorOczu = "zielone";
        } else {
            kolorOczu = "piwne";
        }

        String wiadomosc =
                imie + " "
                        + nazwisko
                        + " kolor oczu "
                        + kolorOczu;

        Toast.makeText(
                this,
                wiadomosc,
                Toast.LENGTH_LONG
        ).show();
    }
}
