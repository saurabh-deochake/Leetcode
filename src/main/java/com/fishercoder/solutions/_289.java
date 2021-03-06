package com.fishercoder.solutions;

/**
 * 289. Game of Life
 *
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life,
 * is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

 Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the
 following four rules (taken from the above Wikipedia article):

 Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 Any live cell with two or three live neighbors lives on to the next generation.
 Any live cell with more than three live neighbors dies, as if by over-population..
 Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 Write a function to compute the next state (after one update) of the board given its current state.

 Follow up:
 Could you solve it in-place? Remember that the board needs to be updated at the same time:
 You cannot update some cells first and then use their updated values to update other cells.
 In this question, we represent the board using a 2D array.
 In principle, the board is infinite, which would cause problems when the active area encroaches the
 border of the array. How would you address these problems?*/

public class _289 {
    public void gameOfLife(int[][] board) {
        int height = board.length;
        int width = board[0].length;
        int[][] next = new int[height][width];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int liveCellsCount = 0;
                //count all its live cells

                if (j + 1 < width && board[i][j + 1] == 1) {
                    liveCellsCount++;//right cell
                }
                if (j - 1 >= 0 && board[i][j - 1] == 1) {
                    liveCellsCount++;//left cell
                }
                if (i + 1 < height && board[i + 1][j] == 1) {
                    liveCellsCount++;//down cell
                }
                if (i - 1 >= 0 && board[i - 1][j] == 1) {
                    liveCellsCount++;//up cell
                }
                if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == 1) {
                    liveCellsCount++;//up left cell
                }
                if (i - 1 >= 0 && j + 1 < width && board[i - 1][j + 1] == 1) {
                    liveCellsCount++;//up right cell
                }
                if (i + 1 < height && j - 1 >= 0 && board[i + 1][j - 1] == 1) {
                    liveCellsCount++;//down left cell
                }
                if (i + 1 < height && j + 1 < width && board[i + 1][j + 1] == 1) {
                    liveCellsCount++;//down right cell
                }

                if (board[i][j] == 1) {
                    if (liveCellsCount > 3 || liveCellsCount < 2) {
                        next[i][j] = 0;
                    } else {
                        next[i][j] = 1;
                    }
                } else if (board[i][j] == 0) {
                    if (liveCellsCount == 3) {
                        next[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = next[i][j];
            }
        }
    }
}
