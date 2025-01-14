import 'colors';
import NameApp from './utils/NameApp';
import Logger from './utils/Logger';
import { checkAndUpdate } from './updater/logicUpdater';

const logger = new Logger();

function initMCASMain() {
    console.clear();
    console.log(NameApp.message + "\n\n");
    logger.info("MCAS Updater est implémenté ! Veuillez l'utiliser avec <services updater start> !" + "\n");
    logger.info("Vous pouvez utiliser la commande 'help' pour afficher la liste des commandes disponibles. Besoin de contributeur, vient sur le github et propose tes idées !" + "\n");

    checkAndUpdate();
}

initMCASMain();