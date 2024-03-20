package com.example.primera_formativa;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class texto extends AppCompatActivity {

    EditText txt;
    CheckBox negrita, cursiva;
    Button agrandar, reducir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texto);
        txt = (EditText) findViewById(R.id.txt);
        agrandar = (Button) findViewById(R.id.aumentar_txt);
        reducir = (Button) findViewById(R.id.disminuir_txt);
        negrita = (CheckBox) findViewById(R.id.negrita);
        cursiva = (CheckBox) findViewById(R.id.cursiva);

        negrita.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateTextStyle();
            }
        });

        cursiva.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateTextStyle();
            }
        });


        agrandar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float T_acutual = txt.getTextSize();
                float nuevo_t = T_acutual + 2;
                txt.setTextSize(TypedValue.COMPLEX_UNIT_PX, nuevo_t);
            }
        });

        reducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float T_acutual = txt.getTextSize();
                float newSizePx = T_acutual - 2;
                if (newSizePx < 1) {
                    newSizePx = 1;
                }
                txt.setTextSize(TypedValue.COMPLEX_UNIT_PX, newSizePx);
            }
        });
    }
    private void updateTextStyle() {
        int style = Typeface.NORMAL;
        if (negrita.isChecked()) {
            style |= Typeface.BOLD;
        }
        if (cursiva.isChecked()) {
            style |= Typeface.ITALIC;
        }
        txt.setTypeface(null, style);
    }
}
