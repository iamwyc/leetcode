package com.github.iamwyc.jzoffer;

/**
 * @author iamwyc
 * @date 2020/2/22
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：5
 * 示例 2：
 *
 * 输入：n = 13
 * 输出：6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountDigitOne {

  public static void main(String[] args) {
    System.out.println(new CountDigitOne());
  }

  public int countDigitOne(int n) {

    if (n < 1) {
      return 0;
    }
    int len = getLenOfNum(n);
    if (len == 1) {
      return 1;
    }
    int tmp = (int) Math.pow(10, len - 1);
    // 获取n的最高位数字
    int first = n / tmp;
    // 获取n的最高位为1时有多少个数字
    int firstOneNum = first == 1 ? n % tmp + 1 : tmp;
    // 在介于n % tmp到n之间的数字中，除了最高位为1，其余各个数字分别为1 的总数和
    int otherOneNUm = first * (len - 1) * (tmp / 10);
    return firstOneNum + otherOneNUm + countDigitOne(n % tmp);
  }

  private int getLenOfNum(int n) {
    int len = 0;
    while (n != 0) {
      len++;
      n /= 10;
    }
    return len;
  }

}