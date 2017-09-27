package com.example.android.celulares;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Reporte1 extends AppCompatActivity {

    private TableLayout tabla;
    private ArrayList<Celular> celulares;
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte1);
        tabla = (TableLayout)findViewById(R.id.rep1);
        celulares = Datos.obtener();
        resources = this.getResources();

        for (int i = 0; i <celulares.size() ; i++) {
            String marca = celulares.get(i).getMarca();
            String color = celulares.get(i).getColor();
            String sistOp = celulares.get(i).getSo();
            if((marca.equals(resources.getString(R.string.samsung)) && (color.equals(resources.getString(R.string.negro)))
                    && sistOp.equals(resources.getString(R.string.android)))) {
                TableRow fila = new TableRow(this);
                TextView c1 = new TextView(this);
                TextView c2 = new TextView(this);
                TextView c3 = new TextView(this);

                c1.setText(""+(i+1));
                c2.setText(""+celulares.get(i).getCapacidad());
                c3.setText(""+celulares.get(i).getPrecio());

                fila.addView(c1);
                fila.addView(c2);
                fila.addView(c3);

                tabla.addView(fila);
            }
        }
    }
}
