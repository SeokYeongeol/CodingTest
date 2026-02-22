package silverIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ClimbingStairs {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // Input
        int stairsCnt = Integer.parseInt(st.nextToken());
        int[] stairs = new int[stairsCnt + 1];
        for (int i = 1; i <= stairsCnt; i++) {
            st = new StringTokenizer(br.readLine());
            stairs[i] = Integer.parseInt(st.nextToken());
        }

        // Early Return
        if (stairsCnt == 1) {
            System.out.println(stairs[1]);
            return;
        } else if (stairsCnt == 2) {
            System.out.println(stairs[1] + stairs[2]);
            return;
        } else if (stairsCnt == 3) {
            System.out.println(Math.max(stairs[1] + stairs[3],
                    stairs[2] + stairs[3]));
            return;
        }

        // Logic
        int[] dp = new int[301];
        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];
        dp[3] = Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]);
        for (int i = 4; i <= stairsCnt; i++) {
            dp[i] = stairs[i] + Math.max(dp[i-2], dp[i-3] + stairs[i-1]);
        }
        System.out.println(dp[stairsCnt]);
    }
}