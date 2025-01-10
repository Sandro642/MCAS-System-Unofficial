import 'colors';

function getTimestamp(): string {
    return new Date().toISOString();
}

class Logger {
    info(message: string): void {
        console.log(`[${getTimestamp()}]`.gray + ` INFO:`.blue + ` ${message}`);
    }

    warn(message: string): void {
        console.warn(`[${getTimestamp()}]`.gray + ` WARN:`.yellow + ` ${message}`);
    }

    error(message: string): void {
        console.error(`[${getTimestamp()}]`.gray + ` ERROR:`.red + ` ${message}`);
    }
}

export default Logger;
