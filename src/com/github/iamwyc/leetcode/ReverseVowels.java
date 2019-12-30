package com.github.iamwyc.leetcode;

/**
 * @author iamwyc
 * @date 2019/12/18
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 *
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseVowels {

  public static void main(String[] args) {
    System.out.println(new ReverseVowels().reverseVowels("leetcode"));
  }

  public String reverseVowels(String s) {

    char[] chars = s.toCharArray();
    int j = chars.length - 1;
    int i = 0;
    StringBuilder sb = new StringBuilder();
    while (j > i) {

      while (i < j) {
        if (isvoewl(chars[i])) {
          break;
        }
        sb.append(chars[i]);
        i++;
      }
      while (j > i) {
        if (isvoewl(chars[j])) {
          break;
        }
        j--;
      }
      if (isvoewl(chars[i]) && isvoewl(chars[j])) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
        sb.append(chars[i]);
        i++;
        j--;
      }
    }
    while (i < chars.length) {
      sb.append(chars[i++]);

    }
    return sb.toString();
  }

  private boolean isvoewl(char s) {
    return s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u'
        | s == 'A' || s == 'E' || s == 'I' || s == 'O' || s == 'U';
  }
}
