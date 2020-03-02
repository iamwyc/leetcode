package com.github.iamwyc.hw;

import java.util.ArrayList;

/**
 * @author iamwyc
 * @date 2020/2/9
 */
public class RepalceBlank {

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      A:
      for (int j = 0; j < 10; j++) {
        System.out.println(j);
        break A;
      }
    }
  }
}
