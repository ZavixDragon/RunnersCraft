package com.game.zavixdragon.runnerscraft.backend.guards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Guards {
    public final List<Guard> Values;

    public Guards(Random random) {
        this(new GuardFactory(random).create());
    }

    public Guards(List<Guard> values) {
        Values = values;
    }

    public boolean canPenetrate(List<GuardTrait> attackVectors, List<GuardName> guards) {
        for (Guard guard : Values)
            if (guards.contains(guard.Name) && !guard.canPenetrate(attackVectors))
                return false;
        return true;
    }

    public void update(GuardName name) {
        for (Guard guard : Values)
            if (guard.Name == name)
                guard.update();
    }

    public List<GuardName> nonUpdatedGuards() {
        List<GuardName> results = new ArrayList<>();
        for (Guard guard : Values)
            if (!guard.isUpdated())
                results.add(guard.Name);
        return results;
    }
}
