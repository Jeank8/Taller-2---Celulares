package com.example.android.celulares;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CrearCelular extends AppCompatActivity {

    private EditText capacidad, precio;
    private Spinner marcas, sop, colores;
    private Resources resources;
    private String marca[], so[], color[];
    private ArrayAdapter<String> marcasOpc, sopOpc, coloresOpc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_celular);

        marcas = (Spinner)findViewById(R.id.cmbMarca);
        sop = (Spinner)findViewById(R.id.cmbSO);
        capacidad = (EditText)findViewById(R.id.txtCapacidad);
        colores = (Spinner)findViewById(R.id.cmbColor);
        precio = (EditText)findViewById(R.id.txtPrecio);
        resources = this.getResources();

        marca = getResources().getStringArray(R.array.marcas);
        so = getResources().getStringArray(R.array.sop);
        color = getResources().getStringArray(R.array.colores);

        marcasOpc = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, marca);
        sopOpc = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, so);
        coloresOpc = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, color);

        marcas.setAdapter(marcasOpc);
        sop.setAdapter(sopOpc);
        colores.setAdapter(coloresOpc);
    }

    public void guardar(View v){
        String mar,sisop,col;
        int cap;
        double pre;
        mar = marcas.getSelectedItem().toString();
        sisop = sop.getSelectedItem().toString();
        cap = Integer.parseInt(capacidad.getText().toString());
        col = colores.getSelectedItem().toString();
        pre = Double.parseDouble(precio.getText().toString());

        Celular c = new Celular(mar,sisop,cap,col,pre);
        c.guardar();
        Toast.makeText(this,resources.getString(R.string.mensaje_exitoso),Toast.LENGTH_SHORT).show();
    }
}
