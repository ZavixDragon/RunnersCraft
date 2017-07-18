package tests;

import com.game.zavixdragon.runnerscraft.backend.TraitCombos;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public final class TraitCombosTests {
    private List<Integer> traits;
    private List<List<Integer>> combos;

    @Before
    public void Init() {
        traits = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7);
        combos = new TraitCombos(new Random(), traits).generate();
    }

    @Test
    public void ShouldHaveEightCombos() {
        assertEquals(8, combos.size());
    }

    @Test
    public void AllValuesGeneratedShouldBeDifferentCombinations() {
        for (List<Integer> combo : combos) {
            int matches = 0;
            for (List<Integer> combo2 : combos) {
                if (combo2.size() == combo.size()
                    && combo2.contains(combo.get(0))
                    && combo2.contains(combo.get(1))
                    && combo2.contains(combo.get(2)))
                    matches++;
            }
            assertEquals(1, matches);
        }
    }

    @Test
    public void ShouldBeThreeOfEachTraits() {
        for (Integer trait : traits) {
            int matches = 0;
            for (List<Integer> combo : combos)
                for (Integer comboTrait : combo)
                    if (trait.equals(comboTrait))
                        matches++;
            assertEquals(3, matches);
        }
    }

    @Test
    public void ShouldHaveADifferentFinalTraitOnEachCombo() {
        for (List<Integer> combo : combos) {
            int matches = 0;
            for (List<Integer> combo2 : combos) {
                if (combo.get(2).equals(combo2.get(2)))
                    matches++;
            }
            assertEquals(1, matches);
        }
    }

    @Test
    public void AllCombosShouldHaveThreeTraits() {
        for (List<Integer> combo : combos)
            assertEquals(3, combo.size());
    }
}
