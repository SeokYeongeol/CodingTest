package silverII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 1260
public class DfsBfs {
    static List<Integer>[] list;
    static int n;
    static int m;
    static int startPoint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        startPoint = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[n+1];
        list = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int start  = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            list[end].add(start);
        }
        for (int i = 1; i <= n; i++) {
            list[i].sort(Integer::compareTo);
        }
        dfs(startPoint, visited);
        System.out.println();
        bfs(startPoint);
    }

    private static void dfs(int sp, boolean[] visited) {
        if (visited[sp]) return;
        visited[sp] = true;
        System.out.print(sp + " ");
        for (int v : list[sp]) {
            if (!visited[v]) {
                dfs(v, visited);
            }
        }
    }

    private static void bfs(int sp) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sp);
        visited[sp] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");

            for (int v : list[now]) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }
}
