package com.example.appareavolumen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class VolumenCilindro extends AppCompatActivity {
    private EditText txt_radio_cil, txt_altura_cil;
    private Double radio_cil, resultado_cil, altura_cil;
    private TextView lbl_resultado_cil, lbl_area_cil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen_cilindro);

        txt_radio_cil = findViewById(R.id.txtRadioCil);
        txt_altura_cil = findViewById(R.id.txtAlturaCil);
        lbl_resultado_cil = findViewById(R.id.lblMuestraResVolumenCil);
        lbl_area_cil = findViewById(R.id.lblResVolumenCil);
        lbl_area_cil.setText("");
    }
    public void calcular(View v) {
        if (validar()) {

            String str_res, str_dato, str_dato1;
            String str_muestra_ope;

            radio_cil = Double.parseDouble(txt_radio_cil.getText().toString());
            altura_cil = Double.parseDouble(txt_altura_cil.getText().toString());
            resultado_cil = Math.PI*(Math.pow(radio_cil,2))*altura_cil;

            str_muestra_ope = getResources().getString(R.string.volumen_cilindro);
            str_dato= String.valueOf(radio_cil);
            str_dato1 = String.valueOf(altura_cil);
            str_dato= "r="+str_dato+" h="+str_dato1;
            str_res = String.valueOf(String.format("%.2f", resultado_cil));
            Operacion operacion= new Operacion(str_muestra_ope, str_dato, str_res);
            operacion.guardar();

            lbl_area_cil.setText(getResources().getString(R.string.lbl_volumen));
            lbl_resultado_cil.setText("" + resultado_cil);
        }
    }

    public void borrar (View v){
        txt_radio_cil.setText("");
        txt_altura_cil.setText("");
        lbl_resultado_cil.setText("");
        lbl_area_cil.setText("");
        txt_radio_cil.requestFocus();

    }

    public boolean validar() {
        boolean res;
        String error_radio, error_altura;
        res = true;
        error_radio = getResources().getString(R.string.error_radio);
        error_altura = getResources().getString(R.string.error_altura);
        if (txt_radio_cil.getText().toString().isEmpty() || txt_radio_cil.getText().toString().equals("0")) {
            txt_radio_cil.setError(error_radio);
            txt_radio_cil.requestFocus();
            res = false;
        } else if (txt_altura_cil.getText().toString().isEmpty() || txt_altura_cil.getText().toString().equals("0")) {
            txt_altura_cil.setError(error_altura);
            txt_altura_cil.requestFocus();
            res = false;
        }
        return res;
    }
}
