package com.game.zavixdragon.runnerscraft.backend.guards;

import com.game.zavixdragon.runnerscraft.backend.TraitCombos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class GuardFactory {
    private final Random random;

    public GuardFactory(Random random) {
        this.random = random;
    }

    public List<Guard> create() {
        List<Guard> guards = new ArrayList<>();
        List<List<GuardTrait>> traitCombos = new TraitCombos<>(random, Arrays.asList(GuardTrait.values())).generate();
        List<GuardName> names = new ArrayList<>(Arrays.asList(GuardName.values()));
        for (int i = 0; i < names.size(); i++)
            guards.add(new Guard(names.get(i), traitCombos.get(i)));
        return guards;
    }
}
