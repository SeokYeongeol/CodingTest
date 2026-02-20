package silverI;

import java.util.InputMismatchException;
import java.util.Scanner;

// 백준 5525
public class IOIOI {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int count = 0;
        String S;
        try {
            S = sc.next();
            if (S.length() != M) throw new InputMismatchException();
        } catch (InputMismatchException ime) {
            throw new InputMismatchException("입력한 길이에 맞춰서 입력해주세요.");
        }

        int i = 0;
        int checkN = 0;
        while (i < M - 2) {
            if (S.charAt(i) == 'I' && S.charAt(i+1) == 'O'
                    && S.charAt(i+2) == 'I') {
                checkN++;
                if (checkN == N) {
                    count++;
                    checkN--;
                }
                i += 2;
            } else {
                checkN = 0;
                i++;
            }
        }
        System.out.println(count);
    }
}
