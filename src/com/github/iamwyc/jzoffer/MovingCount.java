package com.github.iamwyc.jzoffer;

import java.util.Arrays;

/**
 * @author iamwyc
 * @date 2020/2/21
 */
public class MovingCount {

  public static void main(String[] args) {
    System.out.println(new MovingCount().movingCount(38, 15, 9));
  }

  int[] arr;

  int count = 0;

  public int movingCount(int m, int n, int k) {
    arr = new int[Math.max(m, n)];
    for (int i = 0; i < arr.length; i++) {
      int nn = i;
      int r = 0;
      while (nn > 0) {
        r += nn % 10;
        nn = nn / 10;
      }
      arr[i] = r;
    }

    boolean[][] getVisited = new boolean[m][n];
    dfs(getVisited, 0, 0, k);
    return count;
  }

  private void dfs(boolean[][] getVisited, int i, int j, int k) {
    if (i >= getVisited.length || j >= getVisited[0].length || i < 0 || j < 0) {
      return;
    }
    if (getVisited[i][j]) {
      return;
    }
    getVisited[i][j] = true;
    if (arr[i] + arr[j] > k) {
      return;
    }
    count++;
    dfs(getVisited, i + 1, j, k);
    dfs(getVisited, i - 1, j, k);
    dfs(getVisited, i, j + 1, k);
    dfs(getVisited, i, j - 1, k);
  }

}
