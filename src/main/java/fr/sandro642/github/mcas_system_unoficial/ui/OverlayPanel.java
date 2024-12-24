package fr.sandro642.github.mcas_system_unoficial.ui;

import fr.sandro642.github.mcas_system_unoficial.core.MCASCore;

import javax.swing.*;
import java.awt.*;

public class OverlayPanel extends JPanel {

    private final MCASCore mcasLogic;

    public OverlayPanel(MCASCore mcasLogic) {
        this.mcasLogic = mcasLogic;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Pitch Angle: " + mcasLogic.getPitchAngle(), 10, 20);
        g.drawString("MCAS Status: " + (mcasLogic.isMCASEnabled() ? "Enabled" : "Disabled"), 10, 40);
    }
}
