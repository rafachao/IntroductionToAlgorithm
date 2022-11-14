package org.example.introductiontoalgorithm.sort.noncomparison;

import java.util.Arrays;

/**
 * 计数排序
 * 8.2节
 * 计数排序是一种稳定的线性时间排序算法。该算法于1954年由Harold H.Seward 提出。计数排序使用一个额外的数组C，
 * 其中第i个元素是待排序数组A中值等于i的元素的个数。然后根据数组C来将A中的元素排到正确的位置。
 *
 * 当输入的元素是n个0到k之间的整数时，它的运行时间是O(n + k)。计数排序不是比较排序，因此不被O(nlogn)的下界限制。
 * 由于用来计数的数组C的长度取决于待排序数组中数据的范围（等于待排序数组的最大值与最小值之差加上1），这使得计数排序对于数据范围很大的数组，需要
 * 大量时间和内存。例如：计数排序是用来排序0到100之间的数字的最好的算法，但是它不适合按字母顺序排序人名。
 * 计数排序可以用在基数排序算法中，能够更有效地排序数据范围很大的数组。
 *
 * 计数排序的一个重要性质就是它是稳定的：具有相同值的元素在输出数组中的相对次序与它们在输入数组中的相对次序相同。也就是说，对两个相同的数来说，在输入数组
 * 中先出现的数，在输出数组中也位于前面。通常，这种稳定性只有当进行排序的时候数据还附带卫星数据时才比较重要。计数排序很重要的另一个原因是计数排序经常会被
 * 用作基数排序的一个子过程。为了使基数排序正确，计数排序必须是稳定的。
 *
 * 算法的步骤如下：
 * 1.找出待排序数组中最大和最小的元素
 * 2.统计数组中每个值为i的元素的次数，存入数组C的第i项
 * 3.对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）
 * 4.反向填充目标数组：将每个元素i放在新数组的第C[i]项，每放一个元素就将C[i]减去1
 */
public class CountingSort {

    public void countingSort(int[] arr) {
        // 找出最大值与最小值
        int maxValue = arr[0];
        int minValue = arr[0];
        for (int value : arr) {
            maxValue = Math.max(value, maxValue);
            minValue = Math.min(value, minValue);
        }
        // 统计值为i的元素的次数
        int[] C = new int[maxValue - minValue + 1];
        for (int value : arr) {
            C[value - minValue] = C[value - minValue] + 1;
        }
        // 反向填充
        int index = 0;
        int cIndex = 0;
        while (index < arr.length) {
            if (C[cIndex] != 0) {
                arr[index] = minValue + cIndex;
                index++;
                C[cIndex] = C[cIndex] - 1;
            }else {
                cIndex++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 5, 3, 0, 8, 6, 1, 5, 8, 6, 2, 4, 9, 4, 7, 0, 1, 8, 9, 7, 3, 1, 2, 5, 9, 7, 4, 0, 2, 6};
        new CountingSort().countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
