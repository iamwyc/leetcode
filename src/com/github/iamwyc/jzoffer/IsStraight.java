package com.github.iamwyc.jzoffer;

import java.util.Arrays;

/**
 * @author iamwyc
 * @date 2020/2/28
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *  
 *
 * 示例 2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsStraight {

  public static void main(String[] args) {
    System.out.println(new IsStraight().isStraight(new int[]{1, 2, 3, 4, 5}));
    System.out.println(new IsStraight().isStraight(new int[]{0, 0, 1, 2, 5}));
    System.out.println(new IsStraight().isStraight(new int[]{1, 2, 3, 4, 6}));
    System.out.println(new IsStraight().isStraight(new int[]{0, 0, 2, 2, 5}));
    System.out.println(new IsStraight().isStraight(new int[]{10, 11, 0, 12, 6}));
    System.out.println(new IsStraight().isStraight(new int[]{1, 2, 12, 0, 3}));
  }

  public boolean isStraight(int[] nums) {
    Arrays.sort(nums);
    int king = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == 0) {
        king++;
      } else {
        if (nums[i] == nums[i + 1]) {
          return false;
        } else {
          king = king - (nums[i + 1] - nums[i] - 1);
        }
      }
    }
    return king >= 0;
  }
}