package silverIII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1051
public class NumberSquare {
    static int[][] rectangle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        rectangle = new int[col][row];

        // 직사각형 생성
        for (int i = 0; i < col; i++) {
            st = new StringTokenizer(br.readLine());
            char[] numArr = st.nextToken().toCharArray();
            for (int j = 0; j < row; j++) {
                rectangle[i][j] = Character.getNumericValue(numArr[j]);
            }
        }
        int maxLength = Math.min(row, col);
        int result = 1;

        // 정사각형 찾기
        while (maxLength > 1) {
            for (int i = 0; i <= col - maxLength; i++) {
                for (int j = 0; j <= row - maxLength; j++) {
                    int num1 = rectangle[i][j];
                    int num2 = rectangle[i][j+maxLength-1];
                    int num3 = rectangle[i+maxLength-1][j];
                    int num4 = rectangle[i+maxLength-1][j+maxLength-1];
                    if (num1 == num2 && num1 == num3 && num1 == num4) {
                        result = (int) Math.pow(maxLength, 2);
                        break;
                    }
                }
                if (result != 1) break;
            }
            if (result != 1) break;
            maxLength--;
        }
        System.out.println(result);
    }
}