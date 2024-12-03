package src;

public class BanqueTest {
    public static void main(String[] args) {
     
        Banque banque = new Banque();

       
        CompteBancaire compte1 = new CompteBancaire("001", "Alice");
        CompteBancaire compte2 = new CompteBancaire("002", "Bob");
        CompteBancaire compte3 = new CompteBancaire("003", "Charlie");

        banque.ajouterCompte(compte1);
        banque.ajouterCompte(compte2);
        banque.ajouterCompte(compte3);

      
        compte1.deposer(1000);
        compte2.deposer(500);
        compte3.deposer(1200);

      
        compte1.retirer(200);
        compte2.retirer(100);

       
        compte1.afficherSolde();
        compte2.afficherSolde();
        compte3.afficherSolde();

     
        banque.transfert("001", "002", 300);
        
      
        compte1.afficherSolde();
        compte2.afficherSolde();

       

        
        CompteCourant compteCourant1 = new CompteCourant("CC001", "Alice", 500);
        CompteCourant compteCourant2 = new CompteCourant("CC002", "Bob", 300);
        CompteEpargne compteEpargne1 = new CompteEpargne("CE001", "Charlie", 0.03); // 3% taux d'intérêt

      
        banque.ajouterCompte(compteCourant1);
        banque.ajouterCompte(compteCourant2);
        banque.ajouterCompte(compteEpargne1);

       
        compteCourant1.deposer(1000);
        compteCourant2.deposer(200);
        compteCourant1.retirer(1200);  
        compteCourant2.retirer(600);   

       
        compteEpargne1.deposer(1500);
        compteEpargne1.calculerInteret(); 

     
        System.out.println("\n--- Soldes après opérations ---");
        compteCourant1.afficherSolde();
        compteCourant2.afficherSolde();
        compteEpargne1.afficherSolde();
        
        
        
       

       
        banque.ajouterCompte(compte1);
        banque.ajouterCompte(compte2);

       
        compte1.deposer(500);
        compte1.retirer(200);
        compte2.deposer(1000);
        compte2.retirer(300);
        compte1.retirer(100);

       
        System.out.println("\n--- Soldes des comptes ---");
        compte1.afficherSolde();
        compte2.afficherSolde();


        System.out.println("\n--- Historique des transactions ---");
        compte1.afficherHistoriqueTransactions();
        compte2.afficherHistoriqueTransactions();

        
        Banque.afficherNombreComptes();
        
        
        
       
   
    }
}

