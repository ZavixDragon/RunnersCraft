package com.game.zavixdragon.runnerscraft.backend.watchers;

import java.util.List;
import java.util.Random;

public final class Watchers {
    public final List<Watcher> Values;

    public Watchers(Random random) {
        this(new WatcherFactory(random).create());
    }

    public Watchers(List<Watcher> values) {
        Values = values;
    }

    public boolean canDetect(List<WatcherTrait> attackSignatures, List<WatcherName> watchers) {
        for (Watcher watcher : Values)
            if (watchers.contains(watcher.Name) && watcher.canDetect(attackSignatures))
                return true;
        return false;
    }
}
