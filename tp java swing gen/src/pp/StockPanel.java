package pp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class StockPanel extends JPanel {
    private StockManager<Produit> stock = new StockManager<>();
    private JTable table;
    private DefaultTableModel model;

    public StockPanel() {
        setLayout(new BorderLayout());

        String[] colonnes = { "Nom", "Prix", "Quantité" };
        model = new DefaultTableModel(colonnes, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel boutons = new JPanel();
        JButton ajouter = new JButton("Ajouter");
        JButton supprimer = new JButton("Supprimer");
        JButton rechercher = new JButton("Rechercher");
        JButton trier = new JButton("Trier");

        ajouter.addActionListener(e --> ajouterProduit());
        supprimer.addActionListener(e --> supprimerProduit());
        rechercher.addActionListener(e --> rechercherProduit());
        trier.addActionListener(e --> trierProduits());

        boutons.add(ajouter);
        boutons.add(supprimer);
        boutons.add(rechercher);
        boutons.add(trier);

        add(boutons, BorderLayout.SOUTH);
    }

    private void ajouterProduit() {
        String nom = JOptionPane.showInputDialog("Nom du produit :");
        double prix = Double.parseDouble(JOptionPane.showInputDialog("Prix :"));
        int quantite = Integer.parseInt(JOptionPane.showInputDialog("Quantité :"));

        Produit p = new Produit(nom, prix, quantite);
        stock.ajouterProduit(p);
        model.addRow(new Object[]{p.getNom(), p.getPrix(), p.getQuantite()});
    }

    private void supprimerProduit() {
        int row = table.getSelectedRow();
        if (row != -1) {
            String nom = (String) table.getValueAt(row, 0);
            List<Produit> produits = stock.rechercherProduits(nom);
            if (!produits.isEmpty()) {
                stock.supprimerProduit(produits.get(0));
                model.removeRow(row);
            }
        }
    }

    private void rechercherProduit() {
        String recherche = JOptionPane.showInputDialog("Nom du produit à rechercher :");
        List<Produit> resultats = stock.rechercherProduits(recherche);
        if (!resultats.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Produits trouvés :\n" + resultats);
        } else {
            JOptionPane.showMessageDialog(this, "Aucun produit trouvé.");
        }
    }

    private void trierProduits() {
        stock.trierProduits();
        model.setRowCount(0);
        for (Produit p : stock.getProduits()) {
            model.addRow(new Object[]{p.getNom(), p.getPrix(), p.getQuantite()});
        }
    }
}
