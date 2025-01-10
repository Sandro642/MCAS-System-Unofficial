import 'colors';
import Logger from '../../../utils/Logger';

import {
    applyUpdate,
    checkForUpdates,
    getUpdaterStatus,
    rejectUpdate,
    startUpdater,
    stopUpdater
} from "../../../updater/logicUpdater";

const logger = new Logger();

export function handleUpdaterCommand(thirdSubCommand: string) {
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