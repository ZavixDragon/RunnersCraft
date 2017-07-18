package tests;

import com.game.zavixdragon.runnerscraft.backend.watchers.WatcherName;
import com.game.zavixdragon.runnerscraft.backend.watchers.WatcherTrait;
import com.game.zavixdragon.runnerscraft.backend.watchers.Watchers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public final class WatchersTests {
    private final Watchers watchers = new Watchers(new Random());

    @Test
    public void ShouldNotBeDetectedWhenNoWatchers() {
        boolean result = watchers.canDetect(watchers.Values.get(0).Traits, new ArrayList<WatcherName>());
        assertEquals(false, result);
    }

    @Test
    public void ShouldNotBeDetectedWhenNoSignatures() {
        boolean result = watchers.canDetect(new ArrayList<WatcherTrait>(), Arrays.asList(watchers.Values.get(0).Name));
        assertEquals(false, result);
    }

    @Test
    public void ShouldBeDetectedWhenMatchingSignature() {
        boolean result = watchers.canDetect(watchers.Values.get(0).Traits, Arrays.asList(watchers.Values.get(0).Name));
        assertEquals(true, result);

    }
}
