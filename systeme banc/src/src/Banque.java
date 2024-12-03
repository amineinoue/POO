package src;

import java.util.ArrayList;

public class Banque {
    private ArrayList<CompteBancaire> comptes;
    private static int nombreComptes = 0;

  
    public Banque() {
        comptes = new ArrayList<CompteBancaire>();
    }

    
    public void ajouterCompte(CompteBancaire compte) {
        comptes.add(compte);
        nombreComptes++;
    }

   
    public CompteBancaire chercherCompte(String numeroCompte) {
        for (CompteBancaire compte : comptes) {
            if (compte.getNumeroCompte().equals(numeroCompte)) {
                return compte;
            }
        }
        return null; 
    }


    public void transfert(String numeroSource, String numeroDest, double montant) {
        CompteBancaire source = chercherCompte(numeroSource);
        CompteBancaire dest = chercherCompte(numeroDest);

        if (source != null && dest != null) {
            if (source.getSolde() >= montant) {
                source.retirer(montant);
                dest.deposer(montant);
                System.out.println("Transfert de " + montant + " de " + numeroSource + " vers " + numeroDest + " réussi.");
            } else {
                System.out.println("Solde insuffisant dans le compte source.");
            }
        } else {
            System.out.println("Un des comptes spécifiés est introuvable.");
        }
    }

    
    public static void afficherNombreComptes() {
        System.out.println("Nombre total de comptes dans la banque : " + nombreComptes);
    }
}
