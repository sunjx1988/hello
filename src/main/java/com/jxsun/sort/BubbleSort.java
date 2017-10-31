package com.jxsun.sort;

/**
 * Created by Administrator on 2017/9/19.
 */
public class BubbleSort {

    public static void sort(int[] array){

        for (int i = 0; i < array.length - 1 ; i++) {
            for (int j = i; j < array.length ; j++) {
                if(array[i] > array[j]){
                    swap(array, i, j);
                }
            }
        }
    }

    private static void swap(int[] array, int a , int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
