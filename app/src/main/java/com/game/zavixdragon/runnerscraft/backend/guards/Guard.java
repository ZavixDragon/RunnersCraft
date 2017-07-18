package com.game.zavixdragon.runnerscraft.backend.guards;

import java.util.List;

public final class Guard {
    public final GuardName Name;
    public final List<GuardTrait> Traits;

    public Guard(GuardName name, List<GuardTrait> traits) {
        Name = name;
        Traits = traits;
    }

    public void update() {
        Traits.remove(Traits.get(2));
    }

    public boolean canPenetrate(final List<GuardTrait> attackVectors) {
        int matchingTraits = 0;
        for (GuardTrait trait : Traits)
            if (attackVectors.contains(trait))
                matchingTraits++;
        return matchingTraits >= 2;
    }

    public boolean isUpdated() {
        return Traits.size() == 2;
    }
}