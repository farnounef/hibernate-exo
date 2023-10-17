/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

public class Commande implements Serializable {
    
   @Id 
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   @Temporal(TemporalType.DATE)
   private Date date;
   
   @OneToMany(mappedBy = "pk.commande")
private List<LigneCommandeProduit> quantites ;
public List<LigneCommandeProduit> getQuantites() {
        return this.quantites;
}
public void setQuantites(List<LigneCommandeProduit> r) {
        this.quantites = r;
}

    public Commande() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
   
}
