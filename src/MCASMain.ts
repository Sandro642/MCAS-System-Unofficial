import 'colors';
import NameApp from './utils/NameApp';
import initCLI from './cli/MainCli';
import Logger from './utils/Logger';

const logger = new Logger();

function initMCASMain() {
    console.clear();
    console.log(NameApp.message + "\n\n");
    logger.info("MCAS Updater est implémenté ! Veuillez l'utiliser avec <services updater start> !" + "\n");
    logger.info("Vous pouvez utiliser la commande 'help' pour afficher la liste des commandes disponibles.\n");

    initCLI();
}

initMCASMain();