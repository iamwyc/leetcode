package com.github.iamwyc.jzoffer;

import java.util.Arrays;

/**
 * @author iamwyc
 * @date 2020/2/18
 */
public class GetLeastNumbers {

  public static void main(String[] args) {
    System.out.println(new GetLeastNumbers());
  }

  public int[] getLeastNumbers(int[] arr, int k) {
    int[] res = new int[k];
    Arrays.sort(arr);
    for (int i = 0; i < k; i++) {
      res[i] = arr[i];
    }
    return res;
  }
}
