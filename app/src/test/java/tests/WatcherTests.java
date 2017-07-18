package tests;

import com.game.zavixdragon.runnerscraft.backend.watchers.Watcher;
import com.game.zavixdragon.runnerscraft.backend.watchers.WatcherName;
import com.game.zavixdragon.runnerscraft.backend.watchers.WatcherTrait;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public final class WatcherTests {
    private final Watcher watcher = new Watcher(WatcherName.AdaptiveGrid, Arrays.asList(WatcherTrait.InhumanBehaviour, WatcherTrait.CodeShifting, WatcherTrait.ErrorExploiting));

    @Test
    public void ShouldFailToHideWhenYouHaveMatchingSignature() {
        boolean result = watcher.canDetect(Arrays.asList(WatcherTrait.ErrorExploiting, WatcherTrait.BypassedCheckpoint));
        assertEquals(true, result);
    }

    @Test
    public void ShouldSuccessfullyHideWithNoMatchingSignatures() {
        boolean result = watcher.canDetect(Arrays.asList(WatcherTrait.ElevatedCommands));
        assertEquals(false, result);
    }
}