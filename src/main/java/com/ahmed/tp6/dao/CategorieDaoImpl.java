package com.ahmed.tp6.dao;

import com.ahmed.tp6.utils.JpaUtil;
import entities.Categorie;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CategorieDaoImpl implements CategorieDao{
    private EntityManager entityManager = JpaUtil.getEntityManager("TP6");

    @Override
    public Categorie save(Categorie categorie) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(categorie);
        entityTransaction.commit();
        return categorie;
    }

    @Override
    public Categorie getCategorie(int idCategorie) {
        return entityManager.find(Categorie.class, idCategorie);
    }

    @Override
    public Categorie updateCategorie(Categorie categorie) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(categorie);
        entityTransaction.commit();
        return categorie;
    }

    @Override
    public void deleteCategorie(int idCategorie) {
        Categorie categorie = entityManager.find(Categorie.class, idCategorie);
        entityManager.getTransaction().begin();
        entityManager.remove(categorie);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Categorie> getAllCategories() {
        List<Categorie> categories = entityManager.createQuery("select c from Categorie c").getResultList();
        return categories;
    }
}
