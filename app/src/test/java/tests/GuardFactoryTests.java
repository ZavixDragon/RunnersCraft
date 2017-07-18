package tests;

import com.game.zavixdragon.runnerscraft.backend.guards.Guard;
import com.game.zavixdragon.runnerscraft.backend.guards.GuardFactory;

import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public final class GuardFactoryTests {
    @Test
    public void ShouldCreateGuardsWithAllDifferentNames() {
        List<Guard> guards = new GuardFactory(new Random()).create();
        for (Guard guard : guards) {
            int matches = 0;
            for (Guard guard2 : guards)
                if (guard.Name.equals(guard2.Name))
                    matches++;
            assertEquals(1, matches);
        }
    }
}
