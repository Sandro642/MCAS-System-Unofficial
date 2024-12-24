package fr.sandro642.github.mcas_system_unoficial.ui;

import fr.sandro642.github.mcas_system_unoficial.core.AircraftState;
import fr.sandro642.github.mcas_system_unoficial.core.MCASCore;

import javax.swing.*;
import java.awt.*;

public class StatusPanel extends JPanel {

    private final AircraftState aircraftState;
    private final JLabel statusLabel;

    public StatusPanel(AircraftState aircraftState) {
        this.aircraftState = aircraftState;
        this.statusLabel = new JLabel("MCAS Status: Enabled", SwingConstants.CENTER);
        setLayout(new BorderLayout());
        add(statusLabel, BorderLayout.CENTER);
    }

    public void updateStatus() {
        statusLabel.setText("MCAS Status: " + (aircraftState.isMcasEnabled() ? "Enabled" : "Disabled"));
    }

}
