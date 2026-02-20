package silverIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1120
public class StringPractice {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        int diff = Integer.MAX_VALUE;

        int len = b.length() - a.length();
        for (int i = 0; i <= len; i++) {
            int checkDiff = 0;
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) != b.charAt(i + j)) checkDiff++;
            }
            diff = Math.min(diff, checkDiff);
        }
        System.out.println(diff);
    }
}
