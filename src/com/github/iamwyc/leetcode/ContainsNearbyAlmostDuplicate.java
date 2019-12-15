package com.github.iamwyc.leetcode;

/**
 * @author iamwyc
 * @date 2019/12/14
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ContainsNearbyAlmostDuplicate {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 1};
    System.out
        .println(new ContainsNearbyAlmostDuplicate().containsNearbyAlmostDuplicate(nums, 3, 0));

    int[] nums2 = {1, 0, 1, 1};
    System.out
        .println(new ContainsNearbyAlmostDuplicate().containsNearbyAlmostDuplicate(nums2, 1, 2));

    int[] nums3 = {1, 5, 9, 1, 5, 9};
    System.out
        .println(new ContainsNearbyAlmostDuplicate().containsNearbyAlmostDuplicate(nums3, 2, 3));

  }

  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = 1; j <= k; j++) {
        int m = j + i;
        if (m >= nums.length) {
          break;
        }
        if (Math.abs((long) nums[m] - (long) nums[i]) <= t) {
          return true;
        }
      }
    }
    return false;
  }
}
