package ma.projet.test;

import java.util.Date;
import ma.projet.entities.Produit;
import ma.projet.service.ProduitService;
import ma.projet.util.HibernateUtil;
import org.hibernate.Hibernate;
import java.util.List;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author hachem safae
 */
public class Test {
    
    public static void main(String[] args) {
      
        ProduitService produitService = new ProduitService();
        Produit produit1 = new Produit("Marque1", "Réf1", new Date(), 100, "Designation1");
        Produit produit2 = new Produit("Marque2", "Réf2", new Date(), 200, "Designation2");
        Produit produit3 = new Produit("Marque3", "Réf3", new Date(), 300, "Designation3");
        Produit produit4 = new Produit("Marque4", "Réf4", new Date(), 400, "Designation4");
        Produit produit5 = new Produit("Marque5", "Réf5", new Date(), 500, "Designation5");

        produitService.create(produit1);
        produitService.create(produit2);
        produitService.create(produit3);
        produitService.create(produit4);
        produitService.create(produit5);
        
        List<Produit> produits = produitService.findAll(null); // Passer null comme argument pour obtenir tous les produits

        for (Produit produit : produits) {
            System.out.println("ID: " + produit.getId());
            System.out.println("Marque: " + produit.getMarque());
            System.out.println("Référence: " + produit.getReference());
            System.out.println("Date: " + produit.getDateAchat());
            System.out.println("Prix: " + produit.getPrix());
            System.out.println("Désignation: " + produit.getDesignation());
            System.out.println("-------------------------------------");
        }

        
        
        //
        Produit produitById = produitService.findById(2);
        if (produitById != null) {
            System.out.println("Informations du produit avec ID 2:");
            System.out.println("ID: " + produitById.getId());
            System.out.println("Marque: " + produitById.getMarque());
            System.out.println("Référence: " + produitById.getReference());
            System.out.println("Date: " + produitById.getDateAchat());
            System.out.println("Prix: " + produitById.getPrix());
            System.out.println("Désignation: " + produitById.getDesignation());
        } else {
            System.out.println("Aucun produit trouvé avec l'ID 2.");
        }

        
        
        //       
        Produit produitToDelete = produitService.findById(3);
        if (produitToDelete != null) {
            produitService.delete(produitToDelete);
            System.out.println("Le produit avec l'ID 3 a été supprimé.");
        } else {
            System.out.println("Aucun produit trouvé avec l'ID 3.");
        }
        
        
        
        
        //
        Produit produitToUpdate = produitService.findById(1);

        if (produitToUpdate != null) {
            produitToUpdate.setMarque("NouvelleMarque");
            produitToUpdate.setReference("NouvelleRéf");
            produitToUpdate.setDateAchat(new Date());
            produitToUpdate.setPrix(999);
            produitToUpdate.setDesignation("NouvelleDesignation");

            produitService.update(produitToUpdate);
            System.out.println("Les informations du produit avec l'ID 1 ont été modifiées.");
        } else {
            System.out.println("Aucun produit trouvé avec l'ID 1.");
        }
        
        
        
        
        //
        System.out.println("Liste des produits dont le prix est supérieur à 100 DH:");
        for (Produit produit : produits) {
            if (produit.getPrix() > 100) {
                System.out.println("ID: " + produit.getId());
                System.out.println("Marque: " + produit.getMarque());
                System.out.println("Référence: " + produit.getReference());
                System.out.println("Date: " + produit.getDateAchat());
                System.out.println("Prix: " + produit.getPrix() + " DH");
                System.out.println("Désignation: " + produit.getDesignation());
                System.out.println("-------------------------------------");
            }
        }
        
        
        
        
        
        //
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Entrez la date de début (format yyyy-MM-dd) : ");
            Date dateDebut = dateFormat.parse(scanner.next());

            System.out.print("Entrez la date de fin (format yyyy-MM-dd) : ");
            Date dateFin = dateFormat.parse(scanner.next());

            System.out.println("Liste des produits commandés entre " + dateFormat.format(dateDebut) + " et " + dateFormat.format(dateFin) + ":");

            for (Produit produit : produits) {
                Date dateCommande = produit.getDateAchat();
                if (dateCommande.compareTo(dateDebut) >= 0 && dateCommande.compareTo(dateFin) <= 0) {
                    System.out.println("ID: " + produit.getId());
                    System.out.println("Marque: " + produit.getMarque());
                    System.out.println("Référence: " + produit.getReference());
                    System.out.println("Date de commande: " + dateFormat.format(dateCommande));
                    System.out.println("Prix: " + produit.getPrix() + " DH");
                    System.out.println("Désignation: " + produit.getDesignation());
                    System.out.println("-------------------------------------");
                }
            }
        } catch (ParseException e) {
            System.err.println("Erreur de format de date. Assurez-vous d'utiliser le format yyyy-MM-dd.");
        } finally {
            scanner.close();
        }
    }
}