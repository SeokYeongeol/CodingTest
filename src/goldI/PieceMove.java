package goldI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 1035
public class PieceMove {
    static char[][] pieces = new char[5][5];
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static List<int[]> starsCoordinate = new ArrayList<>();
    static List<int[]> starsComb = new ArrayList<>();
    static int minMove = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            pieces[i] = st.nextToken().toCharArray();
        }

        // 별 위치 좌표 입력
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (pieces[i][j] == '*') {
                    starsCoordinate.add(new int[]{i, j});
                }
            }
        }

        // 별들이 모두 연결돼있으면 0을 출력하고 끝냄
        if (isConnected(starsCoordinate)) {
            System.out.println(0);
            return;
        }
        
        combination(0, 0);
        System.out.println(minMove);
    }

    // 최소 이동 거리를 찾기 위한 후보 조합 생성 (DFS 알고리즘)
    private static void combination(int start, int depth) {
        if (depth == starsCoordinate.size()) {
            if (isConnected(starsComb)) calcDistance();
            return;
        }

        for (int i = start; i < 25; i++) {
            int x = i / 5;
            int y = i % 5;

            starsComb.add(new int[] {x, y});
            combination(i + 1, depth + 1);
            starsComb.remove(starsComb.size() - 1);
        }
    }

    // 최소 이동 거리 계산
    private static void calcDistance() {
        boolean[] used = new boolean[starsCoordinate.size()];
        perm(0, 0, used);
    }

    private static void perm(int depth, int sum, boolean[] used) {
        if (sum >= minMove) return;

        if (depth == starsCoordinate.size()) {
            minMove = Math.min(minMove, sum);
            return;
        }
        int[] s = starsCoordinate.get(depth);

        for (int i = 0; i < starsComb.size(); i++) {
            if (used[i]) continue;

            used[i] = true;
            int dist = Math.abs(s[0] - starsComb.get(i)[0])
                    + Math.abs(s[1] - starsComb.get(i)[1]);

            perm(depth + 1, sum + dist, used);
            used[i] = false;
        }
    }

    // 모두 연결됐는지 확인하고 리턴
    private static boolean isConnected(List<int[]> list) {
        boolean[][] map = new boolean[5][5];
        for (int[] arr : list) {
            map[arr[0]][arr[1]] = true;
        }

        visited = new boolean[5][5];
        Queue<int[]> queue = new LinkedList<>();
        int[] start = list.get(0);
        queue.add(start);
        visited[start[0]][start[1]] = true;

        int cnt = 1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if (x < 0 || y < 0 || x >= 5 || y >= 5) continue;
                if (!map[x][y] || visited[x][y]) continue;

                visited[x][y] = true;
                queue.add(new int[] {x, y});
                cnt++;
            }
        }
        return cnt == list.size();
    }
}
