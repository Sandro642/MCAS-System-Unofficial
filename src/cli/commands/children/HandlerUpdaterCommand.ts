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

const updaterCommandHandlers: Record<string, () => void> = {
    start: startUpdater,
    stop: stopUpdater,
    status: () => {
        logger.info(
            'Statut de l\'updater : ' + (getUpdaterStatus() ? 'démarré' : 'arrêté') + '.'
        );
    },
    check: checkForUpdates,
    apply: applyUpdate,
    reject: rejectUpdate,
};

export function handleUpdaterCommand(thirdSubCommand: string) {
    const handler = updaterCommandHandlers[thirdSubCommand];
    if (handler) {
        handler(); // Appelle la fonction associée
    } else {
        const availableCommands = Object.keys(updaterCommandHandlers).join(', ');
        logger.info(
            `Sous-commande inconnue pour "updater". Voici les commandes disponibles: ${availableCommands}`
        );
    }
}
