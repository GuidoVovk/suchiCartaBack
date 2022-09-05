
package com.Sushi.carta.dto;

import javax.validation.constraints.NotBlank;


public class DtoMenuExtra {
    @NotBlank
    private String nombreCombo;
    private String cantidad;
    @NotBlank
    private String nombreRolls;
    private String precioCombo;

    public DtoMenuExtra() {
    }

    public DtoMenuExtra(String nombreCombo, String cantidad, String nombreRolls, String precioCombo) {
        this.nombreCombo = nombreCombo;
        this.cantidad = cantidad;
        this.nombreRolls = nombreRolls;
        this.precioCombo = precioCombo;
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
