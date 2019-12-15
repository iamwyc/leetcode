package com.github.iamwyc.leetcode;

import com.github.iamwyc.leetcode.node.TreeNode;

/**
 * @author iamwyc
 * @date 2019/12/15
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]

 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LowestCommonAncestor2 {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    TreeNode l1 = new TreeNode(5);
    TreeNode r1 = new TreeNode(1);
    TreeNode l21 = new TreeNode(6);
    TreeNode l22 = new TreeNode(2);
    TreeNode r21 = new TreeNode(0);
    TreeNode r22 = new TreeNode(8);
    TreeNode l31 = new TreeNode(7);
    TreeNode l32 = new TreeNode(4);

    root.left = l1;
    root.right = r1;

    l1.left = l21;
    l1.right = l22;

    r1.left = r21;
    r1.left = r22;

    l22.left = l31;
    l22.right = l32;

    TreeNode p = l1;
    TreeNode q = l32;

    TreeNode treeNode = new LowestCommonAncestor2().lowestCommonAncestor(
        root, q, p
    );
    System.out.println(treeNode.val);
  }

  /**
   *重点：
   * 与二叉搜索树不同。没有顺序规则
   * 左右两路递归找到p、q。然后原路返回，
   *
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null || p == root || q == root) return root;
    TreeNode left = lowestCommonAncestor(root.left,p,q);
    TreeNode right = lowestCommonAncestor(root.right,p,q);
    if(left == null) return right;
    if(right == null) return left;
    return root;
  }
}
