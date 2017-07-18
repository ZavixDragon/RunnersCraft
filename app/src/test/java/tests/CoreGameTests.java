package tests;

import com.game.zavixdragon.runnerscraft.backend.CoreGame;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public final class CoreGameTests {
    private final CoreGame game = new CoreGame(new Random("seed".hashCode()));

    @Test
    public void ShouldBeTheSameWithTheSameSeed() {
        CoreGame game2 = new CoreGame(new Random("seed".hashCode()));
        for (int i = 0; i < game.Guards.Values.size(); i++) {
            assertEquals(game.Guards.Values.get(i).Name, game2.Guards.Values.get(i).Name);
            assertEquals(game.Guards.Values.get(i).Traits.get(0), game2.Guards.Values.get(i).Traits.get(0));
            assertEquals(game.Guards.Values.get(i).Traits.get(1), game2.Guards.Values.get(i).Traits.get(1));
            assertEquals(game.Guards.Values.get(i).Traits.get(2), game2.Guards.Values.get(i).Traits.get(2));
        }
        for (int i = 0; i < game.Watchers.Values.size(); i++) {
            assertEquals(game.Watchers.Values.get(i).Name, game2.Watchers.Values.get(i).Name);
            assertEquals(game.Watchers.Values.get(i).Traits.get(0), game2.Watchers.Values.get(i).Traits.get(0));
            assertEquals(game.Watchers.Values.get(i).Traits.get(1), game2.Watchers.Values.get(i).Traits.get(1));
            assertEquals(game.Watchers.Values.get(i).Traits.get(2), game2.Watchers.Values.get(i).Traits.get(2));
        }
        for (int i = 0; i < game.Trackers.Values.size(); i++) {
            assertEquals(game.Trackers.Values.get(i).Name, game2.Trackers.Values.get(i).Name);
            assertEquals(game.Trackers.Values.get(i).Trait, game2.Trackers.Values.get(i).Trait);
        }
    }
}