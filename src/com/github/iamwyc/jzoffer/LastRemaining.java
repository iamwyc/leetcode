package com.github.iamwyc.jzoffer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author iamwyc
 * @date 2020/2/19
 */
public class LastRemaining {

  public static void main(String[] args) {
    System.out.println(new LastRemaining().lastRemaining(10, 17));
  }

  public int lastRemaining(int n, int m) {
    List<Integer> arr = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      arr.add(i);
    }
    int c = (m - 1) % n;
    while (arr.size() != 1) {
      arr.remove(c);
      c = (c + m - 1) % arr.size();
    }
    return arr.get(0);
  }
}
