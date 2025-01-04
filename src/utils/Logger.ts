function getTimestamp(): string {
    return new Date().toISOString();
}

class Logger {
    info(message: string): void {
        console.log(`[${getTimestamp()}] INFO: ${message}`);
    }

    warn(message: string): void {
        console.warn(`[${getTimestamp()}] WARN: ${message}`);
    }

    error(message: string): void {
        console.error(`[${getTimestamp()}] ERROR: ${message}`);
    }
}

export default Logger;