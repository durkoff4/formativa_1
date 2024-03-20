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

public class fisica extends AppCompatActivity {

    EditText Masa , Fuerza, Acceleracion;
    Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fisica);
        Masa=(EditText) findViewById(R.id.Masa);
        Fuerza=(EditText) findViewById(R.id.fuerza);
        Acceleracion=(EditText) findViewById(R.id.acceleracion);
        calcular= (Button) findViewById(R.id.calcular_fuerza);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int mass = Integer.parseInt(String.valueOf(Masa.getText()));
                int accelerar = Integer.parseInt(String.valueOf(Acceleracion.getText()));
                int force = mass * accelerar;
                Fuerza.setText(String.valueOf(force));
            }
        });
    }
}