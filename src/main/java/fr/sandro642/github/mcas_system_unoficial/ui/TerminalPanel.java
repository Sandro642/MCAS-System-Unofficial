package fr.sandro642.github.mcas_system_unoficial.ui;

import fr.sandro642.github.mcas_system_unoficial.core.CommandHandler;
import fr.sandro642.github.mcas_system_unoficial.core.MCASCore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TerminalPanel extends JPanel {

    private final CommandHandler commandHandler;
    private final JTextArea commandLog;
    private final JTextField commandInput;

    public TerminalPanel(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;

        setLayout(new BorderLayout());

        // Zone de log des commandes
        commandLog = new JTextArea();
        commandLog.setEditable(false);
        commandLog.setBackground(Color.BLACK);
        commandLog.setForeground(Color.WHITE);
        add(new JScrollPane(commandLog), BorderLayout.CENTER);

        // Zone de saisie des commandes
        commandInput = new JTextField();
        commandInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = commandInput.getText();
                commandHandler.handleCommand(command);
                commandLog.append("Command: " + command + "\n");
                commandInput.setText("");
            }
        });
        add(commandInput, BorderLayout.SOUTH);
    }
}
