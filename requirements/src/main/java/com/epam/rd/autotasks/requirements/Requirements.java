package com.epam.rd.autotasks.requirements;

public class Requirements {

    public static void requireNonNull(Object obj) {
        if(obj == null) throw new NullPointerException();

    }

    public static void requireNonNull(Object obj, String message) {
        try{
            if (obj == null){
                throw new NullPointerException(message);
            }
        }
        catch (NullPointerException e){
            throw e;
        }

    }

    public static void checkArgument(boolean value) {
        if (value == false) throw new IllegalArgumentException();

    }

    public static void checkArgument(boolean value, String message) {
        try {
            if (value == false) throw new IllegalArgumentException(message);

        }
        catch (IllegalArgumentException i){
            throw i;
        }
    }

    public static void checkState(boolean value) {
        if (value == false) throw new IllegalStateException();
    }

    public static void checkState(boolean value, String message) {
        try{
            if (value == false) throw new IllegalStateException(message);
        }
        catch (IllegalStateException s){
            throw s;
        }

    }

    public static void checkIndex(int index, int size) {
        try {
            if ( index >= size|| index < 0) throw  new IndexOutOfBoundsException();
        }
        catch (IndexOutOfBoundsException io){
            throw io;
        }

    }


}
