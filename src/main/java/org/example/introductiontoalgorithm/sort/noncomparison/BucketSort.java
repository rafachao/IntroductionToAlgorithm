package org.example.introductiontoalgorithm.sort.noncomparison;

import org.example.introductiontoalgorithm.sort.comparison.ShellSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 桶排序
 * 8.4节
 * 工作原理是将数组分到有限数量的桶里。每个桶再个别排序（有可能再使用别的排序算法或是以递归方式使用桶排序进行排序）
 * 步骤：
 * 1.设置一个定量的数组当作空桶子
 * 2.寻访序列，并且把项目一个一个放到对应的桶子里
 * 3.对每个不是空的桶子进行排序
 * 4.从不是空的桶子里把项目再放回原来的序列中
 */
public class BucketSort {
    public void bucketSort(int[] arr) {
        int max = arr[0], min = arr[0];
        for (int a : arr) {
            if (max < a) {
                max = a;
            }
            if (min > a) {
                min = a;
            }
        }
        // 根据实际情况确定桶的数量
        int bucketSize = 10;
        int bucketNum = max/bucketSize - min/bucketSize + 1;
        List<List<Integer>> bucketList = new ArrayList<>();
        // 创建bucket
        for (int i = 1; i <= bucketNum; i++) {
            bucketList.add(new ArrayList<>());
        }
        // 将数放入桶中
        for (int i = 0; i < arr.length; i++) {
            int index = indexFor(arr[i], min, bucketSize);
            bucketList.get(index).add(arr[i]);
        }
        // 对每个桶进行插入排序
        int index = 0;
        for (List<Integer> integers : bucketList) {
            insertSort(integers);
            for (Integer integer : integers) {
                arr[index++] = integer;
            }
        }

    }

    // 插入排序
    private void insertSort(List<Integer> arr)  {
        int length = arr.size();
        int tmp;
        for (int i = 1; i < length; i++) {
            // 与已排好的序列从后往前比较
            for (int j = i; j > 0; j--) {
                if (arr.get(j) < arr.get(j - 1)) {
                    tmp = arr.get(j);
                    arr.set(j,arr.get(j - 1));
                    arr.set(j - 1, tmp);
                }
            }
        }
    }

    private int indexFor(int a, int min, int bucketSize) {
        return (a - min)/bucketSize;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,8,7,5,99,12,9};
        new BucketSort().bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
