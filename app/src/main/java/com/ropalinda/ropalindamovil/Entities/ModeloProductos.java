package com.ropalinda.ropalindamovil.Entities;

public class ModeloProductos {

    private int id;
    private int idProduto;
    private String categoriaProducto;
    private String nombreProducto;
    private int precioProcto;
    private String imagenProducto;

    public ModeloProductos(int id, int idProduto, String categoriaProducto, String nombreProducto, int precioProcto, String imagenProducto) {
        this.id = id;
        this.idProduto = idProduto;
        this.categoriaProducto = categoriaProducto;
        this.nombreProducto = nombreProducto;
        this.precioProcto = precioProcto;
        this.imagenProducto = imagenProducto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getPrecioProcto() {
        return precioProcto;
    }

    public void setPrecioProcto(int precioProcto) {
        this.precioProcto = precioProcto;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }
}
