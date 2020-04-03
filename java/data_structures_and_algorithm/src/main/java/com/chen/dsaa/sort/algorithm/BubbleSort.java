package com.chen.dsaa.sort.algorithm;

/**
 * 冒泡排序
 * 冒泡排序 是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。
 * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
 * 这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
 *
 * 算法描述：
 * （1）比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * （2）对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * （3）针对所有的元素重复以上的步骤，除了最后一个；
 * （4）重复步骤1~3，直到排序完成。
 *
 * 算法分析：
 * 最佳情况：T(n) = O(n)
 * 最差情况：T(n) = O(n2)
 * 平均情况：T(n) = O(n2)
 *
 * 总结理解冒泡排序的方法：
 * 第一次对比会一直对比到数组的最后一个元素，第二次对比会比到倒数第一个
 * 元素，以此类推。最后一次对比到第二个元素，因此外层循环应该是array.length - 1...1
 * 而每一次对比，都会从第一个元素开始选择，一直选到倒数第二个元素。假设
 * 外层循环的变量为i，那么每一次对比都会选择到i - 1。注意这里的1、array.length - 1、
 * 和i等等，都对应数组的下标。
 *
 */
public class BubbleSort implements Algorithm {
    /**
     * 这段代码的写法不如doSort()方法的写法好理解。
     * 区别是，假设array的长度是n，虽然外层循环看似
     * 执行了n次，但由于内层循环j小于i - 1的缘故，外层
     * 循环执行到i = 1时，内层循环不符合条件判断没有执行，
     * 相当于内层循环也是执行了n - 1次。
     *
     */
    public void _doSort(int[] array) {
        int temp = 0;

        for (int i = array.length; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 可以把外层循环的i大于0换成i大于等于1，把内层循环的j小于i换成
     * j小于等于i - 1。这样理解起来就更直观了。但是从表面上看，最后
     * 一次判断，大于等于或者小于等于会多判断一次。比如i = 0，先判断
     * 是否大于1再判断是否等于1。因此还是判断是否大于0更快一些（当
     * 外层循环数量庞大的时候）。
     *
     */
    @Override
    public void doSort(int[] array) {
        int temp = 0;

        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public String getName() {
        return "冒泡排序";
    }
}
