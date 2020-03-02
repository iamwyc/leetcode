package com.github.iamwyc.jzoffer;

/**
 * @author iamwyc
 * @date 2020/2/18
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Exchange {

  public static void main(String[] args) {
    System.out.println(new Exchange());
  }

  public int[] exchange(int[] nums) {
    int[] ret = new int[nums.length];
    int r = 0, l = nums.length - 1;
    for (int num : nums) {
      if (num % 2 == 0) {
        ret[l--] = num;
      } else {
        ret[r++] = num;
      }
    }
    return ret;
  }
}
