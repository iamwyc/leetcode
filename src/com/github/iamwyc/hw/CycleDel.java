package com.github.iamwyc.hw;

import java.util.Scanner;

/**
 * @author iamwyc
 * @date 2020/2/7
 */
public class CycleDel {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    while (s.hasNext()) {
      int n = s.nextInt();
      boolean[] arr = new boolean[n];
      int del = n;
      int cur = 0;
      int p = 0;
      while (del > 1) {
        if (!arr[cur]) {
          p++;
          if (p % 3 == 0) {
            arr[cur] = true;
            del--;
            p = 0;
          }
        }
        cur++;
        if (cur == n) {
          cur = 0;
        }
      }
      for (int i = 0; i < n; i++) {
        if (!arr[i]) {
          System.out.println(i);
          break;
        }
      }
    }
  }
}
