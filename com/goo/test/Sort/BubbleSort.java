package com.goo.test.Sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1,5 ,2 ,4 ,3};
        sort(arr);
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }

    public static void sort(int[] arr){
        int len = arr.length;
        for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < len-i-1; j++) {
                if (arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
