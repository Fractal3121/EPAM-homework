package com.epam.rd.autocode.factory.plot;

import com.epam.rd.autocode.factory.plot.factor.ClassicDisneyFactory;
import com.epam.rd.autocode.factory.plot.factor.MarvelFactory;
import com.epam.rd.autocode.factory.plot.factor.СontemporaryDisneyFactory;

class PlotFactories {

    public PlotFactory classicDisneyPlotFactory(Character hero, Character beloved, Character villain) {
        return new ClassicDisneyFactory(hero, beloved, villain);
    }

    public PlotFactory contemporaryDisneyPlotFactory(Character hero, EpicCrisis epicCrisis, Character funnyFriend) {
        return new СontemporaryDisneyFactory(hero, epicCrisis, funnyFriend );
    }

    public PlotFactory marvelPlotFactory(Character[] heroes, EpicCrisis epicCrisis, Character villain) {
        return new MarvelFactory(heroes, epicCrisis, villain);
    }
}
