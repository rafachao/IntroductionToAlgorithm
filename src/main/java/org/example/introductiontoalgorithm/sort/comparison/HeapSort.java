package org.example.introductiontoalgorithm.sort.comparison;

import java.util.Arrays;

/**
 * 堆排序
 * 6.1节
 * 堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。堆是一个近似完全二叉树的结构，并同时
 * 满足堆的性质：即子节点的键值或索引总是小于（或者大于）它的父节点
 * 步骤：
 * 1.call the buildMaxHeap() function on the list.Also referred to as heapify(),this
 * build a heap from a list in O(n) operations.
 * 2.Swap the first element of the list with the final element.Decrease the considered range of the list
 * by one.
 * 3.Call the siftDown() function on the list to sift the new first element to its appropriate
 * index in the heap.
 * 4.Go to step(2) unless the considered range of the list is one element.
 *
 * 因为堆可以被视为一颗完全二叉树，所以树里的每个节点的子节点和父节点的下标都可以根据当前节点的序号直接求出。
 * 若以升序排序说明，把数组转换成最大堆，这是一种满足最大堆性质的二叉树：对于除了根节点之外的每个节点i，重复从最大堆中
 * 取出数值最大的节点，并让残余的堆维持最大堆性质。
 *
 *
 * 堆节点的访问。通常堆是通过一维数组来实现的。在数组起始位置为0的情形中：
 * 父节点i的左子节点在位置（2i+1）
 * 父节点i的右子节点在位置（2i+2）
 * 子节点i的父节点在位置（i-1）/2
 *
 * 堆的操作。在堆的数据结构中，堆中的最大值总是位于根节点（在优先队列中使用堆的话堆中的最小值位于根节点）。堆中
 * 定义以下几种操作：
 * 最大堆调整：将堆的末端子节点作调整，使得子节点永远小于父节点
 * 创建最大堆：将堆中的所有数据重新排序
 * 堆排序：移除位在第一个数据的根节点，并做最大堆调整的递归运算
 *
 */
public class HeapSort {

    public int[] arr;

    public HeapSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
        // 第一步，将数组堆化
        int len = arr.length;
        // beginIndex是第一个非叶子节点（从第一个非叶子节点开始即可，无需从最后一个叶子节点开始）
        // 因为子节点i的父节点在位置（i-1）/2，所以第一个非叶子节点的下标是（length/2 - 1）
        int beginIndex = (len >> 1) - 1;
        // 从第一个非叶子节点开始，一直到根节点，一个一个节点地进行堆化
        for (int i = beginIndex; i >= 0; i--) {
            maxHeapify(i, len - 1);
        }
        // 第二步，对堆化数据排序
        // 每次都是移除最顶点的根节点A[0]，与最尾部的位置调换，同时遍历长度-1
        // 然后重新整理被换到根节点的末尾元素，使其符合堆的特性
        // 直至未排序的堆长度为0
        for (int i = len - 1; i > 0; i--) {
            swap(0, i);
            maxHeapify(0, i - 1);
        }
    }

    /**
     * 调整索引为index处的数据，使其符合堆的特性
     * heapify堆化
     * @param index 需要堆化处理数据的索引
     * @param lastIndex 未排序的堆（数组）的长度
     */
    private void maxHeapify(int index, int lastIndex) {
        // 左子节点索引 乘以2再加1
        int left = (index << 1) + 1;
        // 右子节点索引
        int right = left + 1;
        int indexOfMaxValue = left; // 最大子节点默认设为left
        if (left > lastIndex) return; // 左子节点不存在，直接返回
        if (right <= lastIndex && (arr[right] > arr[indexOfMaxValue])) {
            // 如果右子节点存在，并且右子节点的值大于左子节点的值，将最大值的索引设为right
            indexOfMaxValue = right;
        }
        // 如果有子节点比当前节点大，交换并判断被换下去的父节点是否符合堆的特性
        if (arr[indexOfMaxValue] > arr[index]) {
            swap(index, indexOfMaxValue);
            maxHeapify(indexOfMaxValue, lastIndex);
        }
    }

    private void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 5, 3, 0, 8, 6, 1, 5, 8, 6, 2, 4, 9, 4, 7, 0, 1, 8, 9, 7, 3, 1, 2, 5, 9, 7, 4, 0, 2, 6};
        new HeapSort(arr).sort();
        System.out.println(Arrays.toString(arr));
    }
}
