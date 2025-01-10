import 'colors';
import Logger from '../../../utils/Logger';
import { handleUpdaterCommand } from '../children/HandlerUpdaterCommand';
import { handleMCASCommand } from '../children/HandlerMCASCommand';

const logger = new Logger();

const subCommandHandlers: Record<string, (thirdSubCommand: string) => void> = {
    updater: handleUpdaterCommand,
    mcas: handleMCASCommand,
};

export function handleServicesCommand(subCommand: string, thirdSubCommand: string) {
    const handler = subCommandHandlers[subCommand];
    if (handler) {
        handler(thirdSubCommand);
    } else {
        logger.info(
            `Sous-commande inconnue pour "services". Voici les commandes disponibles: ${Object.keys(subCommandHandlers).join(', ')}`
        );
    }
}
