package part2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lecturetexte {
    public static void main(String[] args) {
        String cheminFichier = "flux..txt";

        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                System.out.println(ligne);
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }
}
