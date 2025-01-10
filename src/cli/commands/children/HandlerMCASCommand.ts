import 'colors';
import Logger from '../../../utils/Logger';

const logger = new Logger();

export function handleMCASCommand(thirdSubCommand: string) {
    switch (thirdSubCommand) {
        default:
            logger.info('Sous-commande incoonu pour "MCAS"')
    }
}