package com.apicalendario.modelo;

public class RespuestaFestivo {

    private boolean esFestivo;
    private String nombre;

    public boolean isEsFestivo() {
        return esFestivo;
    }

    public void setEsFestivo(boolean esFestivo) {
        this.esFestivo = esFestivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}