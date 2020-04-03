package com.chen.dsaa.sort.algorithm;

/**
 * 插入排序
 * 插入排序的算法描述是一种简单直观的排序算法。它的工作原理是通过构建有序序列，
 * 对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。插入排序在
 * 实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），因而在从后
 * 向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
 *
 * 算法描述
 * （1）从第一个元素开始，该元素可以认为已经被排序；
 * （2）取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * （3）如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * （4）重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * （5）将新元素插入到该位置后；
 * （6）重复步骤2~5。
 *
 * 算法分析
 * 最佳情况：T(n) = O(n)
 * 最坏情况：T(n) = O(n2)
 * 平均情况：T(n) = O(n2)
 *
 * 插入排序的算法理解
 * 难点是有序区和无序区的界限。第一个要注意的地方是，假设当前数组的索引是i，取出了
 * array[i]的值后，array[i]就可以被覆盖了并且由前向后逐个覆盖并不会丢失数据。比如，
 * i = 3，[4, 5, 6, 3, 1, 2]。array[i] = 3，覆盖数据的步骤是[4, 5, 6, 6, 1, 2]然后
 * [4, 5, 5, 6, 1, 2]再然后[4, 4, 5, 6, 1, 2]。可以看到是不会丢失任何数据的。最后
 * 的结果只有两种情况，第一种是索引已经到了-1，也就是array[0]依然比array[i]要大，那么
 * 直接把array[i]赋值给array[0]即可，也就是array[index + 1]。第二种情况是，在某个索引
 * 处array[index]小于array[i]，那么依然把array[i]赋值给array[index + 1]。所以，只要确
 * 定了比较的元素以及最后停在那个索引上即可。
 */
public class InsertionSort implements Algorithm {
    public void _doSort(int[] array) {
        int temp = 0;
        int index = 0;

        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            index = i - 1;
            while (true) {
                if (index < 0) {
                    array[index + 1] = temp;
                    break;
                } else if (array[index] > temp) {
                    array[index + 1] = array[index];
                } else if (array[index] < temp) {
                    array[index + 1] = temp;
                    break;
                }           
                index--;
            }
        }
    }

    /**
     * 上面的方法的代码显得更加复杂，但是对算法的描述更清晰。
     * 注意内层while循环的判断条件是index大于-1并且array[index]
     * 大于array[i]。如果是或者的关系，那么在index小于0的时候，
     * array[index]就会有异常了。
     */
    @Override
    public void doSort(int[] array) {
        int temp = 0;
        int index = 0;

        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            index = i - 1;
            while (index > -1 && array[index] > temp) {
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = temp;
        }
    }

    @Override
    public String getName() {
        return "插入排序";
    }
}
