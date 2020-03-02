package com.github.iamwyc.hw;

import java.util.Scanner;

/**
 * @author iamwyc
 * @date 2020/2/7
 */
public class SuDu {


  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = 9;
    while (s.hasNext()) {
      boolean[][] row = new boolean[9][10];
      boolean[][] col = new boolean[9][10];
      boolean[][] block = new boolean[9][10];
      int[][] board = new int[n][n];
      for (int i = 0; i < 9; i++) {
        String[] line = s.nextLine().split(" ");
        for (int j = 0; j < 9; j++) {
          int num=Integer.parseInt(line[j]);
          board[i][j] = num;
          if (board[i][j] != 0) {
            row[i][num] = true;
            col[j][num] = true;
            block[i / 3 * 3 + j / 3][board[i][j]] = true;
          }
        }
      }
      dealMatrix(board, row, col, block, 0, 0);
      StringBuffer sb = new StringBuffer();
      for (int t = 0; t < n; t++) {
        for (int k = 0; k < n; k++) {
          sb.append(board[t][k]);
          sb.append(" ");
        }
        System.out.println(sb.toString());
        sb.setLength(0);
      }
    }
  }

  private static boolean dealMatrix(int[][] board, boolean[][] row, boolean[][] col,
      boolean[][] block, int i, int j) {
    // 找寻空位置
    while (board[i][j] != 0) {
      if (++j >= 9) {
        i++;
        j = 0;
      }
      if (i >= 9) {
        return true;
      }
    }
    for (int num = 1; num <= 9; num++) {
      int blockIndex = i / 3 * 3 + j / 3;
      if (!row[i][num] && !col[j][num] && !block[blockIndex][num]) {
        // 递归
        board[i][j] = num;
        row[i][num] = true;
        col[j][num] = true;
        block[blockIndex][num] = true;
        if (dealMatrix(board, row, col, block, i, j)) {
          return true;
        } else {
          // 回溯
          row[i][num] = false;
          col[j][num] = false;
          block[blockIndex][num] = false;
          board[i][j] = 0;
        }
      }
    }
    return false;
  }
}
