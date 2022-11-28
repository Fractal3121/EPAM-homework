package com.efimchick.ifmo.collections;

import java.util.*;

class PairStringList extends AbstractList<String> {

    private final List<String> list = new LinkedList<>();

    @Override
    public boolean add(String s) {
        list.addAll(List.of(s, s));
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        for (String element : c) {
            add(index, element);
            index += 2;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        for (String element : c) {
            add(element);
        }
        return true;
    }

    @Override
    public void add(int index, String element) {
        if (index % 2 > 0){
            list.addAll(index + 1, List.of(element, element));
        }else{
            list.addAll(index, List.of(element, element));
        }
    }

    @Override
    public String remove(int index) {
        String rem = list.get(index);
        list.removeAll(List.of(rem));
        return rem;
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean remove(Object o) {
        list.removeAll(List.of(o));
        return true;
    }

    @Override
    public Iterator<String> iterator() {
        return list.iterator();
    }

    @Override
    public String get(int index) {
        return list.get(index);
    }

    @Override
    public String set(int index, String element) {
        if (index % 2 > 0){
            list.set(index, element);
            list.set(index - 1, element);
        }else{
            list.set(index, element);
            list.set(index + 1, element);
        }
        return element;
    }

    @Override
    public ListIterator<String> listIterator() {
        return list.listIterator();
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        return list.listIterator(index);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }
}
