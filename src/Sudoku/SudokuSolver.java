package Sudoku;

import java.awt.*;

public class SudokuSolver extends SudokuUI {
    private static int rowNo;
    private static int colNo;

    public static void main(String[] args) {
        initial();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        solve(board);
    }

    private static boolean solve(int[][] sudoku) {
        if (isSudokuComplete(sudoku)) {
            return true;
        }
        int valx = rowNo;
        int valy = colNo;
        for (int num = 1; num <= 9; num++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (isSafe(num, valx, valy, sudoku)) {
                sudoku[valx][valy] = num;
                b[valx][valy].setForeground(Color.BLACK);
                b[valx][valy].setFont(new Font("Times New Roman", Font.PLAIN, 20));
                b[valx][valy].setText(num + "");
                if (solve(sudoku)) {
                    return true;
                }
                sudoku[valx][valy] = 0;
                b[valx][valy].setText("");//backtracking step
            }
        }
        return false;
    }

    private static boolean isSudokuComplete(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] == 0) {
                    rowNo = i;
                    colNo = j;
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isSafe(int num, int valx, int valy, int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[valx][i] == num) {
                return false;
            }
            if (sudoku[i][valy] == num) {
                return false;
            }
        }
        int rStart = valx - (valx % 3);
        int cStart = valy - (valy % 3);
        for (int i = rStart; i < rStart + 3; i++) {
            for (int j = cStart; j < cStart + 3; j++) {
                if (sudoku[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}