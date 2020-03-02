package com.github.iamwyc.jzoffer;

/**
 * @author iamwyc
 * @date 2020/2/19
 */
public class MissingNumber {

  public static void main(String[] args) {
    System.out.println(new MissingNumber());
  }

  public int missingNumber(int[] nums) {
    int i = 0;
    for (; i < nums.length; i++) {
      if (nums[i] != i) {
        return i;
      }
    }
    return i;
  }
}
