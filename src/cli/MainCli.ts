import 'colors';
import * as readline from 'readline';
import Logger from '../utils/Logger';
import { checkForUpdates, applyUpdate, rejectUpdate, startUpdater, stopUpdater, getUpdaterStatus } from '../updater/logicUpdater';

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
            startUpdater();
            break;
        case 'stop':
            stopUpdater();
            break;
        case 'status':
            logger.info('Statut de l\'updater : ' + (getUpdaterStatus() ? 'démarré' : 'arrêté') + '.');
            break;
        case 'check':
            checkForUpdates();
            break;
        case 'apply':
            applyUpdate();
            break;
        case 'reject':
            rejectUpdate();
            break;
        default:
            logger.info('Sous-commande inconnue pour "updater". Utilisez "start", "stop", "status", "check", "apply" ou "reject".');
            break;
    }
}

export default initCLI;