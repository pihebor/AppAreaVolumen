package com.example.appareavolumen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AreaTriangulo extends AppCompatActivity {
    private EditText txt_base_tri, txt_altura_tri;
    private Double base, altura, resultado;
    private TextView lbl_resultado_tri, lbl_area_tri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_triangulo);

        txt_base_tri = findViewById(R.id.txtBaseTri);
        txt_altura_tri = findViewById(R.id.txtAlturaTri);
        lbl_resultado_tri = findViewById(R.id.lblMuestraResTri);
        lbl_area_tri = findViewById(R.id.lblAreaTri);
        lbl_area_tri.setText("");
    }
    public void calcular(View v) {
        if (validar()) {

            String str_res, str_dato, str_dato1;
            String str_muestra_ope;

            base = Double.parseDouble(txt_base_tri.getText().toString());
            altura = Double.parseDouble(txt_altura_tri.getText().toString());
            resultado = Double.parseDouble(txt_altura_tri.getText().toString());
            resultado = (base * altura)/2;

            str_muestra_ope = "Area del Triangulo";
            str_dato= String.valueOf(base);
            str_dato1 = String.valueOf(altura);
            str_dato= "b="+str_dato+" h="+str_dato1;
            str_res = String.valueOf(String.format("%.2f", resultado));
            Operacion operacion= new Operacion(str_muestra_ope, str_dato, str_res);
            operacion.guardar();

            lbl_area_tri.setText("Area");
            lbl_resultado_tri.setText("" + resultado);
        }
    }
    public void borrar (View v){
        txt_base_tri.setText("");
        txt_altura_tri.setText("");
        lbl_resultado_tri.setText("");
        lbl_area_tri.setText("");
    }


    public boolean validar(){
        boolean res;
        String error_base, error_altura;
        res = true;
        error_base = getResources().getString(R.string.error_base);
        error_altura = getResources().getString(R.string.error_altura);
        if (txt_base_tri.getText().toString().isEmpty() || txt_base_tri.getText().toString().equals("0")){
            txt_base_tri.setError(error_base);
            txt_base_tri.requestFocus();
            res = false;
        } else if (txt_altura_tri.getText().toString().isEmpty() || txt_altura_tri.getText().toString().equals("0")){
            txt_altura_tri.setError(error_altura);
            txt_altura_tri.requestFocus();
            res = false;
        }

        return res;
    }
}
