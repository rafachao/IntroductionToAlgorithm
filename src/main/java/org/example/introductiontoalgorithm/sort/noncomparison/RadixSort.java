package org.example.introductiontoalgorithm.sort.noncomparison;

import java.util.Arrays;

/**
 * 基数排序
 * 8.3节
 * 基数排序是一种非比较型整数排序算法，其原理是将整数按位数切割成不同的数字，然后按每个位数分别比较。
 * 它是这样实现的：将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。
 * 然后，从最低位开始，依次进行一次排序。这样从最低位一直到最高位排序完成以后，数列就变成一个有序数列。
 * 基数排序的时间复杂度是O(k.n)，其中n是排序元素的个数，k是数字位数。
 * LSD(Least significant digit)：最低位优先法 先从最低位开始排序，再对次低位排序，直到对最高位排序后得到一个有序序列
 * MSD(Most significant digit)：最高位优先法 先从最高位开始排序，再逐个对各分组按次高位进行子排序，循环直到最低位。
 *
 *
 * 计数排序有一个很严重的问题，就是只能对整数进行排序，一旦遇到字符串，就无能为力了。
 * 为此，针对于字符串的基数排序就诞生了。
 * 基数排序在计数排序的基础上进行了改进，将排序工作拆分为多个阶段，每一个阶段只根据一个字符进行排序，一共排序K轮（K为数据长度）。
 * 将字符串拆分为多位，每位进行计数排序的算法，就是基数排序。
 */
public class RadixSort {
    // LSD
    public void radixSort(int[] arr) {
        int len = arr.length;
        // 先把最大值求出来
        int max = arr[0];
        for (int i = 1; i < len; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        // power：幂
        double d = Math.pow(10, String.valueOf(max).length());
        int[][] t = new int[10][len]; // 桶
        int[] num = new int[10]; // 记录每个桶中存入数的个数，总共有10个桶
        int k = 1;
        while (k < d) { // 从低到高循环每一位
            // 将数入桶
            for (int a : arr) {
                int m = (a/k) % 10; // m代表a的每一位的数值，m的取值范围是0-9
                t[m][num[m]] = a; // 因为数组n记录每个桶存入数的个数，所以t[m][num[m]]代表m号桶内a的位置
                num[m]++; // m号桶个数加1
            }
            // 将桶中数倒出
            // LSD每一位分配后马上合并回一个数组中
            int c = 0;
            for (int i = 0; i < 10; i++) { // 循环每一个桶
                if (num[i] != 0) { // 如果第i号桶有数，把i号桶的数依次放入数组
                    for (int j = 0; j < num[i]; j++) {
                        arr[c++] = t[i][j];
                    }
                }
                num[i] = 0;
            }


            k = k*10;
        }
    }

    // MSD
    public int[] radixSortMSD(int[] arr) {
        int max = arr[0];
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int maxL = String.valueOf(max).length(); // 获取数组中最长元素的长度
        int k = new Double(Math.pow(10, maxL - 1)).intValue();
        int[][] t = new int[10][len]; // 桶
        int[] num = new int[10]; // 记录每个桶中存入数的个数

        // 将数入桶，从最高位开始
        for (int a : arr) {
            int m = (a/k) % 10;
            t[m][num[m]] = a;
            num[m]++;
        }

        // 取出桶中的数
        // 在分配之后并不马上合并回一个数组中，而是在每个"桶"中建立"子桶"，将每个子桶中的数值按照下一
        // 数位的值分配到"子桶"中。在进行完最低位数的分配后再合并回单一的数组中。
        int c = 0;
        for (int i = 0; i < len; i++) {
            if (num[i] == 1) { // 如果桶中只有一个数则直接取出
                arr[c++] = t[i][0];
            }else if (num[i] > 1) { // 如果桶中不止一个数，递归
                int[] B = new int[num[i]]; // 初始化B的size为桶中数字的个数
                for (int j = 0; j < num[i]; j++) {
                    B[j] = t[i][j];
                }
                int[] results = radixSortMSD(B);
                for (int result : results) {
                    arr[c++] = result;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {15,25,105,78,34,21,32,41};
//        new RadixSort().radixSort(arr);
        new RadixSort().radixSortMSD(arr);
        System.out.println(Arrays.toString(arr));
    }
}
