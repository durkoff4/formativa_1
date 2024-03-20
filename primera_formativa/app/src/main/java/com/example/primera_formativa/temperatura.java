package com.example.primera_formativa;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class temperatura extends AppCompatActivity {

    Spinner medidas_t;
    EditText celcius, transformar;
    TextView grados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);
        medidas_t = findViewById(R.id.medidas_temperatura);
        celcius = findViewById(R.id.celcius);
        transformar = findViewById(R.id.F_K_R);
        grados = findViewById(R.id.grados);

        medidas_t.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String celciusTxt = celcius.getText().toString();
                if (!TextUtils.isEmpty(celciusTxt)) {
                    float C = Float.parseFloat(celciusTxt);
                    String temperaturas = "";
                    switch (position) {
                        case 0:
                            temperaturas = "grados fahrenheit";
                            grados.setText(temperaturas);
                            transformar.setText(String.format(Locale.ENGLISH,"%.2f", (C * 9 / 5) + 32));
                            break;
                        case 1:
                            temperaturas = "grados kelvin";
                            grados.setText(temperaturas);
                            transformar.setText(String.format(Locale.ENGLISH,"%.2f", C + 273.15));
                            break;
                        case 2:
                            temperaturas = "grados rankine";
                            grados.setText(temperaturas);
                            double rankine = 1.8 * (C + 273.15);
                            transformar.setText(String.format(Locale.ENGLISH,"%.2f", rankine));
                            break;
                    }
                } else {
                    transformar.setText("");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });


    }
}
