package com.github.iamwyc.jzoffer;

import java.util.Arrays;

/**
 * @author iamwyc
 * @date 2020/2/20
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSlidingWindow {

  public static void main(String[] args) {
    int[] s = {1, 3, -1, -3, 5, 3, 6, 7};
    MaxSlidingWindow m = new MaxSlidingWindow();
    int[] s1 = {1, 3, 1, 2, 0, 5};
    System.out.println(Arrays.toString(m.maxSlidingWindow(s1, 3)));
  }

  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length == 0) {
      return new int[0];
    }
    int len = nums.length - k + 1;
    int[] res = new int[len];

    int maxi = -1;
    for (int i = 0; i < len; i++) {
      maxi = Math.max(maxi, i);
      res[i] = nums[maxi];
      for (int j = maxi + 1; j < i + k; j++) {
        if (res[i] <= nums[j]) {
          maxi = j;
          res[i] = nums[maxi];
        }
      }
      res[i] = nums[maxi];
    }
    return res;
  }
}
