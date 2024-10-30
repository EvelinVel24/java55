package com.edutecno.modelo;

import java.util.Date;

public class Horoscopo {
    private String animal;
    private Date fechaInicio;
    private Date fechaFin;

    public Horoscopo(String animal, Date fechaInicio, Date fechaFin) {
        this.animal = animal;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // Getters y Setters
}
