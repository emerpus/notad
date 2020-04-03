package com.chen.dsaa.sort.algorithm;

import org.junit.Assert;
import org.junit.Test;

public class SelectionSortTest {
    Algorithm algorithm = new SelectionSort();

    @Test
    public void sortTest() {
        int[] raw = new int[] {13, 6, 4, 11, 5, 3, 8, 9, 15, 2, 1, 7, 14, 10, 12};
        int[] expected = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        algorithm.doSort(raw);
        Assert.assertArrayEquals(expected, raw);
    }
}
