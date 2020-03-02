package com.github.iamwyc.jzoffer;

import com.github.iamwyc.leetcode.node.TreeNode;

/**
 * @author iamwyc
 * @date 2020/2/28
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 *
 * 0 <= 节点个数 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsSubStructure {

  public static void main(String[] args) {

    TreeNode root = new TreeNode(3);
    TreeNode r1 = new TreeNode(4);
    TreeNode r2 = new TreeNode(5);
    TreeNode r3 = new TreeNode(1);
    TreeNode r4 = new TreeNode(2);

    root.left = r1;
    root.right = r2;

    r1.right = r3;
    r1.left = r4;

    System.out.println(new IsSubStructure().isSubStructure(root, r4));
  }


  public boolean isSubStructure(TreeNode A, TreeNode B) {
    if (B == null || A == null) {
      return false;
    }
    if (A.val == B.val) {
      return same(A, B);
    }
    return isSubStructure(A.right, B) || isSubStructure(A.left, B);
  }


  private boolean same(TreeNode A, TreeNode B) {
    if (B == null) {
      return true;
    }
    if (A == null || A.val != B.val) {
      return false;
    }
    return same(A.left, B.left) && same(A.right, B.right);
  }
}
