package org.example.introductiontoalgorithm.sort.comparison;

import java.util.Arrays;

/**
 * 归并排序
 * 2.3节
 * 归并排序（Merge Sort），是创建在归并操作上的一种有效的排序算法，效率为O(nlogn)。1945年由约翰.冯.诺伊曼首次提出。
 * 该算法是采用分治法（divide and conquer）的一个非常典型的应用，且各层分治递归可以同时进行。
 */
public class MergeSort {
    /**
     * 递归法：
     * 1.申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
     * 2.设定两个指针，最初位置分别为两个已经排序序列的起始位置
     * 3.比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
     * 4.重复步骤3直到某一指针达到序列尾
     * 5.将另一序列剩下的所有元素直接复制到合并序列尾
     */
    public static void topDown(int[] arr) {
        int[] result = new int[arr.length];
        new MergeSort().recursive(arr, result, 0, arr.length - 1);
        System.out.println(Arrays.toString(result));
    }

    public void recursive(int[] arr, int[] result, int start, int end) {
        if (start >= end) {
            return;
        }
        // 分
        int mid = start +  ((end - start) >> 1);
        int start1 = start;
        int end1 = mid;
        int start2 = mid + 1;
        int end2 = end;
        recursive(arr, result, start1, end1);
        recursive(arr, result, start2, end2);
        // 治
        int k = start;
        while (start1 <= end1 && start2 <= end2) { // 检查每个排好序的数组是否到达了最后
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }
        while (start1 <= end1) {
            result[k++] = arr[start1++];
        }
        while (start2 <= end2) {
            result[k++] = arr[start2++];
        }
        for (k = start; k <= end; k++) {
            arr[k] = result[k];
        }
    }

    /**
     * 迭代法：
     * 1.将序列每相邻两个数字进行归并操作，形成ceil(n/2)个序列，排序后每个序列包含两个或一个元素
     * 2.将上述序列再次归并，形成ceil(n/4)个序列，每个序列包含四个或三个元素
     * 3.重复步骤2，直到所有元素排序完毕，即序列数为1
     */
    public static void bottomUp(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        int left;
        int mid;
        int right;
        int start;
        int start1;
        int start2;
        for (int i = 2; i < len*2; i *= 2) { // i代表当前序列的元素个数
            for (int j = 0; j <= (len - 1)/i; j++) { // j代表第n组序列（从0开始计算）,(len - 1)的意思是对于序列内元素个数为1的序列就没有排的必要了
                // 先把每一个序列的左中右下标都求出来，以mid为界，此时每个序列的左右子序列都以排好了序
                left = i * j;
                mid = (left + ((i - 1) >> 1)) >= arr.length ? (arr.length - 1) : (left + ((i - 1) >> 1));
                right = (i*j + i - 1) >= arr.length ? (arr.length - 1) : (i*j + i - 1);
//                System.out.println("right: " + right);
                start = left;
                start1 = left;
                start2 = mid + 1;
                // 写while循环比较
                while (start1 <= mid && start2 <= right) {
                    result[start++] = arr[start1] <= arr[start2] ? arr[start1++] : arr[start2++];
                }
                while (start1 <= mid) {
                    result[start++] = arr[start1++];
                }
                while (start2 <= right) {
                    result[start++] = arr[start2++];
                }
                for (int k = left; k <= right; k++) {
                    arr[k] = result[k];
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1,3,8,7,5,99,12,9};
        int[] arr = new int[]{3,3,3,7,9,122344,4656,34,34,4656,5,6,7,8,9,343,57765,23,12321};
//        topDown(arr);
        bottomUp(arr);
        System.out.println(Arrays.toString(arr));
    }
}
