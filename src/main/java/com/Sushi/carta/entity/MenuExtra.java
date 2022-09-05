
package com.Sushi.carta.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MenuExtra {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String nombreCombo;
   private String cantidad;
   private String nombreRolls;
   private String precioCombo;

    public MenuExtra() {
    }

    public MenuExtra(String nombreCombo, String cantidad, String nombreRolls, String precioCombo) {
        this.nombreCombo = nombreCombo;
        this.cantidad = cantidad;
        this.nombreRolls = nombreRolls;
        this.precioCombo = precioCombo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCombo() {
        return nombreCombo;
    }

    public void setNombreCombo(String nombreCombo) {
        this.nombreCombo = nombreCombo;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreRolls() {
        return nombreRolls;
    }

    public void setNombreRolls(String nombreRolls) {
        this.nombreRolls = nombreRolls;
    }

    public String getPrecioCombo() {
        return precioCombo;
    }

    public void setPrecioCombo(String precioCombo) {
        this.precioCombo = precioCombo;
    }
   
   
}

