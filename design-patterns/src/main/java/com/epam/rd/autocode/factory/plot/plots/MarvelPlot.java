package com.epam.rd.autocode.factory.plot.plots;

import com.epam.rd.autocode.factory.plot.Character;
import com.epam.rd.autocode.factory.plot.EpicCrisis;
import com.epam.rd.autocode.factory.plot.Plot;


import java.util.Arrays;
import java.util.stream.Collectors;

public class MarvelPlot implements Plot {
    private final Character[] heroes;
    private final EpicCrisis epicCrisis;
    private final Character villain;

    public MarvelPlot(Character[] heroes, EpicCrisis epicCrisis, Character villain) {
        this.heroes = heroes;
        this.epicCrisis = epicCrisis;
        this.villain = villain;
    }

    public String allCharacters(Character[] heroes){
        return  Arrays.stream(heroes).map(character -> " brave " + character.name()).collect(Collectors.joining(","));
    }
    public String toString(){
        return epicCrisis.name() + " threatens the world. But" +
                allCharacters(heroes) + " on guard. So, no way that intrigues of " +
                villain.name() + " overcome the willpower of inflexible heroes";
    }
}
