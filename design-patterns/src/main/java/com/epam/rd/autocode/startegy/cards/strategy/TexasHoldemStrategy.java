package com.epam.rd.autocode.startegy.cards.strategy;

import com.epam.rd.autocode.startegy.cards.Card;
import com.epam.rd.autocode.startegy.cards.CardDealingStrategy;
import com.epam.rd.autocode.startegy.cards.Deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TexasHoldemStrategy implements CardDealingStrategy {
    private static final String PLAYER = "Player ";
    private static final String COMMUNITY = "Community";
    private static final String REMAINING = "Remaining";
    private static final int NUMBER_CARDS = 2;
    private static final int NUMBER_COMMUNITY = 5;


    @Override
    public Map<String, List<Card>> dealStacks(Deck deck, int players) {
        Map<String, List<Card>> allCards = new TreeMap<>();
        for(int i = 0; i < players; i++){
            allCards.put(PLAYER + String.valueOf(i+1), new ArrayList<Card>());
        }
        for(int i = 0; i < NUMBER_CARDS; i++){
            for (int j = 0; j < players; j++) {
                allCards.get(PLAYER + String.valueOf((j+1))).add(deck.dealCard());
            }
        }
        allCards.put(COMMUNITY, new ArrayList<Card>());
        for (int i = 0; i < NUMBER_COMMUNITY; i++) {
            allCards.get(COMMUNITY).add(deck.dealCard());
        }
        allCards.put(REMAINING, deck.restCards());
        return allCards;
    }
}
