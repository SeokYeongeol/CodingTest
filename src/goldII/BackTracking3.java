package goldII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 17136
public class BackTracking3 {
    static int[][] board = new int[10][10];
    static int[] colorPaper = {0, 5, 5, 5, 5, 5};
    static int count = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < board.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backtracking(0, 0);

        if (count == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(count);
    }

    private static void backtracking(int xy, int useCnt) {
        if (xy == 100) {
            count = Math.min(count, useCnt);
            return;
        }
        int x = xy % 10;
        int y = xy / 10;

        if (count <= useCnt) return;
        if (board[y][x] == 1) {
            for (int i = 5; i > 0; i--) {
                if (colorPaper[i] > 0 && check(x, y, i)) {
                    colorPaper[i]--;
                    fill(x, y, i, 0);
                    backtracking(xy+1, useCnt+1);
                    fill(x, y, i, 1);
                    colorPaper[i]++;
                }
            }
        } else backtracking(xy+1, useCnt);
    }

    private static void fill(int x, int y, int size, int num) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                board[i][j] = num;
            }
        }
    }

    private static boolean check(int x, int y, int size) {
        if (x + size > 10 || y + size > 10) return false;
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (board[i][j] != 1) return false;
            }
        }
        return true;
    }
}
