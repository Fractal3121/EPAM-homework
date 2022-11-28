package com.epam.rd.autotasks;

import org.junit.Assert;
import org.junit.Test;


public class SortingTest {

    Sorting sorting = new Sorting();

    @Test(expected = IllegalArgumentException.class)
    public void testNullCase(){
        sorting.sort(null);
    }

    @Test
    public void testEmptyCase(){
        int[] array = new int[0];
        sorting.sort(array);
        int [] expected = {};
        int[] actual = array;
        Assert.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSingleElementArrayCase() {
        int[] array = {6};
        sorting.sort(array);
        int [] expected = {6};
        int[] actual = array;
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortedArraysCase() {
        int[] array =  {1, 2, 3, 4}; ;
        sorting.sort(array);
        int [] expected = {1, 2, 3, 4};;
        int[] actual = array;
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testOtherCases() {
        int[] array = {-12, 0, 0, 17, 1, 1, 2, 5, -11};
        sorting.sort(array);
        int [] expected = {-12, -11, 0, 0, 1, 1, 2, 5, 17};
        int[] actual = array;
        Assert.assertArrayEquals(expected, actual);
    }

}