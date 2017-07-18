package com.game.zavixdragon.runnerscraft.backend.watchers;

import com.game.zavixdragon.runnerscraft.backend.TraitCombos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class WatcherFactory {
    private final Random random;

    public WatcherFactory(Random random) {
        this.random = random;
    }

    public List<Watcher> create() {
        List<Watcher> watchers = new ArrayList<>();
        List<List<WatcherTrait>> traitCombos = new TraitCombos<>(random, Arrays.asList(WatcherTrait.values())).generate();
        List<WatcherName> names = new ArrayList<>(Arrays.asList(WatcherName.values()));
        for (int i = 0; i < names.size(); i++)
            watchers.add(new Watcher(names.get(i), traitCombos.get(i)));
        return watchers;
    }
}
