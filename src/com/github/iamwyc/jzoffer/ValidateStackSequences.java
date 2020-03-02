package com.github.iamwyc.jzoffer;

import java.util.Stack;

/**
 * @author iamwyc
 * @date 2020/2/22
 */
public class ValidateStackSequences {

  public static void main(String[] args) {
    int[] n = {1, 2, 3, 4, 5};
    int[] m = {4, 5, 3, 2, 1};
    int[] m1 = {4, 5, 3, 1, 2};
    System.out.println(new ValidateStackSequences().validateStackSequences(n, m));
    System.out.println(new ValidateStackSequences().validateStackSequences(n, m1));
  }


  public boolean validateStackSequences(int[] pushed, int[] popped) {

    Stack<Integer> stack = new Stack<>();
    int cur = 0;
    for (int i = 0; i < pushed.length; i++) {
      stack.push(pushed[i]);
      while (!stack.isEmpty() && cur < popped.length && stack.peek() == popped[cur]) {
        stack.pop();
        cur++;
      }
    }
    return cur == popped.length && stack.isEmpty();
  }
}
