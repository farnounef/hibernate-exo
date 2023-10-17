/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.entities;

import javax.persistence.*;

@Embeddable
public class LigneCommandeProduit2 implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

     @ManyToOne
     @JoinColumn(name = "id_commande")
     private Commande commande;
     public Commande getCommande() {
             return commande;
     }

     public void setCommande(Commande c) {
             this.commande = c;
     }

     @ManyToOne
     @JoinColumn(name = "id_produit")
     private Produit produit;
     public Produit getProduit() {
             return produit;
     }

     public void setProduit(Produit p) {
             this.produit = p;
     }
    
}
