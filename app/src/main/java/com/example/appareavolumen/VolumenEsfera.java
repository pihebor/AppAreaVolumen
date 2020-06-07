package com.example.appareavolumen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class VolumenEsfera extends AppCompatActivity {
    private EditText txt_radio_esf;
    private Double radio, resultado_esf;
    private TextView lbl_resultado_esf, lbl_area_esf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen_esfera);

        txt_radio_esf = findViewById(R.id.txtRadioEsf);
        lbl_resultado_esf = findViewById(R.id.lblMuestraResultadoEsf);
        lbl_area_esf = findViewById(R.id.lblResVolumenEsf);
        lbl_area_esf.setText("");
    }

    public void calcular(View v) {
        if (validar()) {

            String str_res, str_dato;
            String str_muestra_ope;

            radio = Double.parseDouble(txt_radio_esf.getText().toString());
            //resultado_cir = Double.parseDouble(txt_altura.getText().toString());
            resultado_esf = (4*Math.PI*(Math.pow(radio,3)))/3;

            str_muestra_ope = "Volumen de la Esfera";
            str_dato= String.valueOf(radio);
            str_dato= "r="+str_dato;
            str_res = String.valueOf(String.format("%.2f", resultado_esf));
            Operacion operacion= new Operacion(str_muestra_ope, str_dato, str_res);
            operacion.guardar();

            lbl_area_esf.setText("Volumen");
            lbl_resultado_esf.setText("" + resultado_esf);
        }
    }

    public void borrar (View v){
        txt_radio_esf.setText("");
        lbl_resultado_esf.setText("");
        lbl_area_esf.setText("");
    }

    public boolean validar(){
        boolean res;
        String error_radio;
        res = true;
        error_radio = getResources().getString(R.string.error_radio);
        if (txt_radio_esf.getText().toString().isEmpty() || txt_radio_esf.getText().toString().equals("0")){
            txt_radio_esf.setError(error_radio);
            txt_radio_esf.requestFocus();
            res = false;
        }
        return res;
    }
}
