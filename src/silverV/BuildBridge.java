package silverV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1010
public class BuildBridge {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int[] resultArr = new int[t];

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int[][] dp = new int[n+1][n+1];
            for (int j = 0; j <= n; j++) {
                dp[j][j] = 1;
                dp[j][0] = 1;
                dp[j][1] = j;
            }

            for (int j = 2; j <= n; j++) {
                for (int k = 1; k < j; k++) {
                    dp[j][k] = dp[j-1][k-1] + dp[j-1][k];
                }
            }
            resultArr[i] = dp[n][r];
        }

        for (int i : resultArr) {
            System.out.println(i);
        }
    }
}