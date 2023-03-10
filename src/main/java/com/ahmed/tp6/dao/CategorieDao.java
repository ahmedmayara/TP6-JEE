package com.ahmed.tp6.dao;

import entities.Categorie;

import java.util.List;

public interface CategorieDao {
    public Categorie save(Categorie categorie);
    public Categorie getCategorie(int idCategorie);
    public Categorie updateCategorie(Categorie categorie);
    public void deleteCategorie(int idCategorie);
    public List<Categorie> getAllCategories();
}
