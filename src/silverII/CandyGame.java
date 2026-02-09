package silverII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 3085
public class CandyGame {
    static int n;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int result = 0;

        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            board[i] = st.nextToken().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < (n-1) && board[i][j] != board[i+1][j]) {
                    swap(i, j, i+1, j);
                    result = Math.max(result, count());
                    swap(i, j, i+1, j);
                }
                if (j < (n-1) && board[i][j] != board[i][j+1]) {
                    swap(i, j, i, j+1);
                    result = Math.max(result, count());
                    swap(i, j, i, j+1);
                }
            }
        }
        System.out.println(result);
    }

    private static int count() {
        int max = 1;

        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                if (board[i][j] == board[i][j-1]) cnt++;
                else cnt = 1;
                max = Math.max(max, cnt);
            }
        }

        for (int j = 0; j < n; j++) {
            int cnt = 1;
            for (int i = 1; i < n; i++) {
                if (board[i][j] == board[i-1][j]) cnt++;
                else cnt = 1;
                max = Math.max(max, cnt);
            }
        }
        return max;
    }

    private static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }
}
