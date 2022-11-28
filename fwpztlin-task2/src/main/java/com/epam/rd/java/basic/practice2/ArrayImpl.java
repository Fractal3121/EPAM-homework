package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayImpl implements Array {

    private Object[] array;
    private int capacity;
    private int size;

    public ArrayImpl(){
        array = new Object[1];
        capacity = 1;
        size = 0;
    }

    public ArrayImpl(int n){
        array = new Object[n];
        capacity = n;
        size = 0;
    }

	@Override
    public void clear() {
        for (int i = 0; i < size; i++){
            array[i] = null;
        }
        size = 0;
    }

	@Override
    public int size() {
        return size;
    }
	
	@Override
    public Iterator<Object> iterator() {
	    return new IteratorImpl();
    }
	
	private class IteratorImpl implements Iterator<Object> {
        private int current = 0;

        @Override
        public boolean hasNext() {

            return current < size;
        }

        @Override
        public Object next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            if (current < size){
                return array[current++];
            }
            return null;

        }

    }
	
	@Override
    public void add(Object element) {
        if (size == capacity){
            Object[] temp = new Object[2 * capacity];
            for (int i = 0; i < capacity; i++){
                temp[i] = array[i];
            }
            capacity *= 2;
            array = temp;
        }
        array[size++]= element;
    }

	@Override
    public void set(int index, Object element) {
        if (index == capacity)
            add(element);
        else
            array [index] = element;
    }

	@Override
    public Object get(int index) {
        if (index < size){
            return array[index];
        }
        return -1;
    }

	@Override
    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(array[i])){
                return i;
            }
        }
        return -1;
    }

	@Override
    public void remove(int index) {
        if(index <= size || index > 0){
            for (int i = index; i < size - 1; i++ ){
                array[i] = array[i + 1];
            }
            array[--size] = 0;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("[");
        if (size != 0){
            for (int i = 0; i < size - 1; i++){
                res.append(array[i]);
                res.append(", ");
            }
            res.append(array[size - 1]);
        }
        res.append("]");
        return res.toString();

    }

    public static void main(String[] args) {

    }

}
