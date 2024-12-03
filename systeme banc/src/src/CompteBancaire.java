package src;

import java.util.ArrayList;
import java.util.List;

public class CompteBancaire {
    private String numeroCompte;
    private double solde;
    private String titulaire;
    private List<Transaction> transactions; 

   
    public CompteBancaire(String numeroCompte, String titulaire) {
        this.numeroCompte = numeroCompte;
        this.titulaire = titulaire;
        this.solde = 0;
        this.transactions = new ArrayList<Transaction>();
    }

    public void deposer(double montant) {
        if (montant > 0) {
            solde += montant;
            transactions.add(new Transaction("credit", montant));  
            System.out.println(montant + " déposé sur le compte " + numeroCompte);
        }
    }

    public void retirer(double montant) {
        if (montant > 0 && solde >= montant) {
            solde -= montant;
            transactions.add(new Transaction("debit", montant));  
            System.out.println(montant + " retiré du compte " + numeroCompte);
        } else {
            System.out.println("Retrait refusé, solde insuffisant.");
        }
    }

   
    public void afficherSolde() {
        System.out.println("Le solde du compte " + numeroCompte + " est: " + solde);
    }

   
    public void afficherHistoriqueTransactions() {
        System.out.println("\nHistorique des transactions pour le compte " + numeroCompte + ":");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

   
    public String getNumeroCompte() {
        return numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setTitulaire(String titulaire) {
        this.titulaire = titulaire;
    }
}
