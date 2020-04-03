package com.chen.dsaa.sort.algorithm;

/**
 * 一种排序算法
 */
public interface Algorithm {
    /**
     * 对一个整型数组排序
     *
     * @param array 待排序的原始数组
     *
     */
    void doSort(int[] array);

    /**
     * 
     * @return 算法名称
     */
    String getName();
}
