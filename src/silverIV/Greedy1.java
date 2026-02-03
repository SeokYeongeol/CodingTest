package silverIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 11047
public class Greedy1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int coinCount = Integer.parseInt(st.nextToken());
        int amount = Integer.parseInt(st.nextToken());
        int cnt = 0;

        int[] coins = new int[coinCount];
        for (int i = 0; i < coinCount; i++) {
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = coinCount - 1; i >= 0; i--) {
            if (amount == 0) break;
            if (amount == coins[i]) {
                cnt++;
                break;
            } else if(coins[i] < amount) {
                cnt += (amount / coins[i]);
                amount %= coins[i];
            }
        }
        System.out.println(cnt);
    }
}
