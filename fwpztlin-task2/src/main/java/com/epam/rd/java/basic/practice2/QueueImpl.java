package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueImpl implements Queue {
    private Object[] queue;
    private int maximumCapacity;
    private int currentSize;

    public QueueImpl() {
        queue = new Object[1];
        maximumCapacity = 1;
        currentSize = 0;
        
    }

    @Override
    public void clear() {
        for (int i = 0; i < currentSize; i++){
            queue[i] = null;
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
        private  int current = 0;

        @Override
        public boolean hasNext()
        {
            return current < currentSize;
        }

        @Override
        public Object next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            if(current < currentSize){
                return queue[current++];
            }
            return null;
        }

    }

    @Override
    public void enqueue(Object element) {
        if(currentSize == maximumCapacity){
            Object[] temp = new Object[2 * maximumCapacity];
            for (int i = 0; i < maximumCapacity; i++){
                temp[i] = queue[i];
            }
            maximumCapacity *= 2;
            queue = temp;
        }
        queue[currentSize++] = element;
    }

    @Override
    public Object dequeue() {
        if (currentSize > 0){
            Object o = queue[0];
            for (int i = 0; i < currentSize - 1; i++){
                queue[i] = queue[i + 1];
            }
            queue[--currentSize] = null;
            return o;
        }
        return null;
    }

    @Override
    public Object top() {
        if (currentSize > 0){
            return queue[0];
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("[");
        if (currentSize != 0){
            for (int i = 0; i < currentSize - 1; i++){
                res.append(queue[i]);
                res.append(", ");
            }
            res.append(queue[currentSize - 1]);
        }
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {

    }

}
