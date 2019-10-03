package com.eiv.entities;

public class BeneficiarioEntity {
    private Long id;
    private String nombre;
    private String apellido;
    private String nroDocumento;
    private String nroCuil;
    private String domicilio;
    private String sexo;
    
    public BeneficiarioEntity() { }

    public BeneficiarioEntity(Long id, String nombre, String apellido, String nroDocumento,
            String nroCuil, String domicilio, String sexo) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nroDocumento = nroDocumento;
        this.nroCuil = nroCuil;
        this.domicilio = domicilio;
        this.sexo = sexo;
    }

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
    
    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getNroDocumento() {
        return nroDocumento;
    }
    
    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }
    
    public String getNroCuil() {
        return nroCuil;
    }
    
    public void setNroCuil(String nroCuil) {
        this.nroCuil = nroCuil;
    }
    
    public String getDomicilio() {
        return domicilio;
    }
    
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    
    public String getSexo() {
        return sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    @Override
    public String toString() {
        return String.format("BeneficiarioEntity: [id=%s, Nombre=%s, Apellido=%s, Sexo=%s, "
                + "Domicilio=%s, Nro. Documento=%s, Nro. Cuil=%s]", id, nombre, apellido, sexo, 
                domicilio, nroDocumento, nroCuil);
    }

}
