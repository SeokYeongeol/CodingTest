package goldV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DeciphermentScript {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // Input
        int wLen = Integer.parseInt(st.nextToken());
        int sLen = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String W = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String S = st.nextToken();
        int count = 0;

        // Logic
        int[] wCount = new int[123];
        int[] sCount = new int[123];

        // First Setting
        for (int i = 0; i < wLen; i++) {
            wCount[W.charAt(i)]++;
            sCount[S.charAt(i)]++;
        }
        int match = 0;
        for (int i = 0; i < 123; i++) {
            if (wCount[i] == sCount[i]) match++;
        }
        if (match == 123) count++;

        // Sliding Start
        for (int i = wLen; i < sLen; i++) {
            int add = S.charAt(i);
            int remove = S.charAt(i-wLen);

            // Right Add
            sCount[add]++;
            if (sCount[add] == wCount[add]) match++;
            else if (sCount[add] == wCount[add] + 1) match--;

            // Left Remove
            sCount[remove]--;
            if (sCount[remove] == wCount[remove]) match++;
            else if (sCount[remove] == wCount[remove] - 1) match--;

            if (match == 123) count++;
        }
        System.out.println(count);
    }
}