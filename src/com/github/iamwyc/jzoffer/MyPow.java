package com.github.iamwyc.jzoffer;

/**
 * @author iamwyc
 * @date 2020/2/17
 */
public class MyPow {

  public static void main(String[] args) {
    System.out.println(new MyPow().myPow(2, 10));
    System.out.println(new MyPow().myPow(2.1, 3));
    System.out.println(new MyPow().myPow(2, -2));
  }

  public double myPow(double x, int n) {
    if(n == 0) return 1;
    if(n == 1) return x;
    if(n == -1) return 1 / x;
    double half = myPow(x, n / 2);
    double mod = myPow(x, n % 2);
    return half * half * mod;
  }
}
