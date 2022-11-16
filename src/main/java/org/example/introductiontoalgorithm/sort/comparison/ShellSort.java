package org.example.introductiontoalgorithm.sort.comparison;

import java.util.Arrays;

/**
 * 希尔排序（Shellsort），也称递减增量排序算法，是插入排序的一种更高效的改进版本。和简单插入排序不同的是，希尔排序是非稳定排序算法，选取不同增量
 * 进行排序时，可能导致数值相同的两个元素发生相对位置上的改变。
 * 陈越版数据结构书中7.3.2小节讲了希尔排序。
 * 希尔排序的基本原理是：将待排序的一组元素按一定间隔分为若干个序列，分别进行插入排序。开始时设置的"间隔"较大，在
 * 每轮排序中将间隔逐步减小，直到"间隔"为1，也就是最后一步是进行简单插入排序。
 * 希尔排序是基于插入排序的以下几点
 * 插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率；
 * 但插入排序一般来说是比较低效的，因为插入排序每次只能将数据移动一位。
 * 希尔排序是按其设计者希尔（Donald Shell）的名字命名，该算法在1959年公布。
 * 希尔排序也称递减增量排序算法。
 * 希尔排序通过将比较的全部元素分为几个区域来提升插入排序的性能。这样可以让一个元素一次性地朝最终位置前进一大步。然后算法
 * 再取越来越小的步长进行排序，算法的最后一步就是普通的插入排序，但是到了这步，需排序的数据几乎是已经排好的了（此时插入排序较快）。
 *
 * master测试
 * master再次测试
 * hot-fix测试
 * hot-fix再次测试
 * 修改-11.15,10:48
 * 修改-11.16,11:20
 * github上直接修改——11.16，11:27
 * 11.16,15:12
 * github 15:18
 * 15：23
 * 15：25本地
 * github 15:24
 * github 15:26
 */
public class ShellSort {

    // 常见的步长序列：
    // n/(2^i) 最坏情况复杂度：O(n^2)
    // 2^k-1 最坏情况复杂度：O(n^(3/2))
    // (2^i)(3^j) 最坏情况复杂度：O(nlog2n)
    // 已知最好步长序列是sedgewick提出的（1，5，19，109，...）,该序列的项来自9*4^i-9*2^i+1和4^i-3*2^i+1的形式
    public void shellSort(int[] arr) {
        int len = arr.length;
        int tmp;
        // 这里就采用步长为n/(2^i)的形式
        for (int step = len/2; step >= 1; step /= 2) {
            for (int i = step; i < len; i++) {
                tmp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > tmp) { // 不满足该条件时说明j是i索引处的元素要插入的位置的前一个位置
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,8,7,5,99,12,9};
        new ShellSort().shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
