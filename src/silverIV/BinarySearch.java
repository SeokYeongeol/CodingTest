package silverIV;

import java.io.*;
import java.util.*;

// 백준 1920
public class BinarySearch {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] questionArr = new int[n];
        for (int i = 0; i < n; i++) {
            questionArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(questionArr);
        st = new StringTokenizer(br.readLine());

        int m =  Integer.parseInt(st.nextToken());
        int[] searchArr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            searchArr[i] = Integer.parseInt(st.nextToken());
        }

        int[] correctArr = new int[m];
        for (int i = 0; i < searchArr.length; i++) {
            boolean flag = false;
            int left = 0;
            int right = n - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (questionArr[mid] == searchArr[i]) {
                    flag = true;
                    break;
                }
                else if (questionArr[mid] > searchArr[i]) right = mid - 1;
                else left = mid + 1;
            }
            correctArr[i] = flag ? 1 : 0;
        }

        for (int i : correctArr) {
            System.out.println(i);
        }
    }
}
