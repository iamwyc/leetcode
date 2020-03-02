package com.github.iamwyc.hw;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class Template2 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    while (s.hasNext()) {
      String line = s.nextLine();
      String[] s1 = line.split(" ");
      if (s1.length != 4) {
        System.out.println("0");
        continue;
      }
      int y = Integer.parseInt(s1[0]);
      int m = Integer.parseInt(s1[1]) - 1;
      int w = Integer.parseInt(s1[2]);
      int d = Integer.parseInt(s1[3]) + 1;

      if (y > 9999 || m > 12 || w > 9 || d > 8 || y < 1 || m < 1 || w < 1 || d < 1) {
        System.out.println("0");
        continue;
      }
      Calendar instance = Calendar.getInstance(Locale.CHINA);
      instance.clear();
      instance.set(Calendar.YEAR, y);
      instance.set(Calendar.MONTH, m);
      instance.set(Calendar.WEEK_OF_MONTH, w);
      instance.set(Calendar.DAY_OF_WEEK, d == 8 ? 1 : d);
      int mm = instance.get(Calendar.MONTH);
      if (mm != m) {
        System.out.println(0);
      } else {
        System.out.println(instance.toInstant().atZone(ZoneId.systemDefault()).format(df));
      }
    }
  }
}
