package com.github.iamwyc.jzoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author iamwyc
 * @date 2020/2/22
 */
public class MedianFinder {

  public static void main(String[] args) {

    MedianFinder m = new MedianFinder();
    m.addNum(6);
    System.out.println(m.findMedian());
    m.addNum(10);
    System.out.println(m.findMedian());
    m.addNum(2);
    System.out.println(m.findMedian());
    m.addNum(6);
    System.out.println(m.findMedian());
    m.addNum(5);
    System.out.println(m.findMedian());
  }

  List<Integer> arr;

  public MedianFinder() {

    arr = new LinkedList<>();
  }

  public void addNum(int num) {
    int i = 0;
    for (; i < arr.size(); i++) {
      if (arr.get(i) > num) {
        break;
      }
    }
    arr.add(i, num);
  }

  public double findMedian() {
    System.out.println(arr);
    int size = arr.size();
    if (size % 2 == 0) {
      return (arr.get(size / 2) + arr.get(size / 2 - 1)) / 2.0;
    } else {
      return arr.get(size / 2);
    }
  }
}
