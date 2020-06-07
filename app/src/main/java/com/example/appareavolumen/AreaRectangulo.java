package com.example.appareavolumen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AreaRectangulo extends AppCompatActivity {
    private EditText txt_base, txt_altura;
    private Double base, altura, resultado;
    private TextView lbl_resultado, lbl_area;
    String tipo_operacion,figura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_rectangulo);

        txt_base = findViewById(R.id.txtBase);
        txt_altura = findViewById(R.id.txtAltura);
        lbl_resultado = findViewById(R.id.lblMuestraResultadoCua);
        lbl_area = findViewById(R.id.lblResAreaRec);
        lbl_area.setText("");
    }

    public void calcular(View v) {
        if (validar()) {
            String str_res, str_dato, str_dato1;
            String str_muestra_ope;

            base = Double.parseDouble(txt_base.getText().toString());
            altura = Double.parseDouble(txt_altura.getText().toString());
            resultado = Double.parseDouble(txt_altura.getText().toString());
            resultado = base * altura;
            str_muestra_ope = getResources().getString(R.string.area_rectangulo);
            str_dato= String.valueOf(base);
            str_dato1 = String.valueOf(altura);
            str_dato= "b="+str_dato+" h="+str_dato1;
            str_res = String.valueOf(String.format("%.2f", resultado));
            Operacion operacion= new Operacion(str_muestra_ope, str_dato, str_res);
            operacion.guardar();

            lbl_area.setText(getResources().getString(R.string.lbl_res_area));
            lbl_resultado.setText("" + resultado);
        }
    }
        public void borrar (View v){
            txt_base.setText("");
            txt_altura.setText("");
            lbl_resultado.setText("");
            lbl_area.setText("");
        }


    public boolean validar(){
        boolean res;
        String error_base, error_altura;
        res = true;
        error_base = getResources().getString(R.string.error_base);
        error_altura = getResources().getString(R.string.error_altura);
        if (txt_base.getText().toString().isEmpty() || txt_base.getText().toString().equals("0")){
            txt_base.setError(error_base);
            txt_base.requestFocus();
            res = false;
        } else if (txt_altura.getText().toString().isEmpty() || txt_altura.getText().toString().equals("0")){
            txt_altura.setError(error_altura);
            txt_altura.requestFocus();
            res = false;
        }

        return res;
    }
}
