package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackImpl implements Stack {
    private Object[] stack;
    private  int maxCapacity;
    private int currentSize;

    public StackImpl(){
        stack = new Object[1];
        maxCapacity = 1;
        currentSize = 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < currentSize; i++){
            stack[i] = null;
        }
        currentSize = 0;
        
    }

    @Override
    public int size() {
        return currentSize;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        private int current =  currentSize - 1;


        @Override
        public boolean hasNext() {

            return current>= 0;
        }

        @Override
        public Object next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            if (current >= 0){
                return stack[current--];
            }
            return null;
        }

    }

    @Override
    public void push(Object element) {
        if(currentSize == maxCapacity){
            Object[] temp = new Object[2 * maxCapacity];
            for (int i = 0; i < maxCapacity; i++){
                temp[i] = stack[i];
            }
            maxCapacity *= 2;
            stack = temp;
        }
        stack[currentSize++] = element;
        
    }

    @Override
    public Object pop() {
        if (currentSize > 0){
            Object o = stack[currentSize -1];
            stack[--currentSize] = null;
            return o;
        }
        return null;
    }

    @Override
    public Object top() {
        if(currentSize > 0){
            return stack[currentSize - 1];
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("[");
        if (currentSize != 0){
            for(int i = 0; i < currentSize - 1; i++){
                res.append(stack[i]);
                res.append(", ");
            }
            res.append(stack[currentSize - 1]);
        }
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        Iterable s = new StackImpl();
        for(Object x: s){
            System.out.println(x);
        }

    }

}
