package org.example.introductiontoalgorithm.sort.comparison;

import java.util.Arrays;

/**
 * 快速排序
 * 第7章
 * 快速排序使用分治法策略来把一个序列（list）分为较大和较小2个子序列，然后递归的排序2个子序列
 *
 */
public class QuickSort {
    /**
     * 步骤为：
     * 1.挑选基准值:从数列中挑出一个元素，称为"基准"（pivot）；
     * 2.分割：重新排序数列，所有比基准值小的元素放在基准前面，所有比基准值大的元素摆在基准后面（与基准值相等的数可以放到任何一边）。
     * 在这个分割结束之后，对基准值的排序就已经完成。
     * 3.递归排序子序列：递归地将小于基准值的子序列和大于基准值的子序列排序
     *
     * 递归最底部的判断条件是数列的大小是零或一，此时该数列显然已经有序。
     * 选取基准值有数种具体方法，此选取方法对排序的时间性能有决定性影响
     */
    public static void quickSort(int[] arr, int start, int end) {
        // 这里设定基准值为数组第一个值
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            while ((i < j) && (arr[j] > pivot)) { // 找出下一个右侧元素值小于基准值的下标
                j--;
            }
            while ((i < j) && (arr[i] < pivot)) { // 找出下一个左侧元素值大于基准值的下标
                i++;
            }
            // 如果找到的两个值都等于基准值，则不交换；否则，交换上面找到的两个元素位置
            if ((i < j) && (arr[i] == arr[j])) {
                i++;
            }else {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        // 此时i、j最后停在同一个位置，该位置的元素处在其最终的正确位置上。

        if ((i - 1) > start) { // i - 1等于start说明元素个数是2，i处在其最中的位置上，就不用再排序了
            quickSort(arr, start, i - 1);
        }
        if ((j + 1) < end) {
            quickSort(arr, j + 1, end);
        }
    }


    public static void main(String[] args) {
//        int[] arr = new int[]{5,8,7,1,3,99,12,9};
        int[] arr = new int[]{3,3,3,7,9,122344,4656,34,34,4656,5,6,7,8,9,343,57765,23,12321};
        quickSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
