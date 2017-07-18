package com.game.zavixdragon.runnerscraft.backend;

public final class AttackResult {
    public final boolean WasPenetrated;
    public final boolean WasDetected;
    public final boolean WasTracked;

    public AttackResult(boolean wasPenetrated, boolean wasDetected, boolean wasTracked) {
        WasPenetrated = wasPenetrated;
        WasDetected = wasDetected;
        WasTracked = wasTracked;
    }
}