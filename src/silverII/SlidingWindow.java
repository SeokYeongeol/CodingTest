package silverII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 12891
public class SlidingWindow {
    static int[] myArr;
    static int[] checkArr;
    static int checkSecret;

    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());
         int s = Integer.parseInt(st.nextToken());  // 전체 문자열의 길이
         int p = Integer.parseInt(st.nextToken());  // 부분 문자열 길이
         int result = 0;
         myArr = new int[4];
         checkArr = new int[4];
         char[] a;
         checkSecret = 0;

         a = br.readLine().toCharArray();
         st = new StringTokenizer(br.readLine());
         for (int i = 0; i < 4; i++) {
             checkArr[i] = Integer.parseInt(st.nextToken());
             if (checkArr[i] == 0) {
                 checkSecret++;
             }
         }

         for (int i = 0; i < p; i++) {
             Add(a[i]);
         }
         if (checkSecret == 4) result++;

         // 슬라이딩 윈도우
         for (int i = p; i < s; i++) {
            int j = i - p;
            Add(a[i]);
            Remove(a[j]);
            if (checkSecret == 4) result++;
        }

         System.out.println("result : " + result);
    }

    /**
     * 만약 A, C, G, T 문자중 하나가 들어오면 myArr의 해당 인덱스를 +1
     * myArr의 해당 인덱스의 들어온 개수가 checkArr의 해당 인덱스와 일치하면 checkSecret을 +1
     * **/
    private static void Add(char a) {
        switch (a) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }

    /**
     * myArr의 해당 인덱스의 들어와 있는 개수가 checkArr의 해당 인덱스와 일치한 상태이면 checkSecret을 -1
     * 만약 A, C, G, T 문자중 하나가 들어오면 myArr의 해당 인덱스를 -1
     * **/
    private static void Remove(char a) {
        switch (a) {
            case 'A':
                if (myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }
}