package com.github.iamwyc.leetcode;

/**
 * @author iamwyc
 * @date 2019/10/27
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }

    @Override
    public String toString() {
      return val + "->" + next;
    }
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    ListNode l14 = new ListNode(4);
    ListNode l13 = new ListNode(5);
    ListNode l15 = new ListNode(9);
    l1.next = l14;
    l14.next = l13;
    l13.next = l15;

    ListNode l2 = new ListNode(5);
    ListNode l26 = new ListNode(6);
    ListNode l24 = new ListNode(4);
    l2.next = l26;
    l26.next = l24;
    System.out.println(l1);
    System.out.println(l2);
    System.out.println(new AddTwoNumbers().addTwoNumbers(l1, l2));
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    if (l1 == null) {
      return l2;
    }
    ListNode tmp1 = l1;
    ListNode tmp2 = l2;
    boolean flag = false;
    ListNode result = null;
    ListNode resultPoint = null;
    while (tmp1 != null || tmp2 != null) {
      int inc = flag ? 1 : 0;
      int value1 = tmp1 != null ? tmp1.val : 0;
      int value2 = tmp2 != null ? tmp2.val : 0;
      int value = value1 + value2 + inc;
      flag = value >= 10;
      if (result != null) {
        resultPoint.next = new ListNode(value % 10);
        resultPoint = resultPoint.next;
      } else {
        result = new ListNode(value % 10);
        resultPoint = result;
      }
      tmp1 = tmp1 != null ? tmp1.next : null;
      tmp2 = tmp2 != null ? tmp2.next : null;
    }

    if (flag) {
      resultPoint.next = new ListNode(1);
    }
    return result;
  }
}
