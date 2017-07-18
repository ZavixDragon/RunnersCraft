package com.game.zavixdragon.runnerscraft.backend.trackers;

import java.util.List;

public final class Trackers {
    public final List<Tracker> Values;

    public Trackers() {
        this(new TrackerFactory().create());
    }

    public Trackers(List<Tracker> values) {
        Values = values;
    }

    public boolean canTrack(boolean canDetect, List<TrackerTrait> trackables, List<TrackerName> trackers) {
        if (!canDetect)
            return false;
        for (Tracker tracker : Values)
            if(trackers.contains(tracker.Name) && tracker.canTrack(trackables))
                return true;
        return false;
    }
}
