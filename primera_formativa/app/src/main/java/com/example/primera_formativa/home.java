package com.example.primera_formativa;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class home extends AppCompatActivity //implements View.OnClickListener
{
    Button matematicas, fisica, texto, salir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        matematicas = (Button) findViewById(R.id.math);
        fisica = (Button) findViewById(R.id.physics);
        texto = (Button) findViewById(R.id.textos);
        salir = (Button) findViewById(R.id.out);

        matematicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View home) {
                Intent i = new Intent(home.this, matematica.class);
                startActivity(i);

            }
        });

        fisica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View home) {
                Intent i = new Intent(getApplicationContext(), fisica.class);
                startActivity(i);
            }
        });

        texto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View home) {
                Intent i = new Intent(getApplicationContext(), texto.class);
                startActivity(i);
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View home) {
                finishAffinity();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.temperature) {
            Intent i = new Intent(getApplicationContext(), temperatura.class);
            startActivity(i);
            return true;
        } else {
            if (id == R.id.cambio_color) {
                getClass();
                Intent i = new Intent(getApplicationContext(), color.class);
                startActivity(i);
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}