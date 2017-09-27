package com.example.android.celulares;

/**
 * Created by android on 26/09/2017.
 */

public class Celular {
    private String marca;
    private String so;
    private int capacidad;
    private String color;
    private double precio;

    public Celular(String marca, String so, int capacidad, String color, double precio) {
        this.marca = marca;
        this.so = so;
        this.capacidad = capacidad;
        this.color = color;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void guardar(){
        Datos.guardar(this);
    }
}
