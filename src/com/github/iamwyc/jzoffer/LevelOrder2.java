package com.github.iamwyc.jzoffer;

import com.github.iamwyc.leetcode.node.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author iamwyc
 * @date 2020/2/18
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 *
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LevelOrder2 {

  public static void main(String[] args) {
    System.out.println(new LevelOrder2());
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> r = new ArrayList<>();
    if (root == null) {
      return r;
    }
    List<TreeNode> list = new LinkedList<>();
    List<TreeNode> tmp;
    list.add(root);
    while (!list.isEmpty()) {
      tmp = new LinkedList<>();
      List<Integer> row = new LinkedList<>();
      for (TreeNode t : list) {
        if (t.left != null) {
          tmp.add(t.left);
        }
        if (t.right != null) {
          tmp.add(t.right);
        }
        row.add(t.val);
      }
      r.add(row);
      list = tmp;
    }
    return r;
  }
}
