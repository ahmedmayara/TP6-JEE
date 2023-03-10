package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Categorie {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_CATEGORIE")
    private Integer idCategorie;
    @Basic
    @Column(name = "NOM_CATEGORIE")
    private String nomCategorie;
    @Basic
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @OneToMany(mappedBy = "categorieByIdCategorie")
    private Collection<Produit> produitsByIdCategorie;

    public Categorie() {
    }

    public Categorie(String nomCategorie, Date dateCreation) {
        super();
        this.nomCategorie = nomCategorie;
        this.dateCreation = dateCreation;
    }

    public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Collection<Produit> getProduitsByIdCategorie() {
        return produitsByIdCategorie;
    }

    public void setProduitsByIdCategorie(Collection<Produit> produitsByIdCategorie) {
        this.produitsByIdCategorie = produitsByIdCategorie;
    }
}
