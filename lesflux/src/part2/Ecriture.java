package part2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ecriture {
    public static void main(String[] args) {
        String fichierSource = "flux..txt";
        String fichierDestination = "po.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fichierSource));
             BufferedWriter bw = new BufferedWriter(new FileWriter(fichierDestination))) {

            String ligne;
            while ((ligne = br.readLine()) != null) {
                bw.write(ligne); 
                bw.newLine(); 
            }

            System.out.println("Le contenu a été écrit dans le fichier : " + fichierDestination);

        } catch (IOException e) {
            System.err.println("Erreur lors de la manipulation des fichiers : " + e.getMessage());
        }
    }
}

