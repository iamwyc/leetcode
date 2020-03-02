package com.github.iamwyc.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * @author iamwyc
 * @date 2020/2/8
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 * 处理:
 * 1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，错误计数增加；(文件所在的目录不同，文件名和行号相同也要合并)
 * 2.超过16个字符的文件名称，只记录文件的最后有效16个字符；(如果文件名不同，而只是文件名的后16个字符和行号相同，也不要合并)
 * 3.输入的文件可能带路径，记录文件名称不能带路径
 *
 * 输入描述:
 * 一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
 *
 * 文件路径为windows格式
 *
 * 如：E:\V1R2\product\fpgadrive.c 1325
 *
 * 输出描述:
 * 将所有的记录统计并将结果输出，格式：文件名代码行数数目，一个空格隔开，如: fpgadrive.c 1325 1
 *
 * 结果根据数目从多到少排序，数目相同的情况下，按照输入第一次出现顺序排序。
 *
 * 如果超过8条记录，则只输出前8条记录.
 *
 * 如果文件名的长度超过16个字符，则只输出后16个字符
 *
 * 输入例子1:
 * E:\V1R2\product\fpgadrive.c 1325
 *
 * 输出例子1:
 * fpgadrive.c 1325 1
 */
public class MapValueSort {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Map<String, Integer> map = new HashMap<>();
    final Map<String, Integer> smap = new HashMap<>();
    int cur=0;
    while (s.hasNext()) {
      String[] line = s.nextLine().split(" ");
      String name = line[0].substring(line[0].lastIndexOf("\\")+1);
      String key = name + " " + line[1];
      int count = 1;
      if (map.containsKey(key)) {
        count = map.get(key) + 1;
      }else{
        cur++;
        smap.put(key, cur);
      }
      map.put(key, count);
    }
    List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(map.entrySet());
    Collections.sort(list, new Comparator<Entry<String, Integer>>() {
      //升序排序
      public int compare(Entry<String, Integer> o1,
          Entry<String, Integer> o2) {
        int ret = o2.getValue().compareTo(o1.getValue());
        if (ret == 0) {
          return smap.get(o1.getKey()).compareTo(smap.get(o2.getKey()));
        }
        return ret;
      }

    });

    int count = 0;
    for (Map.Entry<String, Integer> mapping : list) {
      String[] lines= mapping.getKey().split(" ");
      int length=lines[0].length();
      if(length>16){
        lines[0]=lines[0].substring(length-16);
      }
      System.out.println(lines[0]+" "+lines[1] + " " + mapping.getValue());
      count++;
      if (count == 8) {
        break;
      }
    }
  }
}
