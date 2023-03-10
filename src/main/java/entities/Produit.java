package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Produit {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PRODUIT")
    private Integer idProduit;
    @Basic
    @Column(name = "NOM_PRODUIT")
    private String nomProduit;
    @Basic
    @Column(name = "PRIX")
    private Double prix;
    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIE", referencedColumnName = "ID_CATEGORIE", nullable = false)
    private Categorie categorieByIdCategorie;

    public Produit() {
    }

    public Produit(String nomProduit, Double prix, Categorie categorieByIdCategorie) {
        this.nomProduit = nomProduit;
        this.prix = prix;
        this.setCategorieByIdCategorie(categorieByIdCategorie);
    }

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Categorie getCategorieByIdCategorie() {
        return categorieByIdCategorie;
    }

    public void setCategorieByIdCategorie(Categorie categorieByIdCategorie) {
        this.categorieByIdCategorie = categorieByIdCategorie;
    }
}
