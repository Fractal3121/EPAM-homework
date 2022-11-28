package com.epam.rd.autocode.iterator.custom.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FiveTimeIterator implements Iterator<Integer> {
    private final int[] array;
    private int index;
    private int counter;

    public FiveTimeIterator(int[] array) {
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
            return array[fiveTime()];
        }
        else throw new NoSuchElementException();
    }
    public int fiveTime(){
        int value = index;
        if(counter == 5){
            resetCounter();
            index++;
        }
        return value;
    }
    public void resetCounter(){
        counter = 0;
    }
}
