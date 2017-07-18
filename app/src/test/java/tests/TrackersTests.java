package tests;

import com.game.zavixdragon.runnerscraft.backend.trackers.TrackerName;
import com.game.zavixdragon.runnerscraft.backend.trackers.TrackerTrait;
import com.game.zavixdragon.runnerscraft.backend.trackers.Trackers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public final class TrackersTests {
    private final Trackers trackers = new Trackers();

    @Test
    public void CanNotTrackWhenDetectedButNoTrackers() {
        boolean result = trackers.canTrack(true, Arrays.asList(TrackerTrait.SpyChip), new ArrayList<TrackerName>());
        assertEquals(false, result);
    }

    @Test
    public void CanNotTrackWhenNotDetected() {
        boolean result = trackers.canTrack(false, Arrays.asList(trackers.Values.get(0).Trait), Arrays.asList(trackers.Values.get(0).Name));
        assertEquals(false, result);
    }

    @Test
    public void CanTrackWhenDetectedAndMatchingTrackableElement() {
        boolean result = trackers.canTrack(true, Arrays.asList(trackers.Values.get(0).Trait), Arrays.asList(trackers.Values.get(0).Name));
        assertEquals(true, result);
    }

    @Test
    public void CanNotTrackWhenDetectedButNoMatchingTrackables() {
        boolean result = trackers.canTrack(true, Arrays.asList(trackers.Values.get(1).Trait), Arrays.asList(trackers.Values.get(0).Name));
        assertEquals(false, result);
    }
}
