package notes.algorithm.lcci.c16;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *  井字游戏
 *  https://leetcode-cn.com/problems/tic-tac-toe-lcci/
 * @author: wengchuqin
 * @create: 2020-06-26 22:03
 */
public class TicTacToeLCCI {
    @Test
    public void test() {
        String[] board = new String[]{
                "O X",
                " XO",
                "X O"};
        Assert.assertEquals("X", new Solution().tictactoe(board));
    }


    @Test
    public void test2() {
        String[] board = new String[]{
                " OOO",
                "    ",
                "OXXX",
                "XX O"};
        Assert.assertEquals("Pending", new Solution().tictactoe(board));
    }


    class Solution {
        Character EMP_TY = ' ';
        Character X = 'X';
        Character O = 'O';


        String Pending = "Pending";
        String Draw = "Draw";

        public String tictactoe(String[] board) {
            char[][] matrix = new char[board.length][];
            for (int i = 0; i < board.length; i++) {
                matrix[i] = new char[board[i].length()];
                char[] chars = board[i].toCharArray();
                for (int j = 0; j < board[i].length(); j++) {
                    matrix[i][j] = chars[j];
                }
            }


            List<Line> allLines = new ArrayList<>();
            //所有行
            for (int i = 0; i < board.length; i++) {
                Line line = new Line(matrix);
                for (int j = 0; j < board[i].length(); j++) {
                    line.addPoint(new Point(i, j));
                }
                allLines.add(line);
            }

            //所有列
            for (int i = 0; i < board.length; i++) {
                Line line = new Line(matrix);
                for (int j = 0; j < board[i].length(); j++) {
                    line.addPoint(new Point(j, i));
                }
                allLines.add(line);

            }

            //对角线
            Line line1 = new Line(matrix);
            Line line2 = new Line(matrix);
            for (int i = 0; i < board.length; i++) {
                line1.addPoint(new Point(i, i));
                line2.addPoint(new Point(i, board.length - 1 - i));
            }
            allLines.add(line1);
            allLines.add(line2);


            boolean haveEmpty = false;
            for (Line line : allLines) {
                String result = line.result();
                if (Objects.equals(result, X.toString()) || Objects.equals(result, O.toString())) {
                    return result;
                } else if (Objects.equals(result, Pending)) {
                    haveEmpty = true;
                }
            }
            return haveEmpty ? Pending : Draw;
        }

        class Line {

            List<Point> ps;
            int n;
            char[][] matrix;

            public Line(char[][] matrix) {
                this.n = matrix.length;
                this.matrix = matrix;
                ps = new ArrayList<>();
            }

            void addPoint(Point p) {
                ps.add(p);
            }

            String result() {
                Point fp = ps.get(0);
                char tmp = matrix[fp.x][fp.y];
                for (Point p : ps) {
                    char c = this.matrix[p.x][p.y];
                    if (c == EMP_TY) {
                        return Pending;
                    }
                    if (c != tmp) {
                        return Draw;
                    }
                }
                return Character.toString(tmp);
            }
        }

        class Point {
            int x;
            int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public String toString() {
                return String.format("(%s, %s)", x, y);
            }

        }


    }
}
