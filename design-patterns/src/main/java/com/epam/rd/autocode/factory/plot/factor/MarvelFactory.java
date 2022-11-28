package com.epam.rd.autocode.factory.plot.factor;

import com.epam.rd.autocode.factory.plot.Character;
import com.epam.rd.autocode.factory.plot.EpicCrisis;
import com.epam.rd.autocode.factory.plot.Plot;
import com.epam.rd.autocode.factory.plot.PlotFactory;
import com.epam.rd.autocode.factory.plot.plots.MarvelPlot;


public class MarvelFactory implements PlotFactory {
    public final Character[] heroes;
    public final EpicCrisis epicCrisis;
    public final Character villain;

    public MarvelFactory(Character[] heroes, EpicCrisis epicCrisis, Character villain) {
        this.heroes = heroes;
        this.epicCrisis = epicCrisis;
        this.villain = villain;
    }

    @Override
    public Plot plot() {
        return new MarvelPlot(getHeroes(), getEpicCrisis(), getVillain());
    }

    @Override
    public Character getHero() {
        return null;
    }

    @Override
    public Character[] getHeroes() {
        return heroes;
    }

    @Override
    public Character getBeloved() {
        return null;
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
        return epicCrisis;
    }
}
