
package com.Sushi.carta.dto;


public class DtoAdicional {
    private String nombreA;
    private String precioA;
    private String precioB;
    private String precioEnvio;
    private String precioEnvioDos;

    public DtoAdicional() {
    }

    public DtoAdicional(String nombreA, String precioA, String precioB, String precioEnvio, String precioEnvioDos) {
        this.nombreA = nombreA;
        this.precioA = precioA;
        this.precioB = precioB;
        this.precioEnvio = precioEnvio;
        this.precioEnvioDos = precioEnvioDos;
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
