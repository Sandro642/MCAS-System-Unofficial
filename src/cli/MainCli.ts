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
        const [command, subCommand, thirdSubCommand] = line.trim().split(' ');

        switch (command) {
            case 'help':
                logger.info('Liste des commandes disponibles : help, services, clear, exit.');
                break;
            case 'services':
                handleServiceCommand(subCommand, thirdSubCommand);
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

function handleServiceCommand(subCommand: string, thirdSubCommand: string) {
    switch (subCommand) {
        case 'updater':
            handleUpdaterCommand(thirdSubCommand)
            break;
        case 'mcas':
            // A renseigner
            break;
        default:
            logger.info('Sous-commande inconnue pour "services". Utilisez "updater".');
            break;
    }
}

function handleUpdaterCommand(thirdSubCommand: string) {
    switch (thirdSubCommand) {
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