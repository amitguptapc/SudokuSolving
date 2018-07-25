package Sudoku;

import javax.swing.*;
import java.awt.*;

public class SudokuUI {
    public static int board[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}};
    public static JButton b[][];

    public static void initial() {
        JFrame f = new JFrame("Sudoku");
        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(500, 500));
        f.add(p);
        f.pack();
        p.setLayout(new GridLayout(9, 9));
        b = new JButton[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != 0) {
                    b[i][j] = new JButton(board[i][j] + "");
                    b[i][j].setForeground(Color.WHITE);
                    b[i][j].setBackground(Color.BLACK);
                    b[i][j].setFont(new Font("Times New Roman", Font.PLAIN, 20));
                }
                else {
                    b[i][j] = new JButton("");
                    b[i][j].setContentAreaFilled(false);
                }
                p.add(b[i][j]);
            }
        }
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }
}

