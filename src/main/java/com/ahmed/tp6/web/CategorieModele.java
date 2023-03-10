package com.ahmed.tp6.web;

import entities.Categorie;

import java.util.ArrayList;
import java.util.List;

public class CategorieModele {
    List<Categorie> categories = new ArrayList<>();

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }
}
