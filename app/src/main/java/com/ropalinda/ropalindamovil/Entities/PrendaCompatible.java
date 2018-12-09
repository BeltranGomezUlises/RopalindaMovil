package com.ropalinda.ropalindamovil.Entities;

public class PrendaCompatible {

    private int precio;
    private int id;
    private int nombre;
    private String descripcion;
    private String previewImage;
    private String imagen;
    private boolean active;

    public PrendaCompatible(int precio, int id, int nombre, String descripcion, String previewImage, String imagen, boolean active) {
        this.precio = precio;
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.previewImage = previewImage;
        this.imagen = imagen;
        this.active = active;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPreviewImage() {
        return previewImage;
    }

    public void setPreviewImage(String previewImage) {
        this.previewImage = previewImage;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
