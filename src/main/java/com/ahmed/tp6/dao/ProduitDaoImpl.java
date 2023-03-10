package com.ahmed.tp6.dao;

import com.ahmed.tp6.utils.JpaUtil;
import entities.Produit;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ProduitDaoImpl implements ProduitDao {
    private EntityManager entityManager = JpaUtil.getEntityManager("TP6");

    @Override
    public Produit save(Produit produits) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(produits);
        entityTransaction.commit();
        return produits;
    }

    @Override
    public List<Produit> produitsParMC(String mc) {
        List<Produit> prods = entityManager.createQuery("select p from Produit p where p.nomProduit like :x")
                .setParameter("x", "%" + mc + "%")
                .getResultList();
        return prods;
    }

    @Override
    public Produit getProduit(int idProduit) {
        return entityManager.find(Produit.class, idProduit);
    }

    @Override
    public Produit updateProduit(Produit produits) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(produits);
        entityTransaction.commit();
        return produits;
    }

    @Override
    public void deleteProduit(int idProduit) {
        Produit produits = entityManager.find(Produit.class, idProduit);
        entityManager.getTransaction().begin();
        entityManager.remove(produits);
        entityManager.getTransaction().commit();
    }
}
