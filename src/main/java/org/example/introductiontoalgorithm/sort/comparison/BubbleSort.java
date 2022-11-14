package org.example.introductiontoalgorithm.sort.comparison;

import java.util.Arrays;

/**
 * 冒泡排序
 * 第2章课后习题第2道
 * 冒泡排序是一种简单的排序算法。它重复地走访要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。走访数列的工作
 * 是重复地进行知道没有在再需要交换，也就是该数列已经排序完成。
 * 这个算法的名字由来是因为越小的元素会经由交换慢慢"浮"到数列的顶端。
 */
public class BubbleSort {
    /**
     * 冒泡排序算法的运作如下：
     * 1.比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 2.对每一对相邻的元素作同样的工作，从开始的第一对到结尾的最后一对。第一趟结束，最后的元素将是最大的数；第二趟结束，将第二大的数放在了倒数第二的位置；
     * 3.持续每次对越来越少的元素重复以上的步骤，直到没有任何一对数字需要比较
     */
    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        int tmp;
        boolean flag = false; // 是否发生交换。如果没有发生交换（说明已经排好了），提前跳出外层循环。
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < len - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,8,7,5,99,12,9};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
