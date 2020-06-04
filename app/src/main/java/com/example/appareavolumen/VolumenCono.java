package com.example.appareavolumen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class VolumenCono extends AppCompatActivity {
    private EditText txt_radio_cono, txt_altura_cono;
    private Double radio_cono, resultado_cono, altura_cono;
    private TextView lbl_resultado_cono, lbl_area_cono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen_cono);

        txt_radio_cono = findViewById(R.id.txtRadioCono);
        txt_altura_cono = findViewById(R.id.txtAlturaCono);
        lbl_resultado_cono = findViewById(R.id.lblMuestraResVolumenCono);
        lbl_area_cono = findViewById(R.id.lblResVolumenCono);
        lbl_area_cono.setText("");
    }

    public void calcular(View v) {
        if (validar()) {
            radio_cono = Double.parseDouble(txt_radio_cono.getText().toString());
            altura_cono = Double.parseDouble(txt_altura_cono.getText().toString());
            resultado_cono = (Math.PI*(Math.pow(radio_cono,2))*altura_cono)/3;

            lbl_area_cono.setText("Volumen");
            lbl_resultado_cono.setText("" + resultado_cono);
        }
    }

    public void borrar (View v){
        txt_radio_cono.setText("");
        txt_altura_cono.setText("");
        lbl_resultado_cono.setText("");
        lbl_area_cono.setText("");
        txt_radio_cono.requestFocus();

    }

    public boolean validar() {
        boolean res;
        String error_radio, error_altura;
        res = true;
        error_radio = getResources().getString(R.string.error_radio);
        error_altura = getResources().getString(R.string.error_altura);
        if (txt_radio_cono.getText().toString().isEmpty() || txt_radio_cono.getText().toString().equals("0")) {
            txt_radio_cono.setError(error_radio);
            txt_radio_cono.requestFocus();
            res = false;
        } else if (txt_altura_cono.getText().toString().isEmpty() || txt_altura_cono.getText().toString().equals("0")) {
            txt_altura_cono.setError(error_altura);
            txt_altura_cono.requestFocus();
            res = false;
        }
        return res;
    }
}
