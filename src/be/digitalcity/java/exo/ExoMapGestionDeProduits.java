package be.digitalcity.java.exo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExoMapGestionDeProduits {
    public static void main(String[] args) {

        //Outils
        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer> panier = new HashMap<>();
        HashMap<Integer, String> listeProduits = new HashMap<>();

        //On rempli la liste des produits
        listeProduits.put(1, "Tomate");
        listeProduits.put(2, "Pomme");
        listeProduits.put(3, "Carotte");
        listeProduits.put(4, "Jambon");
        listeProduits.put(5, "Courgette");
        listeProduits.put(6, "Potiron");
        listeProduits.put(7, "Fromage");

        boolean quit = false;

        do{
            System.out.println("\nChoissisez le produit à ajouter à votre panier (-1 pour arreter) : ");

            //Affichage de la liste de produits
            for (Integer produit : listeProduits.keySet()) {
                String value = listeProduits.get(produit);
                System.out.println(produit + " --> " + value);
            }


            int choixProduit = sc.nextInt();

            if(choixProduit == -1) {
                quit = true;
            }

            //Si le choix du produit
            else if(choixProduit < -1 || choixProduit > listeProduits.size()){
                System.out.println("Ce produit n'existe pas. Choisissez un numéro de produit valable");
            }

            else {
                //On récupere le produit associe au choix
                String produitAjouterPanier = listeProduits.get(choixProduit);

                //Si le produit ets deja present , on incrémente le stock
                if(panier.containsKey(produitAjouterPanier)){
                    int stockProduit = panier.get(produitAjouterPanier);
                    panier.put(produitAjouterPanier, stockProduit+1);
                    System.out.println("Le stock du produit" + produitAjouterPanier + " a été incrémenté");
                }

                //Sinon on ajoute le produit dans le panier
                else{
                    panier.put(produitAjouterPanier, 1);
                    System.out.println("Le produit " + produitAjouterPanier+" a été ajouté au panier");
                }
            }

        }while(!quit);


        if(panier.isEmpty()){
            System.out.println("Votre Panier est vide");
        }
        else {System.out.println("Votre Panier:");
            for (Map.Entry<String, Integer> entryProduit : panier.entrySet()) {
                System.out.println(entryProduit.getKey() + " : " + entryProduit.getValue() );
            };
        }







    }
}
