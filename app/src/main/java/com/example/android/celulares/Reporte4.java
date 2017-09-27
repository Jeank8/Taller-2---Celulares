package com.example.android.celulares;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Reporte4 extends AppCompatActivity {

    private TableLayout tabla;
    private ArrayList<Celular> celulares;
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte4);
        tabla = (TableLayout)findViewById(R.id.rep4);
        celulares = Datos.obtener();
        resources = this.getResources();

        for (int i = 0; i <celulares.size() ; i++) {
            String marca = celulares.get(i).getMarca();
            String color = celulares.get(i).getColor();
            if((marca.equals(resources.getString(R.string.apple)) && (color.equals(resources.getString(R.string.negro))))) {
                TableRow fila = new TableRow(this);
                TextView c1 = new TextView(this);
                TextView c2 = new TextView(this);
                TextView c3 = new TextView(this);
                TextView c4 = new TextView(this);
                TextView c5 = new TextView(this);
                TextView c6 = new TextView(this);

                c1.setText(""+(i+1));
                c2.setText(celulares.get(i).getMarca());
                c3.setText(celulares.get(i).getSo());
                c4.setText(""+celulares.get(i).getCapacidad());
                c5.setText(celulares.get(i).getColor());
                c6.setText(""+celulares.get(i).getPrecio());

                fila.addView(c1);
                fila.addView(c2);
                fila.addView(c3);
                fila.addView(c4);
                fila.addView(c5);
                fila.addView(c6);

                tabla.addView(fila);
            }
        }
    }
}
