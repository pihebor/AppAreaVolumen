package com.example.appareavolumen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AreaCirculo extends AppCompatActivity {
    private EditText txt_radio;
    private Double radio, resultado_cir;
    private TextView lbl_resultado_cir, lbl_area_cir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_circulo);

        txt_radio = findViewById(R.id.txtRadio);
        lbl_resultado_cir = findViewById(R.id.lblMuestraResultadoCir);
        lbl_area_cir = findViewById(R.id.lblResAreaCir);
        lbl_area_cir.setText("");

    }

    public void calcular(View v) {
        if (validar()) {

            String str_res, str_dato;
            String str_muestra_ope;

            radio = Double.parseDouble(txt_radio.getText().toString());
            //resultado_cir = Double.parseDouble(txt_altura.getText().toString());
            resultado_cir = Math.PI*(Math.pow(radio,2));

            str_muestra_ope = getResources().getString(R.string.area_circulo);
            str_dato= String.valueOf(radio);
            str_dato= "r="+str_dato;
            str_res = String.valueOf(String.format("%.2f", resultado_cir));
            Operacion operacion= new Operacion(str_muestra_ope, str_dato, str_res);
            operacion.guardar();

            lbl_area_cir.setText(getResources().getString(R.string.lbl_res_area));
            lbl_resultado_cir.setText("" + resultado_cir);
        }
    }

    public void borrar (View v){
        txt_radio.setText("");
        lbl_resultado_cir.setText("");
        lbl_area_cir.setText("");
    }

    public boolean validar(){
        boolean res;
        String error_radio;
        res = true;
        error_radio = getResources().getString(R.string.error_radio);
        if (txt_radio.getText().toString().isEmpty() || txt_radio.getText().toString().equals("0")){
            txt_radio.setError(error_radio);
            txt_radio.requestFocus();
            res = false;
        }
        return res;
    }
}
