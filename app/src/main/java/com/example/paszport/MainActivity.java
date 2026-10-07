package com.example.paszport;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tekstWyniku;
    private EditText numerPaszportu;
    private EditText imieOsoby;
    private EditText nazwiskoOsoby;

    private ImageView zdjecieOsoby;
    private ImageView odciskOsoby;

    private RadioButton kolorNiebieski;
    private RadioButton kolorZielony;
    private RadioButton kolorPiwne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numerPaszportu = findViewById(R.id.numer);
        imieOsoby = findViewById(R.id.imie);
        nazwiskoOsoby = findViewById(R.id.nazwisko);

        zdjecieOsoby = findViewById(R.id.zdjecie);
        odciskOsoby = findViewById(R.id.odcisk);

        kolorNiebieski = findViewById(R.id.niebieskie);
        kolorZielony = findViewById(R.id.zielone);
        kolorPiwne = findViewById(R.id.piwne);

        tekstWyniku = findViewById(R.id.outputText);

        Button przyciskZatwierdz = findViewById(R.id.ok);

        numerPaszportu.setOnFocusChangeListener((view, hasFocus) -> {
            if (!hasFocus) {
                wyswietlZdjecia();
            }
        });

        przyciskZatwierdz.setOnClickListener(view -> wyswietlInformacje());
    }

    private void wyswietlZdjecia() {

        String numer = numerPaszportu.getText().toString().trim();

        if (numer.isEmpty()) {
            zdjecieOsoby.setImageDrawable(null);
            odciskOsoby.setImageDrawable(null);
            return;
        }

        int identyfikatorZdjecia = getResources().getIdentifier(
                "zdjecie" + numer,
                "drawable",
                getPackageName()
        );

        int identyfikatorOdcisku = getResources().getIdentifier(
                "odcisk" + numer,
                "drawable",
                getPackageName()
        );

        if (identyfikatorZdjecia != 0) {
            zdjecieOsoby.setImageResource(identyfikatorZdjecia);
        } else {
            zdjecieOsoby.setImageDrawable(null);
        }

        if (identyfikatorOdcisku != 0) {
            odciskOsoby.setImageResource(identyfikatorOdcisku);
        } else {
            odciskOsoby.setImageDrawable(null);
        }
    }

    private void wyswietlInformacje() {

        String imie = imieOsoby.getText().toString().trim();
        String nazwisko = nazwiskoOsoby.getText().toString().trim();

        if (TextUtils.isEmpty(imie) || TextUtils.isEmpty(nazwisko)) {

            Toast.makeText(
                    this,
                    "Wprowadź dane",
                    Toast.LENGTH_SHORT
            ).show();

            tekstWyniku.setText("Wprowadź dane");
            Log.d("PASSPORT_DATA", "brak danych");

            return;
        }

        String kolorOczu;

        if (kolorNiebieski.isChecked()) {
            kolorOczu = "niebieskie";
        } else if (kolorZielony.isChecked()) {
            kolorOczu = "zielone";
        } else {
            kolorOczu = "piwne";
        }

        String komunikat = imie + " " + nazwisko + " kolor oczu " + kolorOczu;

        Toast.makeText(
                this,
                komunikat,
                Toast.LENGTH_LONG
        ).show();

        tekstWyniku.setText(komunikat);
        Log.d("PASSPORT_OUTPUT", komunikat);
    }
}