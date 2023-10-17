package ma.projet.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "produits")
public class Produit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "marque")
    private String marque;

    @Column(name = "reference")
    private String reference;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_achat")
    private Date dateAchat;

    @Column(name = "prix")
    private double prix;

    @Column(name = "designation")
    private String designation;

    // Constructeurs

    public Produit() {
        // Constructeur par défaut
    }

    public Produit(String marque, String reference, Date dateAchat, double prix, String designation) {
        this.marque = marque;
        this.reference = reference;
        this.dateAchat = dateAchat;
        this.prix = prix;
        this.designation = designation;
    }

    // Getters et Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
