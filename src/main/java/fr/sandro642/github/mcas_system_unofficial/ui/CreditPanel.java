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

public class CreditPanel extends JPanel {

    /**
     * @method CreditPanel
     * @description Initialize the credit panel
     *
     * @return void
     */
    public CreditPanel() {
        // Utilise un BorderLayout pour occuper toute la largeur
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        // Créer le texte de crédit
        JLabel creditLabel = new JLabel("MCAS System Unofficial // Sandro642 // MIT License 2024", JLabel.CENTER);
        creditLabel.setForeground(Color.BLACK);

        // Ajoute le label au panneau
        add(creditLabel, BorderLayout.CENTER);
    }
}
