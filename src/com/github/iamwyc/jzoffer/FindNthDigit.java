package com.github.iamwyc.jzoffer;

/**
 * @author iamwyc
 * @date 2020/2/20
 */
public class FindNthDigit {

  public static void main(String[] args) {
//    System.out.println(new FindNthDigit().findNthDigit(1));
//    System.out.println(new FindNthDigit().findNthDigit(2));
//    System.out.println(new FindNthDigit().findNthDigit(9));
    System.out.println(new FindNthDigit().findNthDigit(11));
//    System.out.println(new FindNthDigit().findNthDigit(2147483647));
  }

  public int findNthDigit(int n) {
    if (n < 10) {
      return n;
    }
    int k = 2;
    n -= 10;
    long x = 90;
    long nn = n;
    while (nn - x * k >= 0) {
      nn -= (x * k);
      k++;
      x *= 10;
    }
    int base = (int) Math.pow(10, k - 1);
    int num = (int) (base + nn / k);
    return String.valueOf(num).charAt((int) nn % k) - '0';
  }

  public int findNthDigit2(int n) {
    long m = 0, k = 1, i = 0, t = n;
    t++;
    int mod = (int) Math.pow(10, k);
    while (i < t) {
      if (m + k >= t) {
        break;
      }
      m += k;
      i++;
      if (i % mod == 0) {
        mod = (int) Math.pow(10, ++k);
      }
    }

    return (i + "").charAt((int) (t - m - 1)) - '0';
  }
}

