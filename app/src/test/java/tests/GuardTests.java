package tests;

import com.game.zavixdragon.runnerscraft.backend.guards.Guard;
import com.game.zavixdragon.runnerscraft.backend.guards.GuardName;
import com.game.zavixdragon.runnerscraft.backend.guards.GuardTrait;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public final class GuardTests {
    private final Guard guard = new Guard(GuardName.Fortress, new LinkedList<>(Arrays.asList(GuardTrait.Password, GuardTrait.GeneVerification, GuardTrait.SecurityToken)));

    @Test
    public void Guard_ShouldPenetrateWith2MatchingTraits() {
        boolean result = guard.canPenetrate(new LinkedList<>(Arrays.asList(GuardTrait.Password, GuardTrait.GeneVerification)));
        assertEquals(true, result);
    }

    @Test
    public void ShouldNotPenetrateWith1MatchingTrait() {
        boolean result = guard.canPenetrate(new LinkedList<>(Arrays.asList(GuardTrait.Password)));
        assertEquals(false, result);
    }

    @Test
    public void UponUpdating_ShouldLoseItsThirdTrait() {
        guard.update();
        assertEquals(false, guard.Traits.contains(GuardTrait.SecurityToken));
    }

    @Test
    public void UponUpdating_ShouldStillHaveOtherTwoTraits() {
        guard.update();
        assertEquals(true, guard.Traits.contains(GuardTrait.Password));
        assertEquals(true, guard.Traits.contains(GuardTrait.GeneVerification));
    }

    @Test
    public void UponUpdating_ShouldNotBePenetratedWithTheThirdTrait() {
        guard.update();
        boolean result = guard.canPenetrate(new LinkedList<>(Arrays.asList(GuardTrait.GeneVerification, GuardTrait.SecurityToken)));
        assertEquals(false, result);
    }

    @Test
    public void ShouldNotBeUpdated() {
        assertEquals(false, guard.isUpdated());
    }

    @Test
    public void UponUpdating_ShouldBeUpdated() {
        guard.update();
        assertEquals(true, guard.isUpdated());
    }
}
