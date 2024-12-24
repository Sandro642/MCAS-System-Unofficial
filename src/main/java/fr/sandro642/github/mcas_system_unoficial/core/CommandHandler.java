package fr.sandro642.github.mcas_system_unoficial.core;

import fr.sandro642.github.mcas_system_unoficial.utils.Logger;

public class CommandHandler {

    private final AircraftState aircraftState;

    public CommandHandler(AircraftState aircraftState) {
        this.aircraftState = aircraftState;
    }

    public void handleCommand(String command) {
        String[] parts = command.split(" ");
        String action = parts[0].toLowerCase();

        switch (action) {
            case "speed":
                double speed = Double.parseDouble(parts[1]);
                aircraftState.setSpeed(speed);
                Logger.info("Speed set to: " + speed);
                break;

            case "pitch":
                double pitch = Double.parseDouble(parts[1]);
                aircraftState.setPitch(pitch);
                Logger.info("Pitch set to: " + pitch);
                break;

            case "mcas":
                if (parts[1].equals("toggle")) {
                    aircraftState.toggleMcas();
                    Logger.info("MCAS toggled. Status: " + (aircraftState.isMcasEnabled() ? "Enabled" : "Disabled"));
                }
                break;

            default:
                Logger.warning("Unknown command: " + command);
                break;
        }
    }

}
