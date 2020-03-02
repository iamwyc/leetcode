package com.github.iamwyc.cxymsbd;

import com.github.iamwyc.leetcode.node.ListNode;

/**
 * @author iamwyc
 * @date 2020/3/2
 *
 * 面试题 02.02. 返回倒数第 k 个节点
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例：
 *
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 *
 * 给定的 k 保证是有效的。
 */
public class KthToLast {

  public static void main(String[] args) {
    System.out.println(new KthToLast());
  }

  public int kthToLast(ListNode head, int k) {
    ListNode pre = head;
    ListNode target = head;
    while (pre != null) {
      k--;
      if (k < 0) {
        target = target.next;
      }
      pre = pre.next;
    }
    return target.val;
  }
}
