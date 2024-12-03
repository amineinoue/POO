package src;


public class CompteCourant extends CompteBancaire {
    private double decouvertAutorise;

    
    public CompteCourant(String numeroCompte, String titulaire, double decouvertAutorise) {
        super(numeroCompte, titulaire);
        this.decouvertAutorise = decouvertAutorise;
    }

   
    @Override
    public void retirer(double montant) {
        if (montant > 0 && getSolde() + decouvertAutorise >= montant) {
            super.retirer(montant);  
            System.out.println("Retrait de " + montant + " autorisé avec découvert pour le compte courant.");
        } else {
            System.out.println("Retrait refusé : montant supérieur au découvert autorisé.");
        }
    }
}
