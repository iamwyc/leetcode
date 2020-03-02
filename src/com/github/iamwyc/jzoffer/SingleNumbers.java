package com.github.iamwyc.jzoffer;

/**
 * @author iamwyc
 * @date 2020/2/20
 *
 * 面试题56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 *
 * 限制：
 *
 * 2 <= nums <= 10000
 */
public class SingleNumbers {

  public static void main(String[] args) {
    System.out.println(new SingleNumbers());
  }

  public int[] singleNumbers(int[] nums) {
    int[] re = new int[2];
    int temp = 0;
    int flag = 0;
    for (int num : nums) {
      temp ^= num;
    }
    flag = temp & (-temp);
    for (int num : nums) {
      if ((num & flag) == 0) {
        re[0] ^= num;
      } else {
        re[1] ^= num;
      }
    }
    return re;
  }
}
