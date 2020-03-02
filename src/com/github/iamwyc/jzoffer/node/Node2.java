package com.github.iamwyc.jzoffer.node;

/**
 * @author iamwyc
 * @date 2020/2/22
 */
public class Node2 {

  public int val;
  public Node left;
  public Node right;

  public Node2() {}

  public Node2(int _val) {
    val = _val;
  }

  public Node2(int _val,Node _left,Node _right) {
    val = _val;
    left = _left;
    right = _right;
  }

}
