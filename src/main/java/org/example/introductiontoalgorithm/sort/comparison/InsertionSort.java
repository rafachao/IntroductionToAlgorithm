package org.example.introductiontoalgorithm.sort.comparison;

import java.util.Arrays;

/**
 * 插入排序
 * 2.1节
 * 插入排序是一种简单直观的排序算法。
 * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后往前扫描，找到相应位置并插入。
 * 插入排序在实现上，通常采用in-place排序（即只需用到O（1）的额外空间的排序），
 * 因而在从后往前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
 */
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int len = arr.length;
        int tmp;
        for (int i = 1; i < len; i++) {
            tmp = arr[i];
            // 从后往前扫描
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                    tmp = arr[j - 1];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,8,7,5,99,12,9};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
