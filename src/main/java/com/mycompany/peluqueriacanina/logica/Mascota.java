package com.mycompany.peluqueriacanina.logica;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

public class Mascota implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "numero_cliente", unique = true, nullable = false)
    private int numeroCliente;
    private String nombre;
    private String raza;
    private String color;
    private String alergico;
    private String atencionEspecial;
    private String observaciones;

    @OneToOne
    private Duenio duenio;

    public Mascota() {

    }

    public Mascota(int id, int numeroCliente, String nombre, String raza, String color, String alergico,
            String atencionEspecial, String observaciones, Duenio duenio) {
        this.id = id;
        this.numeroCliente = numeroCliente;
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
        this.alergico = alergico;
        this.atencionEspecial = atencionEspecial;
        this.observaciones = observaciones;
        this.duenio = duenio;
    }

    public Mascota(int numeroCliente, String nombre, String raza, String color, String alergico,
            String atencionEspecial, String observaciones, Duenio duenio) {
        this.numeroCliente = numeroCliente;
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
        this.alergico = alergico;
        this.atencionEspecial = atencionEspecial;
        this.observaciones = observaciones;
        this.duenio = duenio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAlergico() {
        return alergico;
    }

    public void setAlergico(String alergico) {
        this.alergico = alergico;
    }

    public String getAtencionEspecial() {
        return atencionEspecial;
    }

    public void setAtencionEspecial(String atencionEspecial) {
        this.atencionEspecial = atencionEspecial;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Duenio getDuenio() {
        return duenio;
    }

    public void setDuenio(Duenio duenio) {
        this.duenio = duenio;
    }

    @Override
    public String toString() {
        return "Mascota [id=" + id + ", numeroCliente=" + numeroCliente + ", nombre=" + nombre + ", raza=" + raza
                + ", color=" + color + ", alergico=" + alergico + ", atencionEspecial=" + atencionEspecial
                + ", observaciones=" + observaciones + ", duenio=" + duenio + "]";
    }

}
