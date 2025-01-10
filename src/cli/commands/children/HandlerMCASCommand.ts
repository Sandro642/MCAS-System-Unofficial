#!/usr/bin/env node

import {spawn} from 'child_process';

import 'colors';
import Logger from '../../../utils/Logger';

const logger = new Logger();

const mcasCommandHandlers: Record<string, () => void> = {
    open: () => {
        logger.info('Ouverture de la fenêtre...');
        const electronProcess = spawn('electron', ['.'], {
            stdio: 'inherit',
            shell: true,
        });
    },
    close: () => {
      logger.info('Fermeture de la fenêtre...')
        // Ajoutez ici la logique pour fermer MCAS
    },
    enable: () => {
        logger.info('MCAS activé.');
        // Ajoutez ici la logique pour activer MCAS
    },
    disable: () => {
        logger.info('MCAS désactivé.');
        // Ajoutez ici la logique pour désactiver MCAS
    },
    status: () => {
        logger.info('Statut du MCAS : actif/inactif.');
        // Ajoutez ici la logique pour afficher le statut
    },
    calibrate: () => {
        logger.info('Calibration du MCAS démarrée.');
        // Ajoutez ici la logique pour calibrer MCAS
    },
};

export function handleMCASCommand(thirdSubCommand: string) {
    const handler = mcasCommandHandlers[thirdSubCommand];
    if (handler) {
        handler();
    } else {
        const availableCommands = Object.keys(mcasCommandHandlers).join(', ');
        logger.info(
            `Sous-commande inconnue pour "MCAS". Voici les commandes disponibles : ${availableCommands}`
        );
    }
}
