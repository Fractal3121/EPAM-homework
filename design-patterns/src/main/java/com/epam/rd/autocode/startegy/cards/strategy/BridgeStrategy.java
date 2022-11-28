package com.epam.rd.autocode.startegy.cards.strategy;

import com.epam.rd.autocode.startegy.cards.Card;
import com.epam.rd.autocode.startegy.cards.CardDealingStrategy;
import com.epam.rd.autocode.startegy.cards.Deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BridgeStrategy implements CardDealingStrategy {
    private final static String PLAYER = "Player ";
    private final static int CARD_NUMBER = 13;
    @Override
    public Map<String, List<Card>> dealStacks(Deck deck, int players) {
        Map<String, List<Card>> deal = new TreeMap<>();
        for (int i = 0; i < players; i++) {
            deal.put(PLAYER + String.valueOf(i+1), new ArrayList<>());
        }
        for (int i = 0; i < CARD_NUMBER ; i++) {
            for (int j = 0; j < players; j++) {
                deal.get(PLAYER + String.valueOf(j+1)).add(deck.dealCard());
            }

        }
        return deal;
    }
}
