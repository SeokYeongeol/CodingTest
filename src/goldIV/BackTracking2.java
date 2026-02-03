package goldIV;

import java.util.Scanner;

// 백준 9663
public class BackTracking2 {
    static int n;
    static int[] board;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n];
        count = 0;
        backtracking(0);
        System.out.println(count);
    }

    private static void backtracking(int row) {
        if (row == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            board[row] = i;
            if (check(row)) {
                backtracking(row + 1);
            }
        }
    }

    private static boolean check(int row) {
        for (int i = 0; i < row; i++) {
            if (board[i] == board[row]) return false;
            if (Math.abs(row - i) == Math.abs(board[row] - board[i]))
                return false;
        }
        return true;
    }
}
