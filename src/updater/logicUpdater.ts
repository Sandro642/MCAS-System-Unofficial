import { execSync } from 'child_process';
import Logger from '../utils/Logger';

const logger = new Logger();
let updateQueue: string[] = [];
let updaterStatus = true;

export function checkForUpdates() {
    if (!updaterStatus) {
        logger.warn('Updater est arrêté. Veuillez démarrer l\'updater avant de vérifier les mises à jour.');
        return;
    }
    try {
        execSync('git fetch');
        const updates = execSync('git log HEAD..origin/main --oneline').toString().trim();
        if (updates) {
            updateQueue = updates.split('\n');
            logger.info('Mises à jour trouvées et ajoutées à la queue.');
        } else {
            logger.info('Aucune mise à jour trouvée.');
        }
    } catch (error) {
        logger.error('Erreur lors de la vérification des mises à jour.');
    }
}

export function applyUpdate() {
    if (!updaterStatus) {
        logger.warn('Updater est arrêté. Veuillez démarrer l\'updater avant d\'appliquer les mises à jour.');
        return;
    }
    if (updateQueue.length > 0) {
        try {
            execSync('git pull');
            logger.info('Mises à jour appliquées.');
        } catch (error) {
            logger.error('Erreur lors de l\'application des mises à jour.');
        }
    } else {
        logger.info('Aucune mise à jour à appliquer.');
    }
}

export function rejectUpdate() {
    if (!updaterStatus) {
        logger.warn('Updater est arrêté. Veuillez démarrer l\'updater avant de rejeter les mises à jour.');
        return;
    }
    updateQueue = [];
    logger.warn('Mises à jour rejetées.');
}

export function startUpdater() {
    updaterStatus = true;
    logger.info('Updater démarré.');
}

export function stopUpdater() {
    updaterStatus = false;
    logger.info('Updater arrêté.');
}

export function getUpdaterStatus() {
    return updaterStatus;
}