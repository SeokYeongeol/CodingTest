package silverIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1018
public class ChessPaint {
    private static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =  Integer.parseInt(st.nextToken());
        int m =  Integer.parseInt(st.nextToken());
        board = new char[n][m];
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            board[i] = st.nextToken().toCharArray();
        }

        for (int i = 0; i <= n-8; i++) {
            for (int j = 0; j <= m-8; j++) {
                result = Math.min(result, check(i, j));
            }
        }
        System.out.println(result);
    }

    private static int check(int x, int y) {
        int repaintB = 0;
        int repaintW = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if ((i + j) % 2 == 0) {
                    if (board[i][j] != 'B') repaintB++;
                    if (board[i][j] != 'W') repaintW++;
                } else {
                    if (board[i][j] != 'B') repaintW++;
                    if (board[i][j] != 'W') repaintB++;
                }
            }
        }
        return Math.min(repaintB, repaintW);
    }
}
