package com.eiv.entities;

import com.eiv.annotations.Mappeable;
import com.eiv.annotations.MappedTo;

@Mappeable
public class TitularCodigo {
    @MappedTo(columnName = "id")
    private Long id;
    @MappedTo(columnName = "nombre")
    private String nombre;
    @MappedTo(columnName = "nombre_abreviado")
    private String nombreAbreviado;
    @MappedTo(columnName = "direccion")
    private String direccion;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombreAbreviado() {
        return nombreAbreviado;
    }
    
    public void setNombreAbreviado(String nombreAbreviado) {
        this.nombreAbreviado = nombreAbreviado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "TitularCodigo: [id=" + id + ", nombre=" + nombre + ", nombreAbreviado=" 
                + nombreAbreviado + ", direccion=" + direccion + "]";
    }   
}
