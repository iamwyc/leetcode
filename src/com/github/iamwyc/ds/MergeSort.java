package com.github.iamwyc.ds;

import java.util.Arrays;

/**
 * @author iamwyc
 * @date 2020/3/1
 */
public class MergeSort {

  public static void main(String[] args) {

    int[] nums = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 10};
    new MergeSort().mergeSort(nums, 0, nums.length - 1);
    System.out.println(Arrays.toString(nums));
  }

  private int res;

  public void mergeSort(int[] arr, int left, int right) {

    if (left == right) {
      return;
    }
    int mid = (left + right) >>> 1;
    mergeSort(arr, left, mid);
    mergeSort(arr, mid + 1, right);
    merge(arr, left, mid, right);
  }


  public void merge(int[] arr, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    int i = left, j = mid + 1, index = 0;
    while (i <= mid && j <= right) {
      if (arr[i] <= arr[j]) {
        temp[index++] = arr[i++];
      } else {
        temp[index++] = arr[j++];
        res += mid - i + 1;
      }
    }
    while (i <= mid) {
      temp[index++] = arr[i++];
    }
    while (j <= right) {
      temp[index++] = arr[j++];
    }
    System.arraycopy(temp, 0, arr, left, temp.length);
  }
}
