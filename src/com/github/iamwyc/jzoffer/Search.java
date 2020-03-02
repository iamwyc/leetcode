package com.github.iamwyc.jzoffer;

import java.util.Arrays;

/**
 * @author iamwyc
 * @date 2020/2/19
 * 统计一个数字在排序数组中出现的次数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Search {

  public static void main(String[] args) {
    int[] n = {5, 7, 7, 8, 8, 10};
    System.out.println(new Search().search(n, 6));
  }

  public int search(int[] nums, int target) {
    int index = Arrays.binarySearch(nums, target);
    if (index < 0) {
      return 0;
    }
    System.out.println(index);
    int count = 1;
    for (int i = index + 1; i < nums.length; i++) {
      if (nums[i] == target) {
        count++;
      } else {
        break;
      }
    }
    for (int i = index - 1; i >= 0; i--) {
      if (nums[i] == target) {
        count++;
      } else {
        break;
      }
    }
    return count;
  }
}
