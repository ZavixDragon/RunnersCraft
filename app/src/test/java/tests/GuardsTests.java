package tests;

import com.game.zavixdragon.runnerscraft.backend.Concat;
import com.game.zavixdragon.runnerscraft.backend.guards.GuardName;
import com.game.zavixdragon.runnerscraft.backend.guards.GuardTrait;
import com.game.zavixdragon.runnerscraft.backend.guards.Guards;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public final class GuardsTests {
    private final Guards guards = new Guards(new Random());

    @Test
    public void CanPenetrateWithNoGuards() {
        boolean result = guards.canPenetrate(new ArrayList<GuardTrait>(), new ArrayList<GuardName>());
        assertEquals(true, result);
    }

    @Test
    public void CanNotPenetrateWithOneGuardWithoutAttackVectors() {
        boolean result = guards.canPenetrate(new ArrayList<GuardTrait>(), Arrays.asList(GuardName.Fortress));
        assertEquals(false, result);
    }

    @Test
    public void CanNotPenetrateWhenOnlySomeOfTheGuardsPenetrated() {
        boolean result = guards.canPenetrate(guards.Values.get(0).Traits, Arrays.asList(guards.Values.get(0).Name, guards.Values.get(1).Name));
        assertEquals(false, result);
    }

    @Test
    public void CanPenetrateWhenAllGuardsPenetrated() {
        boolean result = guards.canPenetrate(new Concat<>(guards.Values.get(0).Traits, guards.Values.get(1).Traits).get(), Arrays.asList(guards.Values.get(0).Name, guards.Values.get(1).Name));
        assertEquals(true, result);
    }

    @Test
    public void NonUpdatedGuards_ShouldNotGiveUpdatedGuards() {
        guards.update(GuardName.Fortress);

        List<GuardName> guardNames = guards.nonUpdatedGuards();

        assertEquals(7, guardNames.size());
        assertEquals(false, guardNames.contains(GuardName.Fortress));
    }
}
