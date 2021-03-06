package com.example.appareavolumen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class VolumenCubo extends AppCompatActivity {
    private EditText txt_arista_cubo;
    private Double arista_cubo, resultado_cubo;
    private TextView lbl_resultado_cubo, lbl_arista_cubo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen_cubo);

        txt_arista_cubo = findViewById(R.id.txtAristaCubo);
        lbl_resultado_cubo = findViewById(R.id.lblMuestraResVolumenCubo);
        lbl_arista_cubo = findViewById(R.id.lblResVolumenCubo);
        lbl_arista_cubo.setText("");
    }

    public void calcular(View v) {
        if (validar()) {

            String str_res, str_dato;
            String str_muestra_ope;

            arista_cubo = Double.parseDouble(txt_arista_cubo.getText().toString());
            resultado_cubo = Math.pow(arista_cubo,3);

            str_muestra_ope = getResources().getString(R.string.volumen_cubo);
            str_dato= String.valueOf(arista_cubo);
            str_dato= "Arista="+str_dato;
            str_res = String.valueOf(String.format("%.2f", resultado_cubo));
            Operacion operacion= new Operacion(str_muestra_ope, str_dato, str_res);
            operacion.guardar();

            lbl_arista_cubo.setText(getResources().getString(R.string.lbl_volumen));
            lbl_resultado_cubo.setText("" + resultado_cubo);
        }
    }

    public void borrar (View v){
        txt_arista_cubo.setText("");
        lbl_resultado_cubo.setText("");
        lbl_arista_cubo.setText("");
        txt_arista_cubo.requestFocus();

    }

    public boolean validar() {
        boolean res;
        String error_arista;
        res = true;
        error_arista = getResources().getString(R.string.error_arista);
        if (txt_arista_cubo.getText().toString().isEmpty() || txt_arista_cubo.getText().toString().equals("0")) {
            txt_arista_cubo.setError(error_arista);
            txt_arista_cubo.requestFocus();
            res = false;
        }
        return res;
    }
}
