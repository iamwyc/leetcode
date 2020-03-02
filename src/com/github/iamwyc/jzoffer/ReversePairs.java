package com.github.iamwyc.jzoffer;

/**
 * @author iamwyc
 * @date 2020/2/19
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *  
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReversePairs {

  public static void main(String[] args) {
    System.out.println(new ReversePairs());
  }

  /**
   * 超时
   */
  public int reversePairs2(int[] nums) {
    int r = 0;

    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] > nums[j]) {
          r++;
        }
      }
    }
    return r;
  }



  private int res;

  public int reversePairs(int[] nums) {
    if (nums == null || nums.length < 1) {
      return 0;
    }
    mergeSort(nums, 0, nums.length - 1);
    return res;
  }

  private void mergeSort(int[] arr, int left, int right) {
    if (left == right) {
      return;
    }
    int mid = (left + right) >>> 1;
    mergeSort(arr, left, mid);
    mergeSort(arr, mid + 1, right);
    merge(arr, left, mid, right);
  }

  private void merge(int[] arr, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    int i = left, j = mid + 1, index = 0;
    while (i <= mid && j <= right) {
      if (arr[i] <= arr[j]) {
        temp[index++] = arr[i++];
      } else {
        temp[index++] = arr[j++];
        res += mid - i + 1;
      }
    }
    while (i <= mid) {
      temp[index++] = arr[i++];
    }
    while (j <= right) {
      temp[index++] = arr[j++];
    }
    System.arraycopy(temp, 0, arr, left, temp.length);
  }
}
