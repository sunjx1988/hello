package com.jxsun.sort;

/**
 * Created by Administrator on 2017/9/19.
 */
public class QuickSortRun {
    public static void main(String[] args) {
        int[] array = new int[1000000];

        for(int i = 0 ; i< array.length ; i++){
            array[i] = (int) (Math.random() * 100);
        }

//        print(array);

        QuickSort.arraySort(array);

//        print(array);
    }

    private static void print(int[] array){
        for(int i = 0 ; i< array.length ; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
