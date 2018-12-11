package com.ropalinda.ropalindamovil.Entities;

import java.util.ArrayList;

public class Category {

    int id;
    String name;
    String image;
    ArrayList<SubCategory> subCategories;

    public Category(int id, String name, String image, ArrayList<SubCategory> subCategories) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.subCategories = subCategories;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(ArrayList<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }

}
