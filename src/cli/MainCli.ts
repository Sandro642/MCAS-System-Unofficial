import 'colors';
import * as readline from 'readline';
import Logger from '../utils/Logger';

import { handleServicesCommand } from './commands/parent/HandlerServicesCommand';

const logger = new Logger();

function initCLI() {

    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout,
        prompt: '\nconsole'.blue + '@'.white + 'MCAS-System-$'.green + ' '
    });

    rl.prompt();

    const commandHandlers: Record<string, (subCommand?: string, thirdSubCommand?: string) => void> = {
        help: () => {
            const availableCommands = Object.keys(commandHandlers).join(', ');
            logger.info(`Liste des commandes disponibles : ${availableCommands}`);
        },
        services: (subCommand, thirdSubCommand) => handleServicesCommand(subCommand || '', thirdSubCommand || ''),
        clear: () => console.clear(),
        exit: () => {
            rl.close();
        },
    };

    rl.prompt();

    rl.on('line', (line) => {
        const [command, subCommand, thirdSubCommand] = line.trim().split(' ');

        if (commandHandlers[command]) {
            commandHandlers[command](subCommand, thirdSubCommand);
        } else {
            logger.info(`Commande inconnue : "${command}". Tapez "help" pour la liste des commandes disponibles.`);
        }

        rl.prompt();
    }).on('close', () => {
        console.clear();
        logger.info('Au revoir! By Sandro642 MCAS System Unofficial');
        process.exit(0);
    });
}

export default initCLI;