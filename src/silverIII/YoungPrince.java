package silverIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1004
public class YoungPrince {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t =  Integer.parseInt(st.nextToken());
        int[] resultArr = new int[t];

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int myX = Integer.parseInt(st.nextToken());
            int myY = Integer.parseInt(st.nextToken());
            int goalX = Integer.parseInt(st.nextToken());
            int goalY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int t2 =  Integer.parseInt(st.nextToken());
            for (int j = 0; j < t2; j++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int radius = Integer.parseInt(st.nextToken());
                boolean start = Math.pow(myX - cx, 2) + Math.pow(myY - cy, 2) < Math.pow(radius, 2);
                boolean end = Math.pow(goalX - cx, 2) + Math.pow(goalY - cy, 2) < Math.pow(radius, 2);

                if (start != end) resultArr[i]++;
            }
        }

        for (int i : resultArr) {
            System.out.println(i);
        }
    }
}
