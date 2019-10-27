package com.github.iamwyc.leetcode;

import java.util.Arrays;

/**
 * @author iamwyc
 * @date 2019/10/27
 * @desciption 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {

  public static void main(String[] args) {
    int[] nums = {3, 2, 4};
    int target = 6;
    System.out.println(Arrays.toString(new TwoSum().twoSum(nums, target)));
  }

  public int[] twoSum(int[] nums, int target) {
    if (nums == null || nums.length < 2) {
      return new int[]{};
    }
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    return new int[]{};
  }
}
