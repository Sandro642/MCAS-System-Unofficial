package fr.sandro642.github.mcas_system_unoficial.ui;

import fr.sandro642.github.mcas_system_unoficial.core.MCASCore;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {

    public ControlPanel(MCASCore mcasLogic) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JButton toggleMCASButton = new JButton("Toggle MCAS");
        toggleMCASButton.addActionListener((ActionEvent e) -> mcasLogic.toggleMCAS());
        add(toggleMCASButton);

        JButton increasePitchButton = new JButton("Increase Pitch");
        increasePitchButton.addActionListener((ActionEvent e) -> mcasLogic.adjustPitch(1.0));
        add(increasePitchButton);

        JButton decreasePitchButton = new JButton("Decrease Pitch");
        decreasePitchButton.addActionListener((ActionEvent e) -> mcasLogic.adjustPitch(-1.0));
        add(decreasePitchButton);
    }

}
