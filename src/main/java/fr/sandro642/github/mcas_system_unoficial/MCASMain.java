package fr.sandro642.github.mcas_system_unoficial;

import fr.sandro642.github.mcas_system_unoficial.core.AircraftState;
import fr.sandro642.github.mcas_system_unoficial.core.CommandHandler;
import fr.sandro642.github.mcas_system_unoficial.utils.Logger;

import java.util.Scanner;

public class MCASMain {

    public static void main(String[] args) {
        AircraftState aircraftState = new AircraftState();
        CommandHandler commandHandler = new CommandHandler(aircraftState);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the MCAS simulation. Enter commands below:");

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("exit")) {
                break;
            }

            // Traitement de la commande
            commandHandler.handleCommand(command);
            Logger.info("Executed command: " + command);
        }

        scanner.close();
        System.out.println("Exiting MCAS simulation...");
    }

}
