package com.github.iamwyc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author iamwyc
 * @date 2019/12/18
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Intersect {

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 2, 1};
    int[] nums2 = {2, 2};
    int[] result = new Intersect().intersect(nums1, nums2);
    System.out.println(Arrays.toString(result));
  }

  public int[] intersect(int[] nums1, int[] nums2) {

    Arrays.sort(nums1);
    Arrays.sort(nums2);
    //保持nums1的长度较小
    if (nums1.length > nums2.length) {
      int[] tmp = nums1;
      nums1 = nums2;
      nums2 = tmp;
    }
    int i = 0, j = 0;
    List<Integer> r = new ArrayList<>();
    for (; i < nums1.length; i++) {
      while (j < nums2.length && nums1[i] > nums2[j]) {
        j++;
      }
      if (j < nums2.length && nums1[i] == nums2[j]) {
        r.add(nums1[i]);
        j++;
      }
    }
    int[] result = new int[r.size()];
    for (int i1 = 0; i1 < r.size(); i1++) {
      result[i1] = r.get(i1);
    }
    return result;
  }
}
