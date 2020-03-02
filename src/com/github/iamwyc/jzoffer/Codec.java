package com.github.iamwyc.jzoffer;

import com.github.iamwyc.leetcode.node.TreeNode;
import java.util.LinkedList;
import java.util.List;

/**
 * @author iamwyc
 * @date 2020/2/19
 *
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 示例: 
 *
 * 你可以将以下二叉树：
 *
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Codec {

  public static void main(String[] args) {

    TreeNode root = new TreeNode(1);

    TreeNode n1 = new TreeNode(2);
    TreeNode n2 = new TreeNode(3);
    TreeNode n3 = new TreeNode(4);
    TreeNode n4 = new TreeNode(5);
    root.left = n1;
    root.right = n2;
    n2.left = n3;
    n2.right = n4;
    Codec codec = new Codec();
    System.out.println(codec.serialize(root));
    System.out.println(codec.deserialize("[]"));
  }

  public String serialize(TreeNode root) {
    if (root == null) {
      return "[]";
    }
    StringBuilder sb = new StringBuilder();
    List<TreeNode> list = new LinkedList<>();
    List<TreeNode> tmp;
    list.add(root);
    sb.append("[");
    while (list != null && !list.isEmpty()) {
      tmp = new LinkedList<>();
      int nullCount = 0;
      for (TreeNode t : list) {
        if (t != null) {
          tmp.add(t.left);
          tmp.add(t.right);
          if (t.left == null) {
            nullCount++;
          }
          if (t.right == null) {
            nullCount++;
          }
          sb.append(t.val);
        } else {
          sb.append("null");
        }
        sb.append(",");
      }
      list = tmp;
      if (nullCount == tmp.size()) {
        list = null;
      }
    }

    sb.deleteCharAt(sb.length() - 1);
    sb.append("]");
    return sb.toString();
  }

  public TreeNode deserialize(String data) {
    String d2 = data.substring(1, data.length() - 1);
    if (d2.length() == 0) {
      return null;
    }
    String[] arr = d2.split(",");
    TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

    List<TreeNode> list = new LinkedList<>();
    list.add(root);
    int index = 1;
    while (index < arr.length) {
      List<TreeNode> tmp;
      tmp = new LinkedList<>();

      for (TreeNode node : list) {
        if (!"null".equals(arr[index])) {
          node.left = new TreeNode(Integer.parseInt(arr[index]));
          tmp.add(node.left);
        }
        index++;
        if (!"null".equals(arr[index])) {
          node.right = new TreeNode(Integer.parseInt(arr[index]));
          tmp.add(node.right);
        }
        index++;
      }
      list = tmp;
    }
    return root;
  }
}
