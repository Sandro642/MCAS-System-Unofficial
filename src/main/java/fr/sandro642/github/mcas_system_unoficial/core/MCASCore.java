package fr.sandro642.github.mcas_system_unoficial.core;

import fr.sandro642.github.mcas_system_unoficial.utils.Logger;

public class MCASCore {
    private boolean mcasEnabled = true;
    private double pitchAngle;

    public void toggleMCAS() {
        mcasEnabled = !mcasEnabled;
        Logger.info("MCAS toggled: " + (mcasEnabled ? "Enabled" : "Disabled"));
    }

    public void adjustPitch(double delta) {
        if (mcasEnabled) {
            pitchAngle += delta;
            Logger.debug("Pitch adjusted to: " + pitchAngle);
        } else {
            Logger.warning("Attempted to adjust pitch while MCAS is disabled.");
        }
    }

    public double getPitchAngle() {
        Logger.debug("Fetching current pitch angle: " + pitchAngle);
        return pitchAngle;
    }

    public boolean isMCASEnabled() {
        Logger.debug("Fetching MCAS status: " + mcasEnabled);
        return mcasEnabled;
    }
}
