package com.ropalinda.ropalindamovil.Entities;

public class Prenda {

    private int id;
    private int idPrenda;
    private String categoriaPrenda;
    private String subCategoriaPrenda;
    private String nombrePrenda;
    private int precioPrenda;
    private String imagenPrenda;

    public Prenda(int id, int idPrenda, String categoriaPrenda, String subCategoriaPrenda, String nombrePrenda, int precioPrenda, String imagenPrenda) {
        this.id = id;
        this.idPrenda = idPrenda;
        this.categoriaPrenda = categoriaPrenda;
        this.subCategoriaPrenda = subCategoriaPrenda;
        this.nombrePrenda = nombrePrenda;
        this.precioPrenda = precioPrenda;
        this.imagenPrenda = imagenPrenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPrenda() {
        return idPrenda;
    }

    public void setIdPrenda(int idPrenda) {
        this.idPrenda = idPrenda;
    }

    public String getCategoriaPrenda() {
        return categoriaPrenda;
    }

    public void setSubCategoriaPrenda(String subCategoriaPrenda) {
        this.subCategoriaPrenda = subCategoriaPrenda;
    }

    public String getSubCategoriaPrenda() {
        return subCategoriaPrenda;
    }

    public void setCategoriaPrenda(String categoriaPrenda) {
        this.categoriaPrenda = categoriaPrenda;
    }

    public String getNombrePrenda() {
        return nombrePrenda;
    }

    public void setNombrePrenda(String nombrePrenda) {
        this.nombrePrenda = nombrePrenda;
    }

    public int getPrecioPrenda() {
        return precioPrenda;
    }

    public void setPrecioPrenda(int precioPrenda) {
        this.precioPrenda = precioPrenda;
    }

    public String getImagenPrenda() {
        return imagenPrenda;
    }

    public void setImagenPrenda(String imagenPrenda) {
        this.imagenPrenda = imagenPrenda;
    }

}
