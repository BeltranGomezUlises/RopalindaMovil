package com.ropalinda.ropalindamovil.Entities;

import android.support.v7.widget.RecyclerView;

public class CompatibleGarment{

    private int price;
    private int id;
    private String name;
    private String previewImage;

    public CompatibleGarment(int price, int id, String name, String previewImage) {
        this.price = price;
        this.id = id;
        this.name = name;
        this.previewImage = previewImage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreviewImage() {
        return previewImage;
    }

    public void setPreviewImage(String previewImage) {
        this.previewImage = previewImage;
    }

}