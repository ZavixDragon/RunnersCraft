package com.game.zavixdragon.runnerscraft.backend;

import java.util.ArrayList;
import java.util.List;

public final class Concat<T> {
    private final List<T> list1;
    private final List<T> list2;

    public Concat(List<T> list1, List<T> list2) {
        this.list1 = list1;
        this.list2 = list2;
    }

    public List<T> get() {
        List<T> concatedList = new ArrayList<T>();
        concatedList.addAll(list1);
        concatedList.addAll(list2);
        return concatedList;
    }
}
