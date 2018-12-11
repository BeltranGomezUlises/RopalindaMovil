package com.ropalinda.ropalindamovil.Entities;

public class SubCategory {

    int id;
    String name;
    String icon;
    boolean active;

    public SubCategory(){

    }

    /*public SubCategory(int id, String name, String icon, boolean active) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.active = active;
    }*/

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
