package com.ropalinda.ropalindamovil.Entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Garment {

    public Garment(int id, int id2, String categoria, String subcategoria, String name, int price, String previewImage) {
        this.id = id;
        this.id2 = id2;
        this.categoria = categoria;
        this.subcategoria = subcategoria;
        this.name = name;
        this.price = price;
        this.previewImage = previewImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPreviewImage() {
        return previewImage;
    }

    public void setPreviewImage(String previewImage) {
        this.previewImage = previewImage;
    }

    int id;
    int id2;
    String categoria;
    String subcategoria;
    String name;
    int price;
    //String description;
    String previewImage;


    /*@SerializedName("subcategory")
    public SubCategoria subcategory;

    @SerializedName("data")
    public Data data;

    public static class SubCategoria {
        @SerializedName("id")
        public Integer id;
        @SerializedName("name")
        public String name;
        @SerializedName("icon")
        public String icon;
        @SerializedName("active")
        public Boolean active;
    }

    public static class Data {
        @SerializedName("id")
        public Integer id;
        @SerializedName("name")
        public String name;
        @SerializedName("description")
        public String description;
        @SerializedName("previewImage")
        public String previewImage;
        @SerializedName("image")
        public String image;
        @SerializedName("active")
        public boolean active;
        @SerializedName("price")
        public Integer price;
        @SerializedName("compatibleGarmentList")
        public List<CompatibleGarment> compatibleGarmentList;
    }*/

}
