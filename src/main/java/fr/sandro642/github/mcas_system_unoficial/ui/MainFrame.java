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

    public MainFrame() {
        this.aircraftState = new AircraftState();
        this.commandHandler = new CommandHandler(aircraftState);
        this.terminalPanel = new TerminalPanel(commandHandler);
        this.statusPanel = new StatusPanel(aircraftState);

        // Initialisation de la fenêtre
        setTitle("MCAS System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Ajouter le terminal et le panneau de statut
        add(terminalPanel, BorderLayout.SOUTH);
        add(statusPanel, BorderLayout.NORTH);
    }

    public void init() {
        setVisible(true);
    }
}
