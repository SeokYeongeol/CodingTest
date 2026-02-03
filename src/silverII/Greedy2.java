package silverII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 1541
public class Greedy2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] calculation = line.split("-");
        int answer = 0;
        for (int i = 0; i < calculation.length; i++) {
            int temp = mySum(calculation[i]);

            if (i == 0) answer += temp;
            else answer -= temp;
        }
        System.out.println(answer);
    }

    private static int mySum(String str) {
        int sum = 0;
        String[] strNum = str.split("[+]");
        for (int i = 0; i < strNum.length; i++) {
            sum += Integer.parseInt(strNum[i]);
        }
        return sum;
    }
}
