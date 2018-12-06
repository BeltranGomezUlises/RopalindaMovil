package com.ropalinda.ropalindamovil.Entities;

import java.util.ArrayList;

public class CartEntity {

    private ArrayList<ModeloProductos> productosCart = new ArrayList<>();

    public ModeloProductos getProductosCart(int position) {
        return productosCart.get(position);
    }

    public void setProductosCart(ModeloProductos productos) {
        productosCart.add(productos);
    }

    public int getCartSize(){
        return productosCart.size();
    }

    public boolean tieneProducto(ModeloProductos producto){
        return productosCart.contains(producto);
    }

}