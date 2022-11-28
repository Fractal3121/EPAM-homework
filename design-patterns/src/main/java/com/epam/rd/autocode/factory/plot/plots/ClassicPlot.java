package com.epam.rd.autocode.factory.plot.plots;

import com.epam.rd.autocode.factory.plot.Character;
import com.epam.rd.autocode.factory.plot.Plot;

public class ClassicPlot implements Plot {
    private final Character hero;
    private final Character beloved;
    private final Character villain;

    public ClassicPlot(Character hero, Character beloved, Character villain) {
        this.hero = hero;
        this.beloved = beloved;
        this.villain = villain;
    }

    public String toString() {
        return hero.name() + " is great. " +
                hero.name() + " and " +
                beloved.name() + " love each other. " +
                villain.name() + " interferes with their happiness but loses in the end.";
    }
}
