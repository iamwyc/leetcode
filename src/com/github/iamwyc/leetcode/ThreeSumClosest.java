package com.github.iamwyc.leetcode;

/**
 * @author iamwyc
 * @date 2019/12/7
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {

  public static void main(String[] args) {
    int[] nums = {1,1,1};
    System.out.println(threeSumClosest(nums, 0));
  }

  public static int threeSumClosest(int[] nums, int target) {
    int sum = 0;
    if (nums == null || nums.length < 3) {
      return sum;
    }
    int result = nums[0] + nums[1] + nums[2];
    for (int i = 0; i < nums.length - 2; i++) {
      for (int j = i + 1; j < nums.length - 1; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          sum = nums[i] + nums[j] + nums[k];
          if (Math.abs(sum - target) < Math.abs(result - target)) {
            result = sum;
            if (result == target) {
              return result;
            }
          }
        }
      }
    }
    return result;
  }
}
