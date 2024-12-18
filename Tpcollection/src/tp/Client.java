package tp;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String codeClient;
    private String nomClient;
    private String adrClient;
    private String telClient;
    private List<Commande> listeCommandes;

    public Client(String codeClient, String nomClient, String adrClient, String telClient) {
        this.codeClient = codeClient;
        this.nomClient = nomClient;
        this.adrClient = adrClient;
        this.telClient = telClient;
        this.listeCommandes = new ArrayList<>();
    }

    public boolean enregistrerCommande(Commande commande) {
        return listeCommandes.add(commande);
    }

    public boolean supprimerCommande(int numCommande) {
        return listeCommandes.removeIf(numCommande -> numCommande.getNumCommande() == numCommande);
    }

    public List<Commande> getListeCommandes() {
        return listeCommandes;
    }

   
    public String toString() {
        return "Client{" +"codeClient='" + codeClient + '\'' +", nomClient='" + nomClient + '\'' +", adrClient='" + adrClient + '\'' +", telClient='" + telClient + '\'' +", listeCommandes=" + listeCommandes +'}';
    }
}
