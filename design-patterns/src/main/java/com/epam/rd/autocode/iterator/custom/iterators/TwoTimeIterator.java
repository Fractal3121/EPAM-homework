package com.epam.rd.autocode.iterator.custom.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TwoTimeIterator implements Iterator<Integer>{
    private final int [] array;
    private final int maxCount;
    private int index;
    private int counter;

    public TwoTimeIterator(int[] array, int maxCount) {
        this.array = array;
        this.maxCount=maxCount;
    }

    @Override
    public boolean hasNext() {
        return index < array.length;
    }

    @Override
    public Integer next() {
        if(hasNext()){
            counter++;
            return array[twoOutput()];
        }else
            throw new NoSuchElementException();
    }

    public int twoOutput(){
        int value = index;
        if (counter == maxCount){
            index++;
            resetCounter();
        }
        return value;
    }

    public void resetCounter(){
        counter = 0;
    }
}
