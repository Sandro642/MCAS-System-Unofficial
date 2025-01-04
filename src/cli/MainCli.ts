import 'colors';
import * as readline from 'readline';
import * as fs from 'fs';
import Logger from '../utils/Logger';
import NameApp from '../utils/NameApp';

const logger = new Logger();

function initCLI() {

    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout,
        prompt: 'console'.blue + '@'.white + 'MCAS-System-$'.green + ' '
    });

    rl.prompt();

    rl.on('line', (line) => {
        switch (line.trim()) {
            case '-help':
                console.log('Liste des commandes disponibles : help, exit');
                break;
            case 'exit':
                rl.close();
                break;
            default:
                logger.info('Commande inconnue. Tapez "-help" pour obtenir de l\'aide.\n');
                break;
        }
        rl.prompt();
    }).on('close', () => {
        console.clear();
        console.log('Au revoir! By Sandro642 MCAS System Unofficial');
        process.exit(0);
    });
}

export default initCLI;