import 'colors';
import * as readline from 'readline';
import Logger from '../utils/Logger';

import { handleServicesCommand } from './commands/parent/HandlerServicesCommand';

const logger = new Logger();

function initCLI() {

    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout,
        prompt: 'console'.blue + '@'.white + 'MCAS-System-$'.green + ' '
    });

    rl.prompt();

    rl.on('line', (line) => {
        const [command, subCommand, thirdSubCommand] = line.trim().split(' ');

        switch (command) {
            case 'help':
                logger.info('Liste des commandes disponibles : help, services, clear, exit.');
                break;
            case 'services':
                handleServicesCommand(subCommand, thirdSubCommand);
                break;
            case 'clear': 
                console.clear();
                break;
            case 'exit':
                rl.close();
                 break;
        }
        rl.prompt();
    }).on('close', () => {
        console.clear();
        logger.info('Au revoir! By Sandro642 MCAS System Unofficial');
        process.exit(0);
    });
}







export default initCLI;