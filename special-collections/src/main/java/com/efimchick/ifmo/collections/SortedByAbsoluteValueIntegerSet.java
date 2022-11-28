package com.efimchick.ifmo.collections;

import java.util.*;

class SortedByAbsoluteValueIntegerSet implements Set<Integer> {
    private final Set<Integer> sortedSet = new TreeSet<>(new setComporator());
    private static class setComporator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return Math.abs(o1) - Math.abs(o2);
        }
    }

    @Override
    public int size() {
        return sortedSet.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return sortedSet.contains(o);
    }

    @Override
    public Iterator<Integer> iterator() {
        return sortedSet.iterator();
    }

    @Override
    public Object[] toArray() {
        return sortedSet.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return sortedSet.toArray(a);
    }

    @Override
    public boolean add(Integer integer) {
        return sortedSet.add(integer);
    }

    @Override
    public boolean remove(Object o) {
        return sortedSet.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        c.forEach(this::add);
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        sortedSet.clear();
    }
}
