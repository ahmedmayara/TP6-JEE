package com.ahmed.tp6.dao;

import entities.Produit;

import java.util.List;

public interface ProduitDao {
    public Produit save(Produit produits);
    public List<Produit> produitsParMC(String mc);
    public Produit getProduit(int idProduit);
    public Produit updateProduit(Produit produits);
    public void deleteProduit(int idProduit);
}
