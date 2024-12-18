package tp;

import java.util.Date;

public class Commande implements Comparable<Commande> {
    private int numCommande;
    private Date dateCommande;
    private String nomFournisseur;

    public Commande(int numCommande, Date dateCommande, String nomFournisseur) {
        this.numCommande = numCommande;
        this.dateCommande = dateCommande;
        this.nomFournisseur = nomFournisseur;
    }

    public int getNumCommande() {
        return numCommande;
    }

    public void setNumCommande(int numCommande) {
        this.numCommande = numCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "numCommande=" + numCommande +
                ", dateCommande=" + dateCommande +
                ", nomFournisseur='" + nomFournisseur + '\'' +
                '}';
    }

  
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Commande commande = (Commande) obj;
        return numCommande == commande.numCommande;
    }

   
    public int compareTo(Commande autreCommande) {
        return this.dateCommande.compareTo(autreCommande.dateCommande);
    }
}

