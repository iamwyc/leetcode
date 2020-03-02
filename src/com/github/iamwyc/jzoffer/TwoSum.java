package com.github.iamwyc.jzoffer;

/**
 * @author iamwyc
 * @date 2020/2/19
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 */
public class TwoSum {

  public static void main(String[] args) {
    System.out.println(new TwoSum());
  }

  public int[] twoSum(int[] nums, int target) {

    int left = 0, right = nums.length - 1;

    while (left < right) {

      int cur = nums[left] + nums[right];

      if (cur == target) {
        return new int[]{nums[left], nums[right]};
      } else if (cur > target) {
        right--;
      } else {
        left++;
      }
    }

    return new int[]{};
  }
}
