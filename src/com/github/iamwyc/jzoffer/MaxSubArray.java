package com.github.iamwyc.jzoffer;

/**
 * @author iamwyc
 * @date 2020/2/18
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *  
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSubArray {

  public static void main(String[] args) {
    int[] x = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(new MaxSubArray().maxSubArray(x));
  }

  public int maxSubArray(int[] nums) {
    int sum = nums[0];
    int res = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (sum < 0) {
        //[i,j] 的和小于0时,表示[i,j]最多就是sum了。
        sum = nums[i];
      } else {
        //如果[i,j]的和大于0，表示sum的最大值可以继续增长
        sum += nums[i];
      }
      res = Math.max(res, sum);
    }
    return res;
  }
}
