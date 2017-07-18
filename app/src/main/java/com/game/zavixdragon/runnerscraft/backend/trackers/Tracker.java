package com.game.zavixdragon.runnerscraft.backend.trackers;

import java.util.List;

public final class Tracker {
    public final TrackerName Name;
    public final TrackerTrait Trait;

    public Tracker(TrackerName name, TrackerTrait trait) {
        Name = name;
        Trait = trait;
    }

    public boolean canTrack(List<TrackerTrait> trackables) {
        return trackables.contains(Trait);
    }
}
