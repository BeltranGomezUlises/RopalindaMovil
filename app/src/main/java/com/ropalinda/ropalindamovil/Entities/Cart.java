package com.ropalinda.ropalindamovil.Entities;

import java.util.ArrayList;

public class Cart {

    private ArrayList<Productos> productosCart = new ArrayList<>();

    public Productos getProductosCart(int position) {
        return productosCart.get(position);
    }

    public void setProductosCart(Productos productos) {
        productosCart.add(productos);
    }

    public int getCartSize(){
        return productosCart.size();
    }

    public boolean tieneProducto(Productos producto){
        return productosCart.contains(producto);
    }

}