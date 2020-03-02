package com.github.iamwyc.hw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author iamwyc
 * @date 2020/2/8
 * 扑克牌游戏大家应该都比较熟悉了，一副牌由54张组成，含3~A，2各4张，小王1张，大王1张。牌面从小到大用如下字符和字符串表示（其中，小写joker表示小王，大写JOKER表示大王）:)
 * 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
 * 输入两手牌，两手牌之间用“-”连接，每手牌的每张牌以空格分隔，“-”两边没有空格，如：4 4 4 4-joker JOKER
 * 请比较两手牌大小，输出较大的牌，如果不存在比较关系则输出ERROR
 *
 * 基本规则：
 * （1）输入每手牌可能是个子，对子，顺子（连续5张），三个，炸弹（四个）和对王中的一种，不存在其他情况，由输入保证两手牌都是合法的，顺子已经从小到大排列；
 * （2）除了炸弹和对王可以和所有牌比较之外，其他类型的牌只能跟相同类型的存在比较关系（如，对子跟对子比较，三个跟三个比较），不考虑拆牌情况（如：将对子拆分成个子）
 * （3）大小规则跟大家平时了解的常见规则相同，个子，对子，三个比较牌面大小；顺子比较最小牌大小；炸弹大于前面所有的牌，炸弹之间比较牌面大小；对王是最大的牌；
 * （4）输入的两手牌不会出现相等的情况。
 *
 * 答案提示：
 * （1）除了炸弹和对王之外，其他必须同类型比较。
 * （2）输入已经保证合法性，不用检查输入是否是合法的牌。
 * （3）输入的顺子已经经过从小到大排序，因此不用再排序了.
 */
public class PokerCompare {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Map<String, Integer> map = new HashMap<>(16);
    map.put("3", 0);
    map.put("4", 1);
    map.put("5", 2);
    map.put("6", 3);
    map.put("7", 4);
    map.put("8", 5);
    map.put("9", 6);
    map.put("10", 7);
    map.put("J", 8);
    map.put("Q", 9);
    map.put("K", 10);
    map.put("A", 11);
    map.put("2", 12);
    map.put("joker", 13);
    map.put("JOKER", 14);

    while (s.hasNext()) {
      String[] line = s.nextLine().split("-");
      String[] a = line[0].split(" ");
      String[] b = line[1].split(" ");
      int ta = pokerType(a);
      int tb = pokerType(b);
      String result = "ERROR";
      if (ta == 6) {
        result = line[0];
      } else if (tb == 6) {
        result = line[1];
      } else if (ta == 4) {
        result = line[0];
        if (tb == 4) {
          if (map.get(b[0]).compareTo(map.get(a[0])) > 0) {
            result = line[1];
          }
        }
      } else if (tb == 4) {
        result = line[1];
        if (ta == 4) {
          if (map.get(a[0]).compareTo(map.get(b[0])) > 0) {
            result = line[0];
          }
        }
      } else if (ta != tb) {
        result = "ERROR";
      } else {
        if (map.get(a[0]).compareTo(map.get(b[0])) > 0) {
          result = line[0];
        } else {
          result = line[1];
        }
      }
      System.out.println(result);
    }

  }

  public static int pokerType(String[] poke) {
    int ret = poke.length;
    if (ret == 2) {
      if ("JOKER".equals(poke[0]) || "joker".equals(poke[0])) {
        ret = 6;
      }
    }
    return ret;
  }
}
