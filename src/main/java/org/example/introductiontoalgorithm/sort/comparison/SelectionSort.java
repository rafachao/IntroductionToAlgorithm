package org.example.introductiontoalgorithm.sort.comparison;

import java.util.Arrays;

/**
 * 选择排序
 * 2.2节课后习题第2道
 * 选择排序（Selection Sort）是一种简单直观的排序方法。它的工作原理如下，首先在未排序序列中找到最小元素，
 * 存放到排序序列的其实位置，然后，再从剩余未排序元素中继续寻找最小元素，然后放到已排序序列的末尾。以此类推，直到所有元素
 * 均排序完毕。
 * 选择排序的主要优点与数据移动有关。如果某个位置位于正确的最终位置上，则它不会被移动。选择排序每次交换一对元素，它们当中至少
 * 有一个将被移到最终位置上，因此对n个元素的表进行排序总共进行至多（n-1）次交换。
 * In computer science, an in-place algorithm (原地算法) is an algorithm which transforms input using no auxiliary data
 * structure.However, a small amount of extra storage space is allowed for auxiliary variables.
 * Selection is an in-place comparison sorting algorithm.It has an O(n^2) time complexity.
 */
public class SelectionSort {
    public static void selectionSort (int[] arr) {
        int len = arr.length;
        int indexOfMinValue;
        int tmp;
        for (int i = 0; i < len -1; i++) {
            indexOfMinValue = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[indexOfMinValue]) {
                    indexOfMinValue = j;
                }
            }
            if (i != indexOfMinValue) {
                tmp = arr[i];
                arr[i] = arr[indexOfMinValue];
                arr[indexOfMinValue] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,8,7,5,99,12,9};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
