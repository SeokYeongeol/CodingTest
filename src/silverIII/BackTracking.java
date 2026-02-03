package silverIII;

import java.util.*;

// 백준 15649
public class BackTracking {
    static int n, m;
    static int[] s;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        s = new int[n];
        visited = new boolean[n];
        backtracking(0);
    }

    private static void backtracking(int length) {
        if (length == m) {
            printArray();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                s[length] = i;
                backtracking(length + 1);
                visited[i] = false;
            }
        }
    }

    private static void printArray() {
        for (int i = 0; i < m; i++) {
            System.out.print(s[i]+1 + " ");
        }
        System.out.println();
    }
}