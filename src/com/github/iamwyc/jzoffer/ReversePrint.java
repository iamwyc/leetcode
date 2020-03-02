package com.github.iamwyc.jzoffer;

import com.github.iamwyc.leetcode.node.ListNode;
import java.util.LinkedList;
import java.util.List;

/**
 * @author iamwyc
 * @date 2020/2/17
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReversePrint {

  public static void main(String[] args) {
  }

  /**
   *不需要额外空间，速度快
   */
  public int[] reversePrint2(ListNode head) {
    ListNode node = head;
    int len = 0;
    while (node != null) {
      node = node.next;
      len++;
    }
    int[] result = new int[len];
    int cur = len - 1;
    node = head;
    while (node != null) {
      result[cur] = node.val;
      node = node.next;
    }
    return result;
  }

  public int[] reversePrint(ListNode head) {
    List<Integer> l = new LinkedList<>();

    while (head != null) {
      l.add(head.val);
      head = head.next;
    }
    int len = l.size();
    int[] result = new int[len];
    len--;
    for (int i = 0; i < l.size(); i++) {

      result[len - i] = l.get(i);
    }
    return result;
  }
}
