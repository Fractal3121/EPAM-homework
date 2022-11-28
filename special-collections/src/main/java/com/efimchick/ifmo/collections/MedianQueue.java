package com.efimchick.ifmo.collections;

import java.util.*;

class MedianQueue implements Queue<Integer> {
    private final LinkedList<Integer> medianQueue = new LinkedList<>();

    private void resortedQueue() {
        LinkedList<Integer> list = new LinkedList<>(medianQueue);
        Collections.sort(list);
        clear();
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            if(even(i)){
                medianQueue.addFirst(list.pollLast());
            }else{
                medianQueue.addFirst(list.pollFirst());
            }
            
        }
    }
    private boolean even(int value) {
        return value % 2 == 0;
    }


    @Override
    public int size() {
        return medianQueue.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Integer integer) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        medianQueue.clear();
    }

    @Override
    public boolean offer(Integer integer) {
        medianQueue.offer(integer);
        resortedQueue();
        return true;
    }

    @Override
    public Integer remove() {
        return null;
    }

    @Override
    public Integer poll() {
        return medianQueue.poll();
    }

    @Override
    public Integer element() {
        return null;
    }

    @Override
    public Integer peek() {
        return medianQueue.peek();
    }
}
