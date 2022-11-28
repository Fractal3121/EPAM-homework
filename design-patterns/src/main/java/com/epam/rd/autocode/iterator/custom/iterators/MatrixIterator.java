package com.epam.rd.autocode.iterator.custom.iterators;

import java.util.NoSuchElementException;

public class MatrixIterator implements Iterable<String> {
    private int columnsCount;
    private int rowsCount;
    private final String[] columns;
    private final int[] rows;


    public MatrixIterator(String[] columns, int[] rows) {
        this.columns=columns;
        this.rows=rows;
    }
    @Override
    public Iterator iterator() {
        return new Iterator(columns, rows);
    }

class Iterator implements java.util.Iterator<String>{
    private final String[] columns;
    private final int[] rows;

    public Iterator(String[] columns, int[] rows) {
        this.columns=columns;
        this.rows=rows;
    }

    @Override
    public boolean hasNext() {
        return  columnsCount < columns.length && rowsCount < rows.length;
    }

    @Override
    public String next() {

        String nextVal = columns[columnsCount] + String.valueOf(rows[rowsCount]);
        rowsCount++;
        if(rowsCount >= rows.length){
            columnsCount++;
            rowsCount = 0;
        }
            return nextVal;
    }
}



}
