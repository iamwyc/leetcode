package com.github.iamwyc.jzoffer;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author iamwyc
 * @date 2020/2/17
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回
 * -1 )
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 *
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CQueue {

  Stack<Integer> in = null;
  Stack<Integer> out = null;


  public CQueue() {
    in = new Stack<>();
    out = new Stack<>();

  }

  public void appendTail(int value) {
    while(!out.isEmpty()){
      in.push(out.pop());
    }
    in.push(value);
  }

  public int deleteHead() {
    while(!in.isEmpty()){
      out.push(in.pop());
    }
    if(out.isEmpty()){
      return -1;
    }
    return out.pop();
  }
}
