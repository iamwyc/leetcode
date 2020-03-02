package com.github.iamwyc.jzoffer;

/**
 * @author iamwyc
 * @date 2020/2/17
 *
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 *
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsMatch {

  public static void main(String[] args) {
    System.out.println(new IsMatch().isMatch("aa", "*"));
  }

  /**
   * 状态
   * 很容易想到，dp[i][j] 表示的状态是 s 的前 i 项和 p 的前 j 项是否匹配。
   *
   * 转移方程
   * 现在如果已知了 dp[i-1][j-1] 的状态，我们该如何确定 dp[i][j] 的状态呢？我们可以分三种情况讨论，其中，前两种情况考虑了所有能匹配的情况，剩下的就是不能匹配的情况了：
   *
   * 1. s[i] == p[j] or p[j] == '.'：比如 abb 和 abb，或者 abb 和 ab. ，很容易得到 dp[i][j] = dp[i-1][j-1] =
   * True。因为
   * ab 和 ab 是匹配的，如果后面分别加一个 b，或者 s 加一个 b 而 p 加一个 . ，仍然是匹配的。
   *
   * 2. p[j] == '*'：当 p[j] 为星号时，由于星号与前面的字符相关，因此我们比较星号前面的字符 p[j-1] 和 s[i] 的关系。根据星号前面的字符与 s[i]
   * 是否相等，又可分为以下两种情况：
   *
   * p[j-1] != s[i]：如果星号前一个字符匹配不上，星号匹配了 0 次，应忽略这两个字符，看 p[j-2] 和 s[i] 是否匹配。 这时 dp[i][j] =
   * dp[i][j-2]。
   *
   * p[j-1] == s[i] or p[j-1] == '.':星号前面的字符可以与 s[i] 匹配，这种情况下，星号可能匹配了前面的字符的 0 个，也可能匹配了前面字符的多个，当匹配 0
   * 个时，如 ab 和 abb*，或者 ab 和 ab.* ，这时我们需要去掉 p 中的 b* 或 .* 后进行比较，即 dp[i][j] = dp[i][j-2]；当匹配多个时，如 abbb
   * 和 ab*，或者 abbb 和 a.*，我们需要将 s[i] 前面的与 p 重新比较，即 dp[i][j] = dp[i-1][j]
   *
   * 其他情况：以上两种情况把能匹配的都考虑全面了，所以其他情况为不匹配，即 dp[i][j] = False
   *
   * 作者：z1m
   * 链接：https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/solution/hui-su-dong-tai-gui-hua-by-ml-zimingmeng/
   * 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  public boolean isMatch(String s, String p) {
    int sLen = s.length(), pLen = p.length();
    boolean[][] memory = new boolean[sLen + 1][pLen + 1];
    memory[0][0] = true;
    for (int i = 0; i <= sLen; i++) {
      for (int j = 1; j <= pLen; j++) {
        if (p.charAt(j - 1) == '*') {
          memory[i][j] = memory[i][j - 2] || (i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) ||
              p.charAt(j - 2) == '.') && memory[i - 1][j]);
        } else {
          memory[i][j] = i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
              && memory[i - 1][j - 1];
        }
      }
    }
    return memory[sLen][pLen];
  }
}
