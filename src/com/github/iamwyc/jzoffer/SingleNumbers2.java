package com.github.iamwyc.jzoffer;

import java.util.Arrays;

/**
 * @author iamwyc
 * @date 2020/2/20
 * 面试题56 - II. 数组中数字出现的次数 II
 *
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SingleNumbers2 {

  public static void main(String[] args) {
    System.out.println(new SingleNumbers2());
  }

  public int singleNumber(int[] nums) {
    Arrays.sort(nums);
    int i = 0;
    while (i < nums.length - 2) {
      if (nums[i] == nums[i + 1] && nums[i] == nums[i + 2]) {
        i += 2;
      } else {
        return nums[i];
      }
      i++;
    }
    return nums[nums.length - 1];
  }
}
