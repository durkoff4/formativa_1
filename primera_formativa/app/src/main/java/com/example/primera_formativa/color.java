package com.example.primera_formativa;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class color extends AppCompatActivity {

    Button cambio_color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        cambio_color = findViewById(R.id.cambiar_color_background);

        ConstraintLayout colores = findViewById(R.id.color);
        Random random = new Random();
        int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256)); // Genera un color aleatorio
        colores.setBackgroundColor(color);

        cambio_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256)); // Genera un color aleatorio
                colores.setBackgroundColor(color);
            }
        });


    }
}