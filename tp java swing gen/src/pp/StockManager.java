package pp;

import java.util.*;

public class StockManager<T extends Comparable<T>> {
    private List<T> produits = new ArrayList<>();

    public void ajouterProduit(T produit) {
        produits.add(produit);
    }

    public void supprimerProduit(T produit) {
        produits.remove(produit);
    }

    public List<T> getProduits() {
        return produits;
    }

    public Iterator<T> iterator() {
        return produits.iterator();
    }

    public List<T> rechercherProduits(String nom) {
        List<T> resultats = new ArrayList<>();
        for (T produit : produits) {
            if (produit.toString().contains(nom)) {
                resultats.add(produit);
            }
        }
        return resultats;
    }

    public void trierProduits() {
        Collections.sort(produits);
    }
}
