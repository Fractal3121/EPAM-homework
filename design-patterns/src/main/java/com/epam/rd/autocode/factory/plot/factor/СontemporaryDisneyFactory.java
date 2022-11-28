package com.epam.rd.autocode.factory.plot.factor;

import com.epam.rd.autocode.factory.plot.Character;
import com.epam.rd.autocode.factory.plot.EpicCrisis;
import com.epam.rd.autocode.factory.plot.Plot;
import com.epam.rd.autocode.factory.plot.PlotFactory;
import com.epam.rd.autocode.factory.plot.plots.СontemporaryPlot;

public class СontemporaryDisneyFactory implements PlotFactory {
    public final Character hero;
    public final EpicCrisis epicCrisis;
    public final Character funnyFriend;

    public СontemporaryDisneyFactory(Character hero, EpicCrisis epicCrisis, Character funnyFriend) {
        this.hero = hero;
        this.epicCrisis = epicCrisis;
        this.funnyFriend = funnyFriend;
    }

    @Override
    public Plot plot() {
        return new СontemporaryPlot(getHero(), getEpicCrisis(), getFunnyFriend());
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
        return null;
    }

    @Override
    public Character getVillain() {
        return null;
    }

    @Override
    public Character getFunnyFriend() {
        return funnyFriend;
    }

    @Override
    public EpicCrisis getEpicCrisis() {
        return epicCrisis;
    }
}
