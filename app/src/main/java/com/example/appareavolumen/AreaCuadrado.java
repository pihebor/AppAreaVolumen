package com.example.appareavolumen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AreaCuadrado extends AppCompatActivity {
    private double result_area, lado;
    private EditText txt_lado;
    private TextView resultado, lbl_area;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_cuadrado);

        txt_lado = findViewById(R.id.txtLado);
        resultado = findViewById(R.id.lblMuestraResultadoCua);
        lbl_area = findViewById(R.id.lblResAreaCua);
        lbl_area.setText("");
    }

    public void calcular(View v) {
        if (validar()) {

            String str_res, str_dato;
            String str_muestra_ope;

            lado = Double.parseDouble(txt_lado.getText().toString());
            result_area = Math.pow(lado, 2);

            str_muestra_ope = getResources().getString(R.string.area_cuadrado);
            str_dato= String.valueOf(lado);
            str_dato= "L="+str_dato;
            str_res = String.valueOf(result_area);
            Operacion operacion= new Operacion(str_muestra_ope, str_dato, str_res);
            operacion.guardar();

            lbl_area.setText(getResources().getString(R.string.lbl_res_area));
            resultado.setText("" + result_area);
        }
    }

    public void borrar(View v){
        resultado.setText("");
        txt_lado.setText("");
        lbl_area.setText("");
        txt_lado.requestFocus();
    }

    public boolean validar(){
        boolean res;
        String error_lado;
        res = true;
        error_lado = getResources().getString(R.string.error_lado);
        if (txt_lado.getText().toString().isEmpty() || txt_lado.getText().toString().equals("0")){
            txt_lado.setError(error_lado);
            txt_lado.requestFocus();
            res = false;
        }
        return res;
    }
}
