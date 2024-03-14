package com.example.primera_formativa;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity //implements View.OnClickListener
{

    Button ingresar, cancelar;
    EditText usuario, password;
    CheckBox terminos_condiciones;
    ImageButton revelar;
    ProgressBar barra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = (EditText) findViewById(R.id.ing_usuario);
        password = (EditText) findViewById(R.id.ing_password);
        ingresar = (Button) findViewById(R.id.ingresar);
        cancelar = (Button) findViewById(R.id.cancelar);
        revelar = (ImageButton) findViewById(R.id.revelar);
        barra = (ProgressBar) findViewById(R.id.barra_p);
        terminos_condiciones = (CheckBox) findViewById(R.id.terminos_condiciones);

        barra.setVisibility(View.INVISIBLE);

        revelar.setOnClickListener(new View.OnClickListener() {
            boolean password_mostrar = false;
            @Override
            public void onClick(View v) {
                if (!password_mostrar) {
                    password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    password_mostrar = true;
                } else {
                    password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    password_mostrar = false;
                }
                password.setSelection(password.getText().length());
            }
        });

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View main) {
                if (terminos_condiciones.isChecked()) {
                    if (usuario.getText().toString().equalsIgnoreCase("Admin") &&
                            password.getText().toString().equalsIgnoreCase("admin123")) {
                        barra.setVisibility(View.VISIBLE);
                        Handler manejador = new Handler();
                        manejador.post(new Runnable() {
                            int progreso = 0;
                            @Override
                            public void run() {
                                if (progreso <= 100) {
                                    barra.setProgress(progreso);
                                    progreso += 100/(2000/20);
                                    manejador.postDelayed(this, 20);
                                } else {
                                    barra.setVisibility(View.GONE);
                                    Intent i = new Intent(getApplicationContext(), home.class);
                                    startActivity(i);
                                }
                            }
                        });
                    }

                    else {
                        Toast.makeText(getApplicationContext(), "Credenciales Incorrectas",
                                Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Por favor aceptar terminos y condiciones",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View main
            ) {
                usuario.setText("");
                password.setText("");
            }
        });
    }
}