package fr.sandro642.github.mcas_system_unoficial.core;

public class AircraftState {

    private double speed;    // Vitesse en knots
    private double pitch;    // Angle de tangage en degrés
    private boolean mcasEnabled; // État du MCAS

    public AircraftState() {
        this.speed = 250;    // Vitesse initiale
        this.pitch = 0;      // Assiette neutre
        this.mcasEnabled = true; // MCAS activé par défaut
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getPitch() {
        return pitch;
    }

    public void setPitch(double pitch) {
        this.pitch = pitch;
    }

    public boolean isMcasEnabled() {
        return mcasEnabled;
    }

    public void toggleMcas() {
        this.mcasEnabled = !this.mcasEnabled;
    }

}
