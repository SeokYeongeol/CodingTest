package silverII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 1012
public class OrganicCabbage {
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[] counts;
    static int cnt = 0;
    static int x;
    static int y;
    static int cabbage;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        counts = new int[t];

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            cabbage =  Integer.parseInt(st.nextToken());
            visited = new boolean[y][x];
            createBoard();

            for (int j = 0; j < cabbage; j++) {
                st = new StringTokenizer(br.readLine());
                int cabX = Integer.parseInt(st.nextToken());
                int cabY = Integer.parseInt(st.nextToken());
                board[cabY][cabX] = 1;
            }

            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    if (board[j][k] == 1 && !visited[j][k]) {
                        cnt++;
                        bfs(k, j);
                    }
                }
            }
            counts[i] = cnt;
            cnt = 0;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println(counts[i]);
        }
    }

    private static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i, j});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            visited[now[1]][now[0]] = true;

            for (int k = 0; k < 4; k++) {
                int x1 = now[0] + dx[k];
                int y1 = now[1] + dy[k];
                if (x1 >= 0 && y1 >= 0 && x1 < x && y1 < y) {
                    if (board[y1][x1] == 1 && !visited[y1][x1]) {
                        visited[y1][x1] = true;
                        q.add(new int[] {x1, y1});
                    }
                }
            }
        }
    }

    private static void createBoard() {
        board = new int[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                board[i][j] = 0;
            }
        }
    }
}
