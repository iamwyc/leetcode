package com.github.iamwyc.jzoffer;

/**
 * @author iamwyc
 * @date 2020/2/21
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 *  
 *
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 *  
 *
 * 提示：
 *
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Add {

  public static void main(String[] args) {
    System.out.println(new Add());
  }


  /**
   * 参考：使用位运算实现加减乘除：https://blog.csdn.net/YPJMFC/article/details/78246971
   * 使用位运算计算a+b过程
   * 1.不算进位 a^b
   * 2. 计算进位 (a & b) << 1
   * 即 a+b = a^b + (a&b)<< 1
   * 例如 3 + 17
   * a = 0 0011
   * b = 1 0001
   * 1. a^b = 1 0010
   * 2. (a&b)<< 1 = 0 0001 << 1 = 0 0010
   * 3. a^b + (a&b)<< 1 =1 0100  => 20
   *
   * 根据题目不允许有加法，循环第1,2步,使得进位(a&b)<< 1 == 0 时,a^b为结果
   */
  public int add(int a, int b) {
    while (b != 0) {
      // 求和（不计进位）. 相同位置0，相反位置1
      int plus = (a ^ b);
      // 计算进位. 先保留同为1的位，都为1的位要向左进位，因此左移1位
      b = ((a & b) << 1);
      a = plus;
    }
    return a;
  }

}
