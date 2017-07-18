package com.game.zavixdragon.runnerscraft.backend.trackers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class TrackerFactory {
    public List<Tracker> create() {
        return new ArrayList<>(Arrays.asList(
            new Tracker(TrackerName.Chipper, TrackerTrait.SpyChip),
            new Tracker(TrackerName.Hunter, TrackerTrait.ResponsePayload),
            new Tracker(TrackerName.ConnectionScrutinizer, TrackerTrait.SentryProgram),
            new Tracker(TrackerName.Neo, TrackerTrait.TrackedRequestProtocol)
        ));
    }
}
