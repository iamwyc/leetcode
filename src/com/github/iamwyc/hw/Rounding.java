package com.github.iamwyc.hw;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * @author iamwyc
 * @date 2020/2/6
 */
public class Rounding {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    while (s.hasNext()) {
      double n = s.nextDouble() + 0.5d;
      /*
      * 简单方式
      System.out.println(
          BigDecimal.valueOf(n).setScale(0, RoundingMode.HALF_UP).intValue());
      * */
      System.out.println((long) n);
    }
  }
}
