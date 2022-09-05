
package com.Sushi.carta.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adicional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreA;
    private String precioA;
    private String precioB;
    private String precioEnvio;
    private String precioEnvioDos;

    public Adicional() {
    }

    public Adicional(String nombreA, String precioA, String precioB, String precioEnvio, String precioEnvioDos) {
        this.nombreA = nombreA;
        this.precioA = precioA;
        this.precioB = precioB;
        this.precioEnvio = precioEnvio;
        this.precioEnvioDos = precioEnvioDos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreA() {
        return nombreA;
    }

    public void setNombreA(String nombreA) {
        this.nombreA = nombreA;
    }

    public String getPrecioA() {
        return precioA;
    }

    public void setPrecioA(String precioA) {
        this.precioA = precioA;
    }

    public String getPrecioB() {
        return precioB;
    }

    public void setPrecioB(String precioB) {
        this.precioB = precioB;
    }

    public String getPrecioEnvio() {
        return precioEnvio;
    }

    public void setPrecioEnvio(String precioEnvio) {
        this.precioEnvio = precioEnvio;
    }

    public String getPrecioEnvioDos() {
        return precioEnvioDos;
    }

    public void setPrecioEnvioDos(String precioEnvioDos) {
        this.precioEnvioDos = precioEnvioDos;
    }

    
    
    
}
