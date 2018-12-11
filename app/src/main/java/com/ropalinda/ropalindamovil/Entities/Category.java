package com.ropalinda.ropalindamovil.Entities;

import java.util.ArrayList;
import java.util.List;

public class Category {

    List<SubCategory> subcategoryCollection;
    int id;
    String name;
    String icon;
    boolean active;


    public Category(){

    }

    public List<SubCategory> getSubcategoryCollection() {
        return subcategoryCollection;
    }

    public void setSubcategoryCollection(List<SubCategory> subcategoryCollection) {
        this.subcategoryCollection = subcategoryCollection;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
