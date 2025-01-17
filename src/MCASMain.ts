import 'colors';
import axios from 'axios';
import NameApp from './utils/NameApp';
import Logger from './utils/Logger';
import { checkAndUpdate } from './updater/logicUpdater';

const logger = new Logger();

async function checkInternetConnection(): Promise<boolean> {
    try {
        await axios.get('https://www.google.com', { timeout: 5000 });
        return true;
    } catch (error) {
        return false;
    }
}

async function initMCASMain() {
    console.clear();
    console.log(NameApp.message + "\n\n");
    logger.info("MCAS Updater est implémenté ! Veuillez l'utiliser avec <services updater start> !" + "\n");
    logger.info("Vous pouvez utiliser la commande 'help' pour afficher la liste des commandes disponibles. Besoin de contributeur, vient sur le github et propose tes idées !" + "\n");

    const isConnected = await checkInternetConnection();

    if (!isConnected) {
        logger.error('Non connecté à internet. Mise à jour bloquée.');
    } else {
        logger.info('Vous êtes connecté à internet.');
        checkAndUpdate();
    }
}

initMCASMain();