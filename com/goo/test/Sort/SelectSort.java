package com.goo.test.Sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {1,5 ,2 ,4 ,3};
        sort(arr);
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }

    public static void sort(int[] arr){
        int len = arr.length;
        int minIndex = 0;
        for (int i = 0; i < len -1; i++) {
            minIndex = i;
            for (int j = i+1; j < len; j++) {
                if (arr[minIndex]>arr[j]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

}
