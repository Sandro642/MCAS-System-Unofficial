package fr.sandro642.github.mcas_system_unofficial.ui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Sandro642
 * @version 1.0
 * @project MCAS System
 * @since 2024
 * @description The Maneuvering Characteristics Augmentation System (MCAS) is an automated system designed to enhance the flight characteristics of an aircraft, particularly regarding its behavior at high angles of attack. This system plays a crucial role in the stability of the aircraft during certain maneuvers, especially when an aircraft is at low speed or climbing, and helps to prevent a stall.
 *
 * @see <a href="https://fr.wikipedia.org/wiki/Maneuvering_Characteristics_Augmentation_System">Maneuvering Characteristics Augmentation System</a>
 *
 * @license <a href="https://opensource.org/licenses/MIT">MIT License</a>
 */

public class MainFrame extends JFrame {

    /**
     * @method initFrame
     * @description Initialize the frame
     *
     * @return void
     */
    public void initFrame() {
        // Configure la fenêtre
        setTitle("MCAS System Unofficial // Main Page");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setBackground(new Color(255, 255, 255));

        // Panneau principal central
        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

        // Panneaux centraux (statut, modèle de l'avion, console de log)
        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 10, 10)); // Grille 2x2
        centerPanel.setBackground(Color.WHITE);

        // Exemple : Panneau de statut
        JPanel statusPanel = new JPanel();
        statusPanel.setBackground(Color.GRAY);
        JLabel statusLabel = new JLabel("Statut du MCAS : Activé / Non Activé / Corrompu / Engagé");
        statusPanel.add(statusLabel);

        // Exemple : Panneau du modèle de l'avion
        JPanel modelPanel = new JPanel();
        modelPanel.setBackground(Color.GRAY);
        JLabel modelLabel = new JLabel("Modèle de l'avion");
        modelPanel.add(modelLabel);

        // Exemple : Panneau de console de log
        JPanel logPanel = new JPanel();
        logPanel.setBackground(Color.GRAY);
        JLabel logLabel = new JLabel("Console de log");
        logPanel.add(logLabel);

        // Ajouter les panneaux centraux
        centerPanel.add(statusPanel);
        centerPanel.add(modelPanel);
        centerPanel.add(logPanel);

        // Ajouter le terminal dans l'espace vide
        TerminalPanel terminalPanel = new TerminalPanel();
        JPanel terminalWrapper = new JPanel(new FlowLayout(FlowLayout.LEFT));
        terminalWrapper.setBackground(Color.GRAY); // Fond pour le terminal
        terminalWrapper.add(terminalPanel); // Ajouter le terminal
        centerPanel.add(terminalWrapper); // Terminal ajouté dans l'espace vide

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Ajouter le panneau de crédit distinct
        CreditPanel creditPanel = new CreditPanel();
        add(creditPanel, BorderLayout.PAGE_END); // Crédit sur toute la largeur

        // Rendre la fenêtre visible
        setVisible(true);
    }
}
