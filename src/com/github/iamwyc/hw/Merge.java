package com.github.iamwyc.hw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author iamwyc
 * @date 2020/2/6
 */
public class Merge {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    while (s.hasNext()) {
      int n = s.nextInt();
      Map<Integer, Integer> r = new HashMap<>(n);
      while (n > 0) {
        Integer key = s.nextInt();
        Integer value =  s.nextInt();
        if (r.containsKey(key)) {
          value = value + r.get(key);
        }
        r.put(key, value);
        n--;
      }
      for (Integer k : r.keySet()) {
        System.out.println(k + " " + r.get(k));
      }
    }
  }
}
