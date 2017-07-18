package com.game.zavixdragon.runnerscraft.backend;

import com.game.zavixdragon.runnerscraft.backend.guards.GuardName;
import com.game.zavixdragon.runnerscraft.backend.guards.GuardTrait;
import com.game.zavixdragon.runnerscraft.backend.guards.Guards;
import com.game.zavixdragon.runnerscraft.backend.trackers.TrackerName;
import com.game.zavixdragon.runnerscraft.backend.trackers.TrackerTrait;
import com.game.zavixdragon.runnerscraft.backend.trackers.Trackers;
import com.game.zavixdragon.runnerscraft.backend.watchers.WatcherName;
import com.game.zavixdragon.runnerscraft.backend.watchers.WatcherTrait;
import com.game.zavixdragon.runnerscraft.backend.watchers.Watchers;

import java.util.List;
import java.util.Random;

public final class CoreGame {
    public final Guards Guards;
    public final Watchers Watchers;
    public final Trackers Trackers;

    public CoreGame(Random random) {
        this(new Guards(random), new Watchers(random), new Trackers());
    }

    public CoreGame(Guards guards, Watchers watchers, Trackers trackers) {
        Guards = guards;
        Watchers = watchers;
        Trackers = trackers;
    }

    public AttackResult attackServer(
            List<GuardTrait> attackVectors,
            List<WatcherTrait> attackSignatures,
            List<TrackerTrait> trackables,
            List<GuardName> guards,
            List<WatcherName> watchers,
            List<TrackerName> trackers) {
        boolean penetrated = Guards.canPenetrate(attackVectors, guards);
        boolean detected = Watchers.canDetect(attackSignatures, watchers);
        boolean tracked = Trackers.canTrack(detected, trackables, trackers);
        return new AttackResult(penetrated, detected, tracked);
    }

    public void update(GuardName name) {
        Guards.update(name);
    }

    public List<GuardName> nonUpdatedGuards() {
        return Guards.nonUpdatedGuards();
    }
}