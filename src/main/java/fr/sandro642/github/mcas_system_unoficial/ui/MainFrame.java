package fr.sandro642.github.mcas_system_unoficial.ui;

import fr.sandro642.github.mcas_system_unoficial.core.AircraftState;
import fr.sandro642.github.mcas_system_unoficial.core.CommandHandler;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private final AircraftState aircraftState;
    private final CommandHandler commandHandler;
    private final TerminalPanel terminalPanel;
    private final StatusPanel statusPanel;
    private final AirplaneModelPanel airplaneModelPanel;

    public MainFrame() {
        this.aircraftState = new AircraftState();
        this.commandHandler = new CommandHandler(aircraftState);
        this.terminalPanel = new TerminalPanel(commandHandler);
        this.statusPanel = new StatusPanel(aircraftState);
        this.airplaneModelPanel = new AirplaneModelPanel();  // Initialisation du modèle 3D

        // Initialisation de la fenêtre
        setTitle("MCAS System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Ajouter le panneau 3D de l'avion
        add(airplaneModelPanel, BorderLayout.CENTER);

        // Ajouter le terminal et le panneau de statut
        add(terminalPanel, BorderLayout.SOUTH);
        add(statusPanel, BorderLayout.NORTH);
    }

    public void init() {
        setVisible(true);
    }

}
