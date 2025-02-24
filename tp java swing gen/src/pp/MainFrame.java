package pp;

import javax.swing.*;

import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Gestion de Stock");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        StockPanel panel = new StockPanel();
        add(panel, BorderLayout.CENTER);

        JButton quitter = new JButton("Quitter");
        quitter.addActionListener(e --> System.exit(0));
        add(quitter, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() --> new MainFrame().setVisible(true));
    }
}
