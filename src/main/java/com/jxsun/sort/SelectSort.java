package com.jxsun.sort;

/**
 * 把剩余数组中最小的放新数组最前面
 */
public class SelectSort {

    public static int[] selectSort(int[] array){
        int point = 0;

        for (; point < array.length ; point++) {
            for (int i = point + 1; i < array.length; i++) {
                if(array[i] < array[point]){
                    swap(array, i , point);
                }
            }
        }

        return array;
    }

    private static void swap(int[] array, int a , int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
