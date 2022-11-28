package com.epam.rd.autocode.iterator.custom.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TripleTimeIteratot implements Iterator<Integer> {
    private final int [] array;
    private int index;
    private int counter;

    public TripleTimeIteratot(int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return index < array.length;
    }

    @Override
    public Integer next() {
        if(hasNext()){
            counter++;
            return array[tripleOutput()];
        }else
            throw new NoSuchElementException();
    }

    private int tripleOutput() {
        int value = index;
        if (counter == 3){
            index++;
            resetCounter();
        }
        return value;
    }
    public void resetCounter(){
        counter = 0;
    }
}
