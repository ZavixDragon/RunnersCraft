package com.game.zavixdragon.runnerscraft.backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class TraitCombos<T> {
    private final Random random;
    private final List<T> traits;

    public TraitCombos(Random random, List<T> traits) {
        this.random = random;
        this.traits = traits;
    }

    public List<List<T>> generate() {
        attempt:
        while (true) {
            List<List<T>> combos = createEmptyList();
            for (int traitCount = 0; traitCount < 3; traitCount++) {
                for (List<T> combo : combos) {
                    List<T> traitChoices = new ArrayList<>();
                    filter:
                    for (T trait : traits) {
                        if (combo.contains(trait))
                            continue;
                        for (List<T> combo2 : combos) {
                            if (combo2.size() == combo.size() + 1
                                && combo2.get(combo2.size() - 1) == trait)
                                    continue filter;
                            if (combo2.size() == 3) {
                                boolean shouldFilterOut = true;
                                for (T comboTrait : combo)
                                    if (!combo2.contains(comboTrait))
                                        shouldFilterOut = false;
                                if (shouldFilterOut)
                                    for (T combo2Trait : combo2)
                                        if (trait == combo2Trait)
                                            continue filter;
                            }
                        }
                        traitChoices.add(trait);
                    }
                    if (traitChoices.size() == 0)
                        continue attempt;
                    combo.add(traitChoices.get(random.nextInt(traitChoices.size())));
                }
            }
            return combos;
        }
    }

    private List<List<T>> createEmptyList() {
        List<List<T>> combos = new ArrayList<>();
        for (int i = 0; i < 8; i++)
            combos.add(new ArrayList<T>());
        return combos;
    }
}
