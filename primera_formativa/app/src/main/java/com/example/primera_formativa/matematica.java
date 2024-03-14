package com.example.primera_formativa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class matematica extends AppCompatActivity {

    EditText puntoA, puntoB, resultado;
    Button calcular;
    ImageButton atraz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matematica);
        puntoA=(EditText) findViewById(R.id.puntoA);
        puntoB=(EditText) findViewById(R.id.puntoB);
        resultado=(EditText) findViewById(R.id.resultado_puntos);
        calcular= (Button) findViewById(R.id.calcular_dos_puntos);
        atraz= (ImageButton) findViewById(R.id.atraz_matematica);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] PA= puntoA.getText().toString().split(",");
                String[] PB= puntoB.getText().toString().split(",");
                int x1 = Integer.parseInt(PA[0]);
                int y1 = Integer.parseInt(PA[1]);
                int x2 = Integer.parseInt(PB[0]);
                int y2 = Integer.parseInt(PB[1]);

                double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
                resultado.setText(String.valueOf(distancia));
            }
        });

        atraz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), home.class);
                startActivity(i);
            }
        });
    }
}