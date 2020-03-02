package com.github.iamwyc.jzoffer;

import com.github.iamwyc.leetcode.node.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author iamwyc
 * @date 2020/2/18
 */
public class PathSum {

  public static void main(String[] args) {
    System.out.println(new PathSum());
  }

  List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<Integer> path = new LinkedList<>();
    pathSum0(root, path, 0, sum);
    return res;
  }

  private void pathSum0(TreeNode root, List<Integer> path, int now, int sum) {
    if (root == null) {
      return;
    }
    now = now + root.val;
    path.add(root.val);
    if (root.left == null && root.right == null) {
      if (now == sum) {
        List<Integer> r = new ArrayList<>(path);
        res.add(r);
      }
      path.remove(path.size() - 1);
      return;
    }
    pathSum0(root.left, path, now, sum);
    pathSum0(root.right, path, now, sum);
    path.remove(path.size() - 1);
  }
}
