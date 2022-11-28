package com.epam.autotasks.collections;

import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

class RangedOpsIntegerSet extends AbstractSet<Integer> {
    class WrapInt{
        public int value;
    }
    Integer [] array = new Integer [1000];
    Integer [] max;

    public boolean hasNext(WrapInt index) {
        for (int i = index.value+1; i < max.length ; i++) {
            if(max[i] != null) return true;
        }
        return false;
    }

    public Integer next(WrapInt index) {
        for (int i = index.value+1; i < max.length ; i++) {
            if(max[i] != null) {
                index.value = i;
                return max[i];
            }
        }
        throw new NoSuchElementException();
    }

    public boolean add(int fromInclusive, int toExclusive) {
        try{
            boolean k = false;
            if(fromInclusive < toExclusive){
                for (int j = fromInclusive; j < toExclusive; j++){
                    if(add(j)) k = true;
                }
            }
            return k;
        }
        catch (Exception ex) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean remove(int fromInclusive, int toExclusive) {
        try {
            boolean k = false;
            if(fromInclusive < toExclusive){
                for (int i =  fromInclusive; i < toExclusive; i++) {
                    //remove(i);
                    if(remove(i)) k = true;
                }
            }
            return k;
        }
        catch (Exception ex) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public boolean add(final Integer integer) {
        try{
            if(integer != null) {
                for (int i = 0; i < array.length; i++) {
                    if (integer.equals(array[i])) return false;
                }
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == null) {
                        array[i] = integer;
                        return true;
                    }
                }
            }
            return false;
        }
        catch (Exception ex) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public boolean remove(final Object o) {
        try {
            if(o != null) {
                for (int i = 0; i < array.length; i++) {
                    if (o.equals(array[i])){
                        array[i] = null;
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        catch (Exception ex) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        class SetIterator implements Iterator<Integer>{
            private RangedOpsIntegerSet set;
            private WrapInt index;

            public SetIterator(RangedOpsIntegerSet set) {
                this.set = set;
                this.index = new WrapInt();
                this.index.value = -1;
            }

            @Override
            public boolean hasNext() {
                return set.hasNext(index);
            }

            @Override
            public Integer next() {
                return set.next(index);
            }
        }
        int count = 0;
        int len = array.length;
        int [] index = new int[len];

        for (int i = 0; i < array.length ; i++) {
            if(array[i] != null){
                count++;
                index[i] = 1;
            }
            else{
                index[i] = 0;
            }

        }
        max = new Integer[count];
        count = 0;
        for (int i = 0; i < len; i++) {
            if (index[i] == 1){
                max[count] = array[i];
                ++count;
            }
        }
        Arrays.sort(max);
        return new SetIterator(this);
    }

    @Override
    public int size() {
        int counter = 0;
        try {
            for (int i = 0; i < array.length ; i++) {
                if(array[i] != null) counter++;
            }
            return counter;
        }
        catch (Exception ex) {
            throw new UnsupportedOperationException();
        }
    }
}
