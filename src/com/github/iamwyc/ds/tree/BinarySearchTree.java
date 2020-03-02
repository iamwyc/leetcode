package com.github.iamwyc.ds.tree;

import com.github.iamwyc.ds.utils.PrintUtils;

/**
 * @author iamwyc
 * @date 2019/12/30
 * 二叉查找树（二叉搜索树、二叉排序树，BinarySearchTree）定义：
 * 1. 若它的左子树不为空，则左子树上的所有节点的值都小于它的根节点的值；
 * 2. 若它的右子树不为空，则右子树上所有节点的值都大于它的根节点的值；
 * 3. 其他的左右子树也分别为二叉查找树；
 * 4. 没有键值相等的节点
 *
 * 综上：左子 < 父 < 右子  且只有2个子节点即为二叉查找树
 */
public class BinarySearchTree {


  public static void main(String[] args) {
    TreeNode root = new TreeNode(10);
    insert(root, 6);
    insert(root, 15);
    insert(root, 17);
    insert(root, 13);
    insert(root, 11);
    insert(root, 14);
    insert(root, 15);
    insert(root, 16);
    insert(root, 18);
    insert(root, 8);
    System.out.println(PrintUtils.show(root));
    System.out.println(delete(root, 14));
    System.out.println(PrintUtils.show(root));
  }

  public static TreeNode delete(TreeNode root, int x) {
    if (root == null) {
      return null;
    }
    TreeNode p = root;
    TreeNode n = null;
    if (root.val > x) {
      n = root.left;
    } else if (root.val < x) {
      n = root.right;
    } else {
      return null;
    }
    while (n != null) {
      if (n.val == x) {
        break;
      } else if (n.val > x) {
        p = n;
        n = n.left;
      } else {
        p = n;
        n = n.right;
      }
    }
    TreeNode ret=new TreeNode(x);
    ret.right=n.right;
    ret.left=n.left;
    if (n.left != null && n.right != null) {

      TreeNode t = n.right;
      TreeNode t1 = n;
      while (t.left != null) {
        t1 = t;
        t = t.left;
      }
      t1.left = null;
      n.val=t.val;
    } else {

    }
    return ret;
  }

  public static void insert(TreeNode root, int x) {
    insert0(root, x);
  }

  private static TreeNode insert0(TreeNode root, int x) {
    if (root == null) {
      return new TreeNode(x);
    }
    if (root.val == x) {
      return root;
    } else if (root.val < x) {
      root.right = insert0(root.right, x);
    } else {
      root.left = insert0(root.left, x);
    }
    return root;
  }

}
