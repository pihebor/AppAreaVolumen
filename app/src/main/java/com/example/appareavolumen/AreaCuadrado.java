package com.example.appareavolumen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.autofill.FieldClassification;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AreaCuadrado extends AppCompatActivity {
    private double result_area, lado;
    private EditText txt_lado;
    private TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_cuadrado);

        txt_lado = findViewById(R.id.txtLado);
        resultado = findViewById(R.id.lblMuestraResultado);
        /*/lado = Double.parseDouble(txt_lado.getText().toString());
        result_area = Math.pow(lado, 2);*/


    }

    public void calcular(View v){
        lado = Double.parseDouble(txt_lado.getText().toString());
        result_area = Math.pow(lado, 2);
        resultado.setText("" + result_area);
    }
}
