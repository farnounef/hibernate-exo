/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.entities;

/**
 *
 * @author Admin
 */
import javax.persistence.*;

@Entity
public class LigneCommandeProduit {

     @Id
     LigneCommandeProduit2 pk;
     public LigneCommandeProduit2 getPk() {
             return pk;
     }

     public void setPk(LigneCommandeProduit2 pk) {
             this.pk = pk;
     }

     private int quantite;
     public void setQuantite(String quantite) {quantite= quantite;}
     public int getQuantite() {return quantite;}
}