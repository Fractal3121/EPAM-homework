package com.epam.rd.autocode.startegy.cards.strategy;

import com.epam.rd.autocode.startegy.cards.Card;
import com.epam.rd.autocode.startegy.cards.CardDealingStrategy;
import com.epam.rd.autocode.startegy.cards.Deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ClassicPokerStrategy implements CardDealingStrategy {
    private final static String PLAYER = "Player ";
    private final static String REMAINING = "Remaining";
    private final static int NUMBER_CARD = 5;

    @Override
    public Map<String, List<Card>> dealStacks(Deck deck, int players) {
        Map<String, List<Card>> dealing = new TreeMap<>();
        for (int i = 0; i < players; i++) {
            dealing.put(PLAYER + String.valueOf(i+1), new ArrayList<>());
        }

        for (int i = 0; i < NUMBER_CARD; i++) {
            for (int j = 0; j < players; j++) {
                dealing.get(PLAYER + String.valueOf(j+1))
                        .add(deck.dealCard());
            }
        }
        dealing.put(REMAINING, deck.restCards());

        return dealing;
    }
}
