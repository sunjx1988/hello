package com.jxsun.sort;

/**
 * Created by Administrator on 2017/9/19.
 */
public class QuickSort {

    /**
     * 数字数组排序
     */
    public static void arraySort(int[] array){
        arraySort(array , 0, array.length -1);
    }

    private static void arraySort(int[] array , int first , int last){
        if(last > first){
            int pivotIndex = arrayPartition(array, first, last);
            arraySort(array, first, pivotIndex-1);
            arraySort(array, pivotIndex, last);
        }
    }

    /**
     * 数组分区,获得主元的下标
     */
    private static int arrayPartition(int[] array , int first , int last){
        //主元
        int pivot = array[first];
        //低点下标
        int low = first + 1;
        //高点下标
        int high = last;

        while (high > low){
            //遍历如果 low元素小于等于pivot元素则 low++
            while (high > low && array[low] <= pivot){
                low ++;
            }

            //遍历如果 high元素大于pivot元素则 high--
            while (high > low && array[high] > pivot){
                high --;
            }

            //互换low元素值 和 high元素值
            swap(array,low,high);
        }

        if(array[low] < pivot){
            swap(array,low,first);
        }

        //返回low
        return low;

    }

    private static void swap(int[] array, int a , int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private static void print(int[] array){
        for(int i = 0 ; i< array.length ; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
