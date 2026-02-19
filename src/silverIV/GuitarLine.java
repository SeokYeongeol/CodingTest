package silverIV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1049
public class GuitarLine {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cutLine = Integer.parseInt(st.nextToken());
        int brandCnt = Integer.parseInt(st.nextToken());
        int minPackage = Integer.MAX_VALUE;
        int minEach = Integer.MAX_VALUE;
        int answer = 0;

        for (int i = 0; i < brandCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int mPackage = Integer.parseInt(st.nextToken());
            int mEach = Integer.parseInt(st.nextToken());

            minPackage = Math.min(minPackage, mPackage);
            minEach = Math.min(minEach, mEach);
        }

        while (cutLine > 0) {
            if ((minEach * 6) < minPackage) {
                cutLine--;
                answer += minEach;
            } else {
                if ((minEach * cutLine) > minPackage) {
                    cutLine -= 6;
                    answer += minPackage;
                } else {
                    cutLine--;
                    answer += minEach;
                }
            }
        }
        System.out.println(answer);
    }
}