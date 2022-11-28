package com.efimchick.ifmo.streams.countwords;


import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class Words {

    public String countWords(List<String> lines) {
        String line = lines
                .stream()
                .flatMap(str -> Arrays.stream(str.toLowerCase().split("[^а-яА-Яa-zA-Z]")))
                .filter(str -> str.length() >= 4)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .filter(w -> w.getValue() >= 10)
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(w -> String.format("%s - %d\n", w.getKey(), w.getValue()))
                .collect(Collectors.joining());

        return line.trim();
    }
}
