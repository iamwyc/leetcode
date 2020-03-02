package com.github.iamwyc.jzoffer;

import com.github.iamwyc.leetcode.node.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author iamwyc
 * @date 2020/2/18
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
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
 * [20,9],
 * [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LevelOrder3 {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> r = new ArrayList<>();
    if (root == null) {
      return r;
    }
    List<TreeNode> list = new LinkedList<>();
    List<TreeNode> tmp;
    list.add(root);
    int cur = 0;
    while (!list.isEmpty()) {
      tmp = new LinkedList<>();
      List<Integer> row = new LinkedList<>();
      for (TreeNode t : list) {
        if (cur % 2 == 1) {
          if (t.right != null) {
            tmp.add(0, t.right);
          }
          if (t.left != null) {
            tmp.add(0, t.left);
          }
        } else {
          if (t.left != null) {
            tmp.add(0,t.left);
          }
          if (t.right != null) {
            tmp.add(0,t.right);
          }
        }
        row.add(t.val);
      }
      r.add(row);
      list = tmp;
      cur++;
    }
    return r;
  }
}
