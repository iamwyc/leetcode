package com.github.iamwyc.jzoffer;

import com.github.iamwyc.jzoffer.node.Node;
import java.util.HashMap;
import java.util.Map;

/**
 * @author iamwyc
 * @date 2020/2/22
 */
public class CopyRandomList {

  public static void main(String[] args) {
    System.out.println(new CopyRandomList());
  }


  public Node copyRandomList(Node head) {
    if (head == null) {
      return null;
    }

    Node node = head;
    Map<Node, Node> m = new HashMap<>();
    while (node != null) {
      Node cp = new Node(node.val);
      m.put(node, cp);
      node = node.next;
    }
    node = head;
    while (node != null) {
      m.get(node).next = m.get(node.next);
      m.get(node).random = m.get(node.random);
      node = node.next;
    }
    return m.get(head);
  }

  public Node copyRandomList2(Node head) {
    if (head == null) {
      return head;
    }
    // 空间复杂度O(1)，将克隆结点放在原结点后面
    Node node = head;
    Node next, clone;
    // 1->2->3  ==>  1->1'->2->2'->3->3'
    while (node != null) {
      next = node.next;
      clone = new Node(node.val);
      node.next = clone;
      clone.next = next;
      node = next;
    }

    //处理random指针
    node = head;
    //clone的random 指针是node指针的random.next
    while (node != null) {
      clone = node.next;
      next = clone.next;
      clone.random = node.random == null ? null : node.random.next;
      node = next;
    }

    node = head;
    Node ret = head.next;
    //将克隆链表和原始链表分离
    while (node != null) {
      clone = node.next;
      next = clone.next;
      node.next = next;
      clone.next = next == null ? null : next.next;
      node = next;
    }
    return ret;
  }
}
