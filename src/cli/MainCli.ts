import 'colors';
import * as readline from 'readline';
import Logger from '../utils/Logger';

const logger = new Logger();

function initCLI() {

    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout,
        prompt: 'console'.blue + '@'.white + 'MCAS-System-$'.green + ' '
    });

    rl.prompt();

    rl.on('line', (line) => {
        const [command, subCommand] = line.trim().split(' ');

        switch (command) {
            case '-help':
                logger.info('Liste des commandes disponibles : help, exit, updater');
                break;
            case 'exit':
                rl.close();
                break;
            case 'updater':
                handleUpdaterCommand(subCommand);
                break;
            default:
                logger.info('Commande inconnue. Tapez "-help" pour obtenir de l\'aide.\n');
                break;
        }
        rl.prompt();
    }).on('close', () => {
        console.clear();
        logger.info('Au revoir! By Sandro642 MCAS System Unofficial');
        process.exit(0);
    });
}

function handleUpdaterCommand(subCommand: string) {
    switch (subCommand) {
        case 'start':
            logger.info('Updater démarré.');
            break;
        case 'stop':
            logger.info('Updater arrêté.');
            break;
        case 'status':
            logger.info('Statut de l\'updater : en cours.');
            break;
        case 'run':
            logger.info('Updater en cours d\'exécution.');
            break;
        default:
            logger.info('Sous-commande inconnue pour "updater". Utilisez "start", "stop", "status" ou "run".');
            break;
    }
}

export default initCLI;