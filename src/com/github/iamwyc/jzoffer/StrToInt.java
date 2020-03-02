package com.github.iamwyc.jzoffer;

/**
 * @author iamwyc
 * @date 2020/2/21
 */
public class StrToInt {

  public static void main(String[] args) {
    System.out.println(new StrToInt().strToInt("  -42"));
    System.out.println(new StrToInt().strToInt("  4193 with words"));
    System.out.println(new StrToInt().strToInt("  words and 987"));
    System.out.println(new StrToInt().strToInt("  -91283472332"));
    System.out.println(new StrToInt().strToInt("  0000000000012345678"));
    System.out.println(new StrToInt().strToInt("  010"));
  }

  public int strToInt(String str) {
    str = str.trim();
    if (str.length() == 0) {
      return 0;
    }
    char f = str.charAt(0);
    if (!Character.isDigit(f) && f != '-' && f != '+') {
      return 0;
    }
    boolean start = f > '0' && f <= '9', nag = f == '-';
    long r = Character.isDigit(f) ? f - '0' : 0;
    for (int i = 1; i < str.length(); i++) {
      f = str.charAt(i);
      if (!Character.isDigit(f)) {
        break;
      }
      if (!(!start && f == '0')) {
        start = true;
        r = r * 10 + f - '0';
      }
      if (r > 2147483648L) {
        break;
      }
    }
    r = nag ? -1 * r : r;
    if (r > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    } else if (r < Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }
    return (int) r;
  }

}
