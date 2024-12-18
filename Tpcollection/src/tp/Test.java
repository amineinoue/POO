package tp;

import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
     
        Commande cmd1 = new Commande(1, new Date(), "Fournisseur A");
        Commande cmd2 = new Commande(2, new Date(), "Fournisseur B");
        Commande cmd3 = new Commande(3, new Date(), "Fournisseur C");


        Client client1 = new Client("C001", "Client 1", "Adresse 1", "0600000001");
        Client client2 = new ClientFidel("C002", "Client 2", "Adresse 2", "0600000002", "FIDEL001", 0.1f);

       
        client1.enregistrerCommande(cmd1);
        client1.enregistrerCommande(cmd2);
        client2.enregistrerCommande(cmd3);

        List<Client> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);

        
        Collections.sort(client1.getListeCommandes());
        System.out.println("Commandes triées : " + client1.getListeCommandes());

       
        Set<Commande> commandesSet = new HashSet<>(client1.getListeCommandes());
        System.out.println("Commandes sans doublons : " + commandesSet);

    
        Map<String, Client> clientMap = new HashMap<>();
        clientMap.put(client1.toString(), client1);
        clientMap.put(client2.toString(), client2);

        System.out.println("Client Map : " + clientMap);

       
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("clients.txt"))) {
            for (Client client : clients) {
                writer.write(client.toString());
                writer.newLine();
            }
        }

        
        try (BufferedReader reader = new BufferedReader(new FileReader("clients.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}

