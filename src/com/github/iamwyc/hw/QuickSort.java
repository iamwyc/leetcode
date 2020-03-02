package com.github.iamwyc.hw;

import java.util.Arrays;

public class QuickSort {


  public static void quickSort(int[] arr, int low, int high) {
    int i, j, temp, t;
    if (low > high) {
      return;
    }
    i = low;
    j = high;
    //temp就是基准位
    temp = arr[low];

    while (i < j) {
      //先看右边，依次往左递减
      while (temp <= arr[j] && i < j) {
        j--;
      }
      //再看左边，依次往右递增
      while (temp >= arr[i] && i < j) {
        i++;
      }
      //如果满足条件则交换
      if (i < j) {
        t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
      }

    }
    arr[low] = arr[i];
    arr[i] = temp;
    quickSort(arr, low, j - 1);
    quickSort(arr, j + 1, high);
    System.out.println(Arrays.toString(arr));
  }


  public static void main(String[] args) {
    int[] arr = {1, 7, 2, 4, 7, 62, 3, 4, 2, 3, 8, 9, 19};
    quickSort(arr, 0, arr.length - 1);
  }
}
