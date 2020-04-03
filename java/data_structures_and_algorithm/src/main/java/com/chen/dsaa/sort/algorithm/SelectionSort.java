package com.chen.dsaa.sort.algorithm;

/**
 * 选择排序
 * 选择排序是表现最稳定的排序算法之一，因为无论什么数据进去都是O(n2)的时间复杂度，所以用到它的时候，数据规模越小越好。
 *
 * 选择排序是一种简单直观的排序算法。
 *
 * 它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕。
 *
 * 算法描述
 * n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：
 * （1）初始状态：无序区为R[1…n]，有序区为空；
 * （2）第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1…i-1]和R(i…n）。
 * 该趟排序从当前无序区中选出关键字最小的记录R[k]，将它与无序区的第1个记录R交换，
 * 使R[1…i]和R[i+1…n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
 * （3）n-1趟结束，数组有序化了。
 *
 * 算法分析
 * 最佳情况：T(n) = O(n2)
 * 最差情况：T(n) = O(n2)
 * 平均情况：T(n) = O(n2)
 *
 * 总结选择排序算法理解：
 * 每次循环都选择一个元素i与后续所有元素比较，找出最小的一个并放到i的位置（如果i不是
 * 最小的）。因此，外层循环很明显就是0...array.length - 1。内层循环则是i...array.length。
 *
 */
public class SelectionSort implements Algorithm {
    /**
     * 下面两个方法的代码执行的最终结果是一致的，
     * 但是我觉得第一个方法应该更好一点。因为只有
     * 发现了更小的值之后，才产生替换操作。比如当前
     * 无序区第一个元素是1，并且1已经是最小的值了，
     * 那么只需要将1作为有序区最后一个元素即可，不
     * 会与任何元素进行替换（即1自身）。
     * 另外，在替换的时候，从代码上看与冒泡排序有些相似，
     * 但原理是不一样的。冒泡排序是相邻比较，而选择排序
     * 是固定一个元素与后续所有元素比较。
     *
     */
    @Override
    public void doSort(int[] array) {
        int minimum = 0;

        for (int i = 0; i < array.length - 1; i++) {
            minimum = array[i];
            for (int j = i; j < array.length; j++) {
                if (array[j] < minimum) {
                    minimum = array[j];
                    array[j] = array[i];
                    array[i] = minimum;
                }
            }
        }
    }

    public void _doSort(int[] array) {
        int minimumIndex = 0;
        int temp = 0;

        for (int i = 0; i < array.length - 1; i++) {
            minimumIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minimumIndex]) {
                    minimumIndex = j;
                }
            }
            temp = array[i];
            array[i] = array[minimumIndex];
            array[minimumIndex] = temp;
        }
    }

    @Override
    public String getName() {
        return "选择排序";
    }
}
