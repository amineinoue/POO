package pp;

public class StockManagerTest {
    public static void main(String[] args) {
        StockManager<Produit> stock = new StockManager<>();

        Produit p1 = new Produit("Ordinateur", 800, 10);
        Produit p2 = new Produit("Souris", 20, 50);
        Produit p3 = new Produit("Clavier", 30, 20);

        stock.ajouterProduit(p1);
        stock.ajouterProduit(p2);
        stock.ajouterProduit(p3);

        System.out.println("Liste des produits après ajout :");
        for (Produit p : stock.getProduits()) {
            System.out.println(p);
        }

        stock.trierProduits();
        System.out.println("\nListe des produits triés :");
        for (Produit p : stock.getProduits()) {
            System.out.println(p);
        }

        stock.supprimerProduit(p2);
        System.out.println("\nListe après suppression de la souris :");
        for (Produit p : stock.getProduits()) {
            System.out.println(p);
        }
    }
}
