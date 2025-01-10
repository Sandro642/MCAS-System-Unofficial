import 'colors';
import Logger from '../../../utils/Logger';
import { handleUpdaterCommand } from '../children/HandlerUpdaterCommand';
import { handleMCASCommand } from '../children/HandlerMCASCommand';

const logger = new Logger();

export function handleServicesCommand(subCommand: string, thirdSubCommand: string) {
    switch (subCommand) {
        case 'updater':
            handleUpdaterCommand(thirdSubCommand);
            break;
        case 'mcas':
            handleMCASCommand(thirdSubCommand);
            break;
        default:
            logger.info('Sous-commande inconnue pour "services". Utilisez "updater".');
            break;
    }
}