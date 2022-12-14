package com.epam.rd.autocode.factory.plot.factor;

import com.epam.rd.autocode.factory.plot.Character;
import com.epam.rd.autocode.factory.plot.EpicCrisis;
import com.epam.rd.autocode.factory.plot.Plot;
import com.epam.rd.autocode.factory.plot.PlotFactory;
import com.epam.rd.autocode.factory.plot.plots.ClassicPlot;

public class ClassicDisneyFactory implements PlotFactory {
    public final Character hero;
    public final Character beloved;
    public final  Character villain;

    public ClassicDisneyFactory(Character hero, Character beloved, Character villain) {
        this.hero = hero;
        this.beloved = beloved;
        this.villain = villain;
    }

    @Override
    public Plot plot() {
        return new ClassicPlot(getHero(), getBeloved(), getVillain());
    }

    @Override
    public Character getHero() {
        return hero;
    }

    @Override
    public Character[] getHeroes() {
        return new Character[0];
    }

    @Override
    public Character getBeloved() {
        return beloved;
    }

    @Override
    public Character getVillain() {
        return villain;
    }

    @Override
    public Character getFunnyFriend() {
        return null;
    }

    @Override
    public EpicCrisis getEpicCrisis() {
        return null;
    }
}
