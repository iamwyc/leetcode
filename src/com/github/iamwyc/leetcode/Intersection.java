package com.github.iamwyc.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author iamwyc
 * @date 2019/12/18
 */
public class Intersection {

  public static void main(String[] args) {
    int[] nums1 = {4, 9, 5};
    int[] N2 = {9, 4, 9, 8, 4};
    int[] result = new Intersection().intersection(nums1, N2);
    System.out.println(Arrays.toString(result));
  }

  public int[] intersection(int[] nums1, int[] nums2) {

    int[] tmp1 = nums1;
    int[] tmp2 = nums2;
    //保持tmp1长度是长的
    if (nums1.length < nums2.length) {
      tmp1 = nums2;
      tmp2 = nums1;
    }

    int tmp2Len = tmp2.length;
    Set<Integer> shortSet = new HashSet<>(tmp1.length);
    Set<Integer> longSet = new HashSet<>(tmp2Len);

    for (int i = 0; i < tmp1.length; i++) {
      if (i < tmp2Len) {
        shortSet.add(tmp2[i]);
      }
      longSet.add(tmp1[i]);
    }

    shortSet.removeIf(i-> !longSet.contains(i));
    int[] result = new int[shortSet.size()];
    int k = 0;
    for (Integer integer : shortSet) {
      result[k++] = integer;
    }
    return result;
  }
}
