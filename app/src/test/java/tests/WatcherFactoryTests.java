package tests;

import com.game.zavixdragon.runnerscraft.backend.watchers.Watcher;
import com.game.zavixdragon.runnerscraft.backend.watchers.WatcherFactory;

import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public final class WatcherFactoryTests {
    @Test
    public void ShouldCreateWatchersWithAllDifferentNames() {
        List<Watcher> watchers = new WatcherFactory(new Random()).create();
        for (Watcher watcher : watchers) {
            int matches = 0;
            for (Watcher watcher2 : watchers)
                if (watcher.Name.equals(watcher2.Name))
                    matches++;
            assertEquals(1, matches);
        }
    }
}
