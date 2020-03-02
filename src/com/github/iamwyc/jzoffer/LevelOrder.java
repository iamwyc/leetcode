package com.github.iamwyc.jzoffer;

import com.github.iamwyc.leetcode.node.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author iamwyc
 * @date 2020/2/18
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
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
 * 返回：
 *
 * [3,9,20,15,7]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LevelOrder {

  public static void main(String[] args) {
    System.out.println(new LevelOrder());
  }

  public int[] levelOrder(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    ArrayList<Integer> list = new ArrayList<>();
    q.add(root);
    TreeNode tmp;
    while (!q.isEmpty()) {
      tmp = q.remove();
      if (tmp == null) {
        break;
      }
      if (tmp.left != null) {
        q.add(tmp.left);
      }
      if (tmp.right != null) {
        q.add(tmp.right);
      }
      list.add(tmp.val);
    }

    int[] res = new int[list.size()];
    for (int i = 0; i < res.length; i++) {
      res[i] = list.get(i);
    }
    return res;
  }
}
