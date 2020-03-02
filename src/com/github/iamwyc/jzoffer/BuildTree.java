package com.github.iamwyc.jzoffer;

import com.github.iamwyc.leetcode.node.TreeNode;

/**
 * @author iamwyc
 * @date 2020/2/17
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *  
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *  
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildTree {

  public static void main(String[] args) {
    System.out.println(new BuildTree());
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
  }

  private TreeNode build(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft,
      int inRight) {
    if (preLeft > preorder.length - 1 || inLeft > inRight) {
      return null;
    }
    int inPos = 0;
    TreeNode root = new TreeNode(preorder[preLeft]);
    for (int i = inLeft; i <= inRight; i++) {
      if (preorder[preLeft] == inorder[i]) {
        inPos = i;
        break;
      }
    }
    int leftSize = inPos - inLeft;
    root.left = build(preorder, preLeft + 1, preLeft + leftSize, inorder, inLeft, inPos - 1);
    root.right = build(preorder, preLeft + leftSize + 1, preRight, inorder, inPos + 1, inRight);
    return root;
  }


}
