package com.github.iamwyc.jzoffer;

/**
 * @author iamwyc
 * @date 2020/2/21
 *
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *  
 *
 * 提示：
 *
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConstructArr {

  public static void main(String[] args) {
    System.out.println(new ConstructArr());
  }

  /**
   * 理解题意
   * result[i] 是除了a[i]之外，a数组其他所有数字的乘积
   * result[i]=a[0]*a[1]..*a[i-1]*a[i+1]...*a[n-1]
   */
  public int[] constructArr(int[] a) {
    if (a == null || a.length < 2) {
      return new int[0];
    }
    int[] b = new int[a.length];
    b[0] = 1;
    //第一次循环 result[i]=a[0]*a[1]..*a[i-1]
    for (int i = 1; i < a.length; i++) {
      b[i] = b[i - 1] * a[i - 1];
    }
    int temp = 1;
    //第一次循环 result[i]=result[i]*a[i-1]...*a[n-1]
    for (int i = a.length - 2; i >= 0; i--) {
      temp *= a[i + 1];
      b[i] *= temp;
    }
    return b;
  }
}
