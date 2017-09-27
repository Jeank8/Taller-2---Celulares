package com.example.android.celulares;

import java.util.ArrayList;

/**
 * Created by android on 26/09/2017.
 */

public class Datos {
    private static ArrayList<Celular> celulares = new ArrayList<>();

    public static void guardar(Celular c){
        celulares.add(c);
    }

    public static ArrayList<Celular> obtener(){
        return celulares;
    }
}
