package com.github.iamwyc.jzoffer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author iamwyc
 * @date 2020/2/22
 */
public class TreeToDoublyList {

  public static class Node {

    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
      val = _val;
      left = _left;
      right = _right;
    }

  }

  public static void main(String[] args) {
    System.out.println(new TreeToDoublyList());
  }

  private Node pre;

  private Node head;

  private Node tail;

  public Node treeToDoublyList2(Node root) {
    if (root == null) {
      return null;
    }
    infixOrder(root);
    head.left = tail;
    tail.right = head;
    return head;
  }

  private void infixOrder(Node node) {
    if (node == null) {
      return;
    }
    infixOrder(node.left);
    if (pre == null) {
      head = node;
    } else {
      pre.right = node;
    }
    node.left = pre;
    pre = node;
    tail = node;
    infixOrder(node.right);
  }

  public Node treeToDoublyList(Node root) {

    List<Node> list = new LinkedList<>();
    inOrder(root, list);
    int len = list.size();
    for (int i = 0; i < len; i++) {
      Node cur = list.get(i);
      int left = (i - 1) >= 0 ? i - 1 : len - 1;
      int right = (i + 1) < len ? i + 1 : 0;
      cur.left = list.get(left);
      cur.right = list.get(right);
    }
    return list.isEmpty() ? null : list.get(0);
  }

  private void inOrder(Node root, List<Node> list) {
    if (root == null) {
      return;
    }
    inOrder(root.left, list);
    list.add(root);
    inOrder(root.right, list);

  }
}
