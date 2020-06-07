package com.example.appareavolumen;

import java.util.ArrayList;

public class Datos {
    private static ArrayList<Operacion> operacion = new ArrayList();

    public static void guardar(Operacion o){
        operacion.add(o);
    }

    public static ArrayList<Operacion> obtener(){
        return operacion;
    }
}
