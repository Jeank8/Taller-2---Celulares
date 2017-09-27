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
        if (validar()) {
            mar = marcas.getSelectedItem().toString();
            sisop = sop.getSelectedItem().toString();
            cap = Integer.parseInt(capacidad.getText().toString());
            col = colores.getSelectedItem().toString();
            pre = Double.parseDouble(precio.getText().toString());

            Celular c = new Celular(mar, sisop, cap, col, pre);
            c.guardar();
            borrar(v);
            Toast.makeText(this, resources.getString(R.string.mensaje_exitoso), Toast.LENGTH_SHORT).show();
        }
    }

    public boolean validar(){
        if(capacidad.getText().toString().isEmpty()){
            capacidad.setError(getResources().getString(R.string.error_1));
            return false;
        }
        if(precio.getText().toString().isEmpty()){
            precio.setError(getResources().getString(R.string.error_2));
            return false;
        }
        if((Integer.parseInt(capacidad.getText().toString())==0)){
            Toast.makeText(this, resources.getString(R.string.error_cero), Toast.LENGTH_SHORT).show();
            return false;
        }
        if((Double.parseDouble(precio.getText().toString())==0)){
            Toast.makeText(this, resources.getString(R.string.error_cero), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void borrar(View v){
        marcas.setSelection(0);
        sop.setSelection(0);
        capacidad.setText("");
        colores.setSelection(0);
        precio.setText("");
        capacidad.requestFocus();
    }
}
