package tests;

import com.game.zavixdragon.runnerscraft.backend.trackers.Tracker;
import com.game.zavixdragon.runnerscraft.backend.trackers.TrackerName;
import com.game.zavixdragon.runnerscraft.backend.trackers.TrackerTrait;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public final class TrackerTests {
    private final Tracker tracker = new Tracker(TrackerName.Hunter, TrackerTrait.ResponsePayload);

    @Test
    public void ShouldBeTrackedWithMatchingTracable() {
        boolean result = tracker.canTrack(Arrays.asList(TrackerTrait.ResponsePayload, TrackerTrait.SpyChip));
        assertEquals(true, result);
    }

    @Test
    public void ShouldNotBeTrackedWithNoMatchingTracableElements() {
        boolean result = tracker.canTrack(Arrays.asList(TrackerTrait.SpyChip));
        assertEquals(false, result);
    }
}
