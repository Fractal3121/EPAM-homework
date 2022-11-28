package com.epam.rd.autocode.iterator;

import com.epam.rd.autocode.iterator.custom.iterators.FiveTimeIterator;
import com.epam.rd.autocode.iterator.custom.iterators.MatrixIterator;
import com.epam.rd.autocode.iterator.custom.iterators.TripleTimeIteratot;
import com.epam.rd.autocode.iterator.custom.iterators.TwoTimeIterator;

import java.util.Iterator;

class Iterators {

    public static Iterator<Integer> intArrayTwoTimesIterator(int[] array){
        return new TwoTimeIterator(array, 2);
    }

    public static Iterator<Integer> intArrayThreeTimesIterator(int[] array) {
        return new TwoTimeIterator(array, 3);
    }

    public static Iterator<Integer> intArrayFiveTimesIterator(int[] array) {
        return new TwoTimeIterator(array, 5);
        }

    public static Iterable<String> table(String[] columns, int[] rows){
        return new MatrixIterator(columns, rows);
    }



}
