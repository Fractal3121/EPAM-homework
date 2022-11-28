package com.epam.rd.autocode.startegy.cards.strategy;

import com.epam.rd.autocode.startegy.cards.Card;
import com.epam.rd.autocode.startegy.cards.CardDealingStrategy;
import com.epam.rd.autocode.startegy.cards.Deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FoolStrategy implements CardDealingStrategy {
    private final static String PLAYERS = "Player ";
    private final static String TRUMP = "Trump card";
    private final static String REMAINING = "Remaining";
    private final static int NUMBER_CARD = 6;

    @Override
    public Map<String, List<Card>> dealStacks(Deck deck, int players) {
        Map<String, List<Card>> deal = new TreeMap<>();
        for (int i = 0; i < players; i++) {
            deal.put(PLAYERS + String.valueOf(i+1), new ArrayList<>());
        }
        for (int i = 0; i < NUMBER_CARD; i++){
            for (int j = 0; j < players; j++) {
                deal.get(PLAYERS + String.valueOf(j+1))
                        .add(deck.dealCard());
            }
        }
        deal.put(TRUMP, new ArrayList<>());
        deal.get(TRUMP).add(deck.dealCard());
        deal.put(REMAINING, deck.restCards());


        return deal;
    }
}
