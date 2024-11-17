package part1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copiemodif {
    public static void main(String[] args) {
        String fichierSource = "bon.bin";
        String fichierDestination = "boo.bin";

        try (FileInputStream fis = new FileInputStream(fichierSource);
             FileOutputStream fos = new FileOutputStream(fichierDestination)) {

            byte[] buffer = new byte[1024]; 
            int bytesLus;

            while ((bytesLus = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesLus);
            }

            System.out.println("Fichier copié avec succès !");

        } catch (IOException e) {
            System.err.println("Erreur lors de la copie du fichier : " + e.getMessage());
        }
    }
}
