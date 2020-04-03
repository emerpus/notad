package com.chen.dsaa.sort;

import java.util.Random;

import com.chen.dsaa.sort.algorithm.Algorithm;
//import com.chen.dsaa.ch01.sort.algorithm.BubbleSort;
//import com.chen.dsaa.sort.algorithm.SelectionSort;
import com.chen.dsaa.sort.algorithm.InsertionSort;

/**
 * 1.随机生成5万个整数并对其进行排序，记录各算法的运行时间；
 * 2.递增地生成若干整数，如2万、4万，观察各算法运行时间的增长趋势。
 *
 * 执行[冒泡排序]算法排序1000个整型数据，消耗时间：0.005秒
 * 执行[冒泡排序]算法排序5000个整型数据，消耗时间：0.05秒
 * 执行[冒泡排序]算法排序10000个整型数据，消耗时间：0.191秒
 *
 * 执行[选择排序]算法排序1000个整型数据，消耗时间：0.004秒
 * 执行[选择排序]算法排序5000个整型数据，消耗时间：0.024秒
 * 执行[选择排序]算法排序10000个整型数据，消耗时间：0.113秒
 *
 * 执行[插入排序]算法排序1000个整型数据，消耗时间：0.004秒
 * 执行[插入排序]算法排序5000个整型数据，消耗时间：0.011秒
 * 执行[插入排序]算法排序10000个整型数据，消耗时间：0.023秒
 */
public class Main {
    Algorithm algorithm;
    Random random;
    int[] array;

    Main(Algorithm algorithm) {
        this.algorithm = algorithm;
        this.random = new Random(47);
    }

    void assembleArray(int count) {
        array = new int[count];
        for (int i = 0; i < count; i++)
            array[i] = random.nextInt();
    }

    void run(int length) {
        assembleArray(length);
        long start = System.currentTimeMillis();
        algorithm.doSort(array);
        long end = System.currentTimeMillis();
        System.out.println("执行[" + algorithm.getName() + "]算法排序" + length + "个整型数据，消耗时间：" + ((end - start) / 1000d) + "秒");
    }

    public static void main(String[] args) {
        Main main = new Main(new InsertionSort());
        main.run(10000);
    }
}
