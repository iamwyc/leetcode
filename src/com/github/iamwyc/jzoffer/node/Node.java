package com.github.iamwyc.jzoffer.node;

/**
 * @author iamwyc
 * @date 2020/2/22
 */
public class Node {

  public int val;
  public Node next;
  public Node random;

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }

}
