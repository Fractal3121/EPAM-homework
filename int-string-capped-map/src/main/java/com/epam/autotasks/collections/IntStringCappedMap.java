package com.epam.autotasks.collections;

import java.util.*;

class IntStringCappedMap extends AbstractMap<Integer, String> {

    Map<Integer, String> map = new LinkedHashMap<>(20, (float) 0.9, true);

    private final long capacity;

    public IntStringCappedMap(final long capacity) {this.capacity = capacity;}

    public long getCapacity() {return capacity;}

    private int count;

    @Override
    public Set<Entry<Integer, String>> entrySet() {
        return new AbstractSet<>() {
            @Override
            public Iterator<Entry<Integer, String>> iterator() {
                return new Iterator<>() {
                    final Iterator<Entry<Integer, String>> iterator = map.entrySet().iterator();
                    @Override
                    public boolean hasNext() {return iterator.hasNext();}

                    @Override
                    public Entry<Integer, String> next() {return iterator.next();}
                };
            }

            @Override
            public int size() {
                return IntStringCappedMap.this.size();
            }
        };
    }

    @Override
    public String get(final Object key) {return map.get(key);}

    @Override
    public String put(final Integer key, final String value) {
        count = 0;
        if(value==null) throw new NullPointerException();
        if(value.length()>capacity) throw new IllegalArgumentException();
        String string = map.put(key,value);

        for (String s : map.values()){
            count += s.length();
        }

        while (count>capacity){

            map.remove(map.keySet().stream().iterator().next());
            count = 0;

            for (String s : map.values()){
                count += s.length();
            }
        }
        return string;
    }

    @Override
    public String remove(final Object key) {return  map.remove(key);}

    @Override
    public int size() {return map.size();}

}
