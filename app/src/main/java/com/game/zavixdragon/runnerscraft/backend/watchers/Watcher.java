package com.game.zavixdragon.runnerscraft.backend.watchers;

import java.util.List;

public final class Watcher {
    public final WatcherName Name;
    public final List<WatcherTrait> Traits;

    public Watcher(WatcherName name, List<WatcherTrait> traits) {
        Name = name;
        Traits = traits;
    }

    public boolean canDetect(List<WatcherTrait> attackSignatures) {
        for (WatcherTrait trait : Traits)
            if (attackSignatures.contains(trait))
                return true;
        return false;
    }
}