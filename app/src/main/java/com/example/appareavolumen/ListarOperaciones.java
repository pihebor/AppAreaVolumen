package com.example.appareavolumen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ListarOperaciones extends AppCompatActivity {
    private TableLayout tabla;
    private ArrayList<Operacion> operacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_operaciones);

        tabla = findViewById(R.id.tblOperacionesRea);
        operacion = Datos.obtener();

        for (int i = 0; i < operacion.size(); i++){
            TableRow fila = new TableRow(this);

            TextView columna_uno =new TextView(this);
            TextView columna_dos =new TextView(this);
            TextView columna_tres =new TextView(this);
            TextView columna_cuatro =new TextView(this);

            columna_uno.setText(""+(i+1));
            columna_dos.setText(operacion.get(i).getOperacion());
            columna_tres.setText(operacion.get(i).getDato());
            columna_cuatro.setText(operacion.get(i).getResultado());

            fila.addView(columna_uno);
            fila.addView(columna_dos);
            fila.addView(columna_tres);
            fila.addView(columna_cuatro);

            tabla.addView(fila);
        }
    }
}
