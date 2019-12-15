package com.github.iamwyc.leetcode;

import com.github.iamwyc.leetcode.node.TreeNode;

/**
 * @author iamwyc
 * @date 2019/12/15
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LowestCommonAncestor {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(6);
    TreeNode l1 = new TreeNode(2);
    TreeNode r1 = new TreeNode(8);
    TreeNode l21 = new TreeNode(0);
    TreeNode l22 = new TreeNode(4);
    TreeNode r21 = new TreeNode(7);
    TreeNode r22 = new TreeNode(9);
    TreeNode l31 = new TreeNode(3);
    TreeNode l32 = new TreeNode(5);

    root.left = l1;
    root.right = r1;

    l1.left = l21;
    l1.right = l22;

    r1.left = r21;
    r1.left = r22;

    l22.left = l31;
    l22.right = l32;

    TreeNode p = l1;
    TreeNode q = r1;

    TreeNode treeNode = new LowestCommonAncestor().lowestCommonAncestor(
        root, q, p
    );
    System.out.println(treeNode.val);
  }

  /**
   *重点：
   * 二叉搜索树特性： 左子树 < root < 右子树
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root.val >= q.val && root.val <= p.val) {
      return root;
    }
    if (root.val >= p.val && root.val <= q.val) {
      return root;
    }
    if (root.val < q.val && root.val < p.val) {
      return lowestCommonAncestor(root.right, p, q);
    }
    if (root.val > q.val && root.val > p.val) {
      return lowestCommonAncestor(root.left, p, q);
    }
    return root;
  }
}
