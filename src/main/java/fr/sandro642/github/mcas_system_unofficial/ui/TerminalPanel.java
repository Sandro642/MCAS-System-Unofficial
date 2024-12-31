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

public class TerminalPanel extends JPanel {

    /**
     * @property terminalField
     * @description Terminal field
     *
     * Terminal field (modifiable as needed)
     */
    private final JTextField terminalField;

    /**
     * @method TerminalPanel
     * @description Initialize the terminal panel
     *
     * @return void
     */
    public TerminalPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(Color.LIGHT_GRAY);

        terminalField = new JTextField("Entrer une commande ici", 20);
        terminalField.setForeground(Color.BLACK);
        terminalField.setBackground(Color.GRAY);
        add(terminalField);
    }

    /**
     * @method getCommand
     * @description Get the command
     *
     * @return String
     */
    public String getCommand() {
        return terminalField.getText();
    }
}
