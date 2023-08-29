package com.goo.test.Sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {1,5 ,2 ,4 ,3};
        sort(arr);
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }

    public static void sort(int[] arr){
        int len = arr.length;

        for (int i = 0; i < len -1; i++) {
//            int cur = arr[i];
            int curIndex = i;
            int j = i+1;
            while (j>0){
                if (arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }else {
                    break;
                }
                j--;
                i--;
            }
            i = curIndex;


        }
    }
}
