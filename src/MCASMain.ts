import 'colors';
import NameApp from './utils/NameApp';
import initCLI from './cli/MainCli';

function initMCASMain() {
    console.clear();
    console.log(NameApp.message + "\n\n");
    console.log("MCAS Updater n'est toujours pas implémenté." + "\n");
    console.log("Vous pouvez utiliser la commande '-help' pour afficher la liste des commandes disponibles.\n".gray);

    initCLI();
}

initMCASMain();