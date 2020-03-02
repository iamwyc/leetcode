package com.github.iamwyc.jzoffer;

import java.util.Stack;

/**
 * @author iamwyc
 * @date 2020/2/18
 */
public class MinStack {

  Stack<Integer> stack;

  public MinStack() {
    stack = new Stack<>();
  }

  public void push(int x) {
    stack.push(x);
  }

  public void pop() {
    stack.pop();
  }

  public int top() {
    return stack.get(stack.size() - 1);
  }

  public int min() {
    int ret = stack.get(0);
    for (Integer i : stack) {
      ret = Math.min(ret, i);
    }
    return ret;
  }
}
