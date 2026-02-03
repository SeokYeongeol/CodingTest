package silverIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 2606
public class Virus {
    static int computer;
    static int link;
    static int count = 0;
    static List<Integer>[] group;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        computer = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        link =  Integer.parseInt(st.nextToken());
        group = new ArrayList[computer + 1];
        boolean[] visited = new boolean[computer + 1];
        for (int i = 1; i <= computer; i++) {
            group[i] = new ArrayList<>();
        }

        for (int i = 1; i <= link; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            group[start].add(end);
            group[end].add(start);
        }
//        dfs(1, visited);
        bfs(1, visited);
        System.out.println(count);
    }

//    private static void dfs(int start, boolean[] visited) {
//        if (visited[start]) return;
//        visited[start] = true;
//
//        for (int v : group[start]) {
//            if (!visited[v]) {
//                count++;
//                dfs(v, visited);
//            }
//        }
//    }

    private static void bfs(int start, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i : group[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                    count++;
                }
            }
        }
    }
}
